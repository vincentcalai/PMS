--------------------------------------------------------
--  DDL for Package Body PG_COMPUTE_PL
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PMS_APP"."PG_COMPUTE_PL" AS

  PROCEDURE compute_real_pl (
      p_portfolio      IN       VARCHAR2 := NULL,
      p_curr    IN       VARCHAR2 := NULL
   ) AS
   
   v_port_id   pms_port.id%TYPE    :=  '';
   v_hkd_curr  pms_mkt_exchg.curr%TYPE    :=  'HKD';
   v_usd_curr  pms_mkt_exchg.curr%TYPE    :=  'USD';
   v_sgd_curr  pms_mkt_exchg.curr%TYPE    :=  'SGD';
   v_forex_rate      pms_forex.last%TYPE    := 0; 

  cursor cur_real_pl is 
  select * from pms_real_pl r
  inner join pms_port p
  on r.port_id = p.id
  where p.port_name = p_portfolio;

  BEGIN
      select id into v_port_id from pms_port where port_name = p_portfolio;

     FOR rec IN cur_real_pl
      LOOP
           dbms_output.put_line('rec.dom_curr: ' || rec.dom_curr || ' p_curr: ' || p_curr);
           if rec.dom_curr = p_curr then
              update pms_real_pl set conv_profit_loss = rec.profit_loss where port_id = rec.port_id 
              and stock_sym = rec.stock_sym and trans_id = rec.trans_id;

              insert into pms_real_pl_tmp
              select TRANS_ID, PORT_ID, STOCK_SYM, p_curr, TOTAL_SHARE * AVG_COST, TOTAL_SHARE * SELL_PRICE, CONV_PROFIT_LOSS, 
              PROFIT_LOSS_PCT from pms_real_pl where stock_sym = rec.stock_sym and trans_id = rec.trans_id;

           else 
              if rec.dom_curr = v_usd_curr then
                select last into v_forex_rate from pms_forex where forex_sym = p_curr || '=X';
              else
                select last into v_forex_rate from pms_forex where forex_sym = rec.dom_curr || p_curr || '=X';
              end if;

              update pms_real_pl set conv_profit_loss = profit_loss * v_forex_rate 
              where port_id = rec.port_id and stock_sym = rec.stock_sym and trans_id = rec.trans_id;

              insert into pms_real_pl_tmp
              select TRANS_ID, PORT_ID, STOCK_SYM, p_curr, TOTAL_SHARE * AVG_COST * v_forex_rate, TOTAL_SHARE * SELL_PRICE * v_forex_rate, 
              CONV_PROFIT_LOSS, PROFIT_LOSS_PCT
              from pms_real_pl where stock_sym = rec.stock_sym and trans_id = rec.trans_id;

           end if;
      END LOOP; 

      compute_real_total_pl(v_port_id, p_curr);

      delete from pms_real_pl_tmp;

  END compute_real_pl;

  PROCEDURE compute_unreal_pl (
      p_portfolio      IN       VARCHAR2 := NULL,
      p_curr    IN       VARCHAR2 := NULL
   ) AS
   v_port_id   pms_port.id%TYPE    :=  '';
   v_hkd_curr  pms_mkt_exchg.curr%TYPE    :=  'HKD';
   v_usd_curr  pms_mkt_exchg.curr%TYPE    :=  'USD';
   v_sgd_curr  pms_mkt_exchg.curr%TYPE    :=  'SGD';
   v_forex_rate      pms_forex.last%TYPE    := 0;

  BEGIN
  
    delete from pms_unreal_pl;
    
    select id into v_port_id from PMS_PORT where port_name = p_portfolio;

    insert into pms_unreal_pl (PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, TOTAL_SHARE, AVG_PRICE, TOTAL_AMT, LAST_TRANS_PRICE, 
    MKT_VALUE, PROFIT_LOSS, PROFIT_LOSS_PCT)
    select PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, TOTAL_SHARE, AVG_PRICE, TOTAL_AMT, LAST_TRANS_PRICE, 
    MKT_VALUE, PROFIT_LOSS, PROFIT_LOSS_PCT from pms_port_hold where port_id = v_port_id;

    update pms_unreal_pl u set dom_curr =
    (select curr from pms_mkt_exchg e where u.stock_exchg = e.mkt_exchg_name);

    FOR rec IN (select * from pms_unreal_pl)
    LOOP
         dbms_output.put_line('rec.dom_curr: ' || rec.dom_curr || ' p_curr: ' || p_curr);
         if rec.dom_curr = p_curr then
            update pms_unreal_pl set conv_profit_loss = rec.profit_loss where stock_sym = rec.stock_sym;

            insert into pms_unreal_pl_tmp
            select port_id, stock_sym, p_curr, total_amt, mkt_value,
            conv_profit_loss, profit_loss_pct from pms_unreal_pl where stock_sym = rec.stock_sym;
         else 
            if rec.dom_curr = v_usd_curr then
              select last into v_forex_rate from pms_forex where forex_sym = p_curr || '=X';
            else
              select last into v_forex_rate from pms_forex where forex_sym = rec.dom_curr || p_curr || '=X';
            end if;

            update pms_unreal_pl set conv_profit_loss = profit_loss * v_forex_rate where stock_sym = rec.stock_sym;

            insert into pms_unreal_pl_tmp
            select port_id, stock_sym, p_curr, total_amt * v_forex_rate, mkt_value * v_forex_rate,
            conv_profit_loss, profit_loss_pct from pms_unreal_pl where stock_sym = rec.stock_sym;

         end if;
    END LOOP; 

    compute_unreal_total_pl(v_port_id, p_curr);

    delete from pms_unreal_pl_tmp;

  END compute_unreal_pl;

  PROCEDURE compute_real_total_pl (
      p_port_id      IN       NUMBER := NULL,
      p_curr    IN       VARCHAR2 := NULL
   ) AS
   begin 
      delete from pms_real_total_pl where port_id = p_port_id;

      insert into PMS_REAL_TOTAL_PL
      select PORT_ID, p_curr, sum(TOTAL_COST), sum(TOTAL_SOLD_AMT), sum(CONV_PROFIT_LOSS),sum(CONV_PROFIT_LOSS)/sum(TOTAL_COST) * 100
      from pms_real_pl_tmp where port_id = p_port_id group by port_id, p_curr;

   end compute_real_total_pl;


  PROCEDURE compute_unreal_total_pl (
        p_port_id      IN       NUMBER := NULL,
        p_curr    IN       VARCHAR2 := NULL
     ) AS
  begin 
      delete from pms_unreal_total_pl where port_id = p_port_id;

      insert into PMS_UNREAL_TOTAL_PL
      select port_id, p_curr, sum(total_amt), sum(mkt_value), sum(conv_profit_loss),sum(conv_profit_loss)/sum(total_amt) * 100
      from pms_unreal_pl_tmp where port_id = p_port_id group by port_id, p_curr;

  end compute_unreal_total_pl;


END PG_COMPUTE_PL;

/

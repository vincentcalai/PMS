--------------------------------------------------------
--  DDL for Procedure SP_POPULATE_PORT_HOLD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "PMS_APP"."SP_POPULATE_PORT_HOLD" (p_id IN NUMBER, p_port_id IN NUMBER, v_error OUT VARCHAR2) AS 

v_trans         pms_port_trans%rowtype;
v_stock_count   NUMBER := 0 ;
loop_count      NUMBER := 0;

BEGIN
    select * into v_trans from PMS_PORT_TRANS where id = p_id;
    dbms_output.put_line('id: ' ||  v_trans.id || ' port_id: ' || v_trans.port_id || ' stock_nam: ' || v_trans.stock_nam 
                        || ' stock_sym: ' || v_trans.stock_sym || ' action: ' || v_trans.action );

    select count(*) into v_stock_count from PMS_PORT_HOLD where port_id = p_port_id and stock_sym = v_trans.stock_sym;

IF v_trans.action = 'BUY' THEN
    IF v_stock_count > 0 THEN
      dbms_output.put_line('BUY action. there is code existing in this portfolio. stock_sym: ' || v_trans.stock_sym);

        update PMS_PORT_HOLD set 
        total_share = total_share + v_trans.no_of_share, 
        total_amt = total_amt + v_trans.total_amt
        where port_id = p_port_id and stock_sym = v_trans.stock_sym AND v_trans.action = 'BUY';

        update PMS_PORT_HOLD set avg_price = total_amt/total_share, last_trans_by = v_trans.created_by, 
        last_trans_dt = v_trans.created_dt where port_id = p_port_id and stock_sym = v_trans.stock_sym 
        and v_trans.action = 'BUY';
        
    ELSE
        dbms_output.put_line('BUY action. this stock does not exist in this portfolio. stock_sym: ' || v_trans.stock_sym);
        insert into PMS_PORT_HOLD 
        (port_id, stock_nam, stock_sym, stock_exchg, total_share, avg_price, total_amt, last_trans_by, last_trans_dt) values 
        (p_port_id, v_trans.stock_nam, v_trans.stock_sym, v_trans.stock_exchg, v_trans.no_of_share, v_trans.trans_price, v_trans.total_amt, 
        v_trans.created_by, v_trans.created_dt);
    END IF;
END IF;

IF v_trans.action = 'SELL' THEN
    IF v_stock_count > 0 THEN
         dbms_output.put_line('SELL action. there is code existing in this portfolio. stock_sym: ' || v_trans.stock_sym);
          
          --update existing portfolio holdings
          update PMS_PORT_HOLD set 
          total_share = total_share - v_trans.no_of_share
          where port_id = p_port_id and stock_sym = v_trans.stock_sym and v_trans.action = 'SELL';

          update PMS_PORT_HOLD set total_amt = total_share * avg_price, last_trans_by = v_trans.created_by, 
          last_trans_dt = v_trans.created_dt 
          where port_id = p_port_id and stock_sym = v_trans.stock_sym and v_trans.action = 'SELL';
          
          --populate realised profit
          insert into PMS_REAL_PL
          select v_trans.id, v_trans.port_id, v_trans.stock_nam, v_trans.stock_sym, v_trans.stock_exchg, mkt.curr, v_trans.no_of_share, v_trans.created_dt, 
          hold.avg_price, v_trans.trans_price, v_trans.total_amt - (hold.avg_price * v_trans.no_of_share), null, (v_trans.trans_price - hold.avg_price) /  hold.avg_price * 100 
          from PMS_PORT_HOLD hold 
          inner join PMS_MKT_EXCHG mkt
          on hold.stock_exchg = mkt.mkt_exchg_name
          where hold.port_id = p_port_id and hold.stock_sym = v_trans.stock_sym and v_trans.action = 'SELL';
          
    END IF;
END IF;

delete from PMS_PORT_HOLD where port_id = p_port_id and (total_share = 0 or total_amt = 0);

EXCEPTION
   WHEN OTHERS THEN
      rollback;
      v_error := 'An unexpected error occurred. ' || SQLERRM;
      dbms_output.put_line( SQLERRM );  
END SP_POPULATE_PORT_HOLD;

/

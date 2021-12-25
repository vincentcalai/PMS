--------------------------------------------------------
--  DDL for Package Body PG_DIV_PROCESS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PMS_APP"."PG_DIV_PROCESS" AS

  PROCEDURE SP_POPULATE_DIV_REC (p_id IN NUMBER, p_ex_date IN DATE, p_adj_div IN NUMBER) AS 

  nyse_exchg VARCHAR2(4) := 'NYSE';
  nasdaq_exchg VARCHAR2(6) := 'NASDAQ';
  otc_exchg VARCHAR2(3) := 'OTC';
  
  v_param_id NUMBER(10,0);
  
  f_us_div_tax NUMBER := 0.7;
  
  BEGIN
  
     select SQ_PMS_PORT_DIV_DET.nextval into v_param_id from dual;
     dbms_output.put_line('v_param_id: ' || v_param_id); 
     
     --For all US stocks, 30% dividend will be deducted. Other stocks will receive 100%
     insert into PMS_PORT_DIV_DET (ID, DIV_ID, PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, EX_DATE, NO_OF_SHARE, ADJ_DIV, DIV_PAYOUT)
     select v_param_id, ID, PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, p_ex_date, NO_OF_SHARE, p_adj_div, (NO_OF_SHARE * p_adj_div)
     from PMS_PORT_DIV div where ID = p_id
     and not exists(
      select * from PMS_PORT_DIV_DET det where div.id = p_id and div.port_id = det.port_id and div.stock_sym = det.stock_sym 
      and det.ex_date = p_ex_date
     );
     
     dbms_output.put_line('statement inserted.'); 
     
     update PMS_PORT_DIV_DET set DIV_PAYOUT = DIV_PAYOUT * f_us_div_tax where STOCK_EXCHG in (nyse_exchg, nasdaq_exchg, otc_exchg) and ID = v_param_id;
     
     update PMS_PORT_DIV_DET div set SGD_DIV_PAYOUT = CONVERT_TO_SGD(DIV_PAYOUT, (SELECT CURR FROM PMS_MKT_EXCHG mkt WHERE mkt.MKT_EXCHG_NAME = div.STOCK_EXCHG)) 
     where ID = v_param_id;
                    
  EXCEPTION
     WHEN OTHERS THEN
        rollback;
        raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
  END SP_POPULATE_DIV_REC;


  PROCEDURE SP_POPULATE_DIV_REC (p_id IN NUMBER, p_port_id IN NUMBER, p_ex_date IN DATE, p_adj_div IN NUMBER) AS
  
    nyse_exchg VARCHAR2(4) := 'NYSE';
    nasdaq_exchg VARCHAR2(6) := 'NASDAQ';
    otc_exchg VARCHAR2(3) := 'OTC';
    
    v_param_id NUMBER(10,0);
    v_count NUMBER;
    
    f_us_div_tax NUMBER := 0.7;
    
  BEGIN
     
     select count(*) into v_count from pms_port_div p inner join pms_port_div_det d on p.port_id = d.port_id and p.id = d.div_id where ex_date = p_ex_date and p.port_id = p_port_id and p.id = p_id;
     
     if  v_count = 0 then
        
         select SQ_PMS_PORT_DIV_DET.nextval into v_param_id from dual;
         dbms_output.put_line('v_param_id: ' || v_param_id); 
        
         insert into PMS_PORT_DIV_DET (ID, DIV_ID, PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, EX_DATE, NO_OF_SHARE, ADJ_DIV, DIV_PAYOUT)
         select v_param_id, p_id, p_port_id, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, p_ex_date, NO_OF_SHARE, p_adj_div, (NO_OF_SHARE * p_adj_div)
         from PMS_PORT_DIV div where id = p_id and port_id = p_port_id;
        
         --For all US stocks, 30% dividend will be deducted. Other stocks will receive 100%
         update PMS_PORT_DIV_DET set DIV_PAYOUT = DIV_PAYOUT * f_us_div_tax where STOCK_EXCHG in (nyse_exchg, nasdaq_exchg, otc_exchg) and ID = v_param_id;
      
         update PMS_PORT_DIV_DET div set SGD_DIV_PAYOUT = CONVERT_TO_SGD(DIV_PAYOUT, (SELECT CURR FROM PMS_MKT_EXCHG mkt WHERE mkt.MKT_EXCHG_NAME = div.STOCK_EXCHG)) 
         where ID = v_param_id;
        
      end if;
      
  END SP_POPULATE_DIV_REC;

END PG_DIV_PROCESS;

/

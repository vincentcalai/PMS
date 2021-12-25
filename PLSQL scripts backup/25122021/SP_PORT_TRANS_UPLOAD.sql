--------------------------------------------------------
--  DDL for Procedure SP_PORT_TRANS_UPLOAD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "PMS_APP"."SP_PORT_TRANS_UPLOAD" (p_id IN NUMBER, p_port_name IN VARCHAR2, v_error_log OUT VARCHAR2) AS 

v_trans_id number;
v_shares_left number;
v_port_id number;
v_newline VARCHAR2(2) := CHR (13) || CHR (10);
v_error VARCHAR2(1000);

BEGIN

select id into v_port_id from PMS_PORT where PORT_NAME = p_port_name;

for rec in (select * from PMS_LOAD_PORT_TRANS where upload_id = p_id order by id asc)
loop

  select SQ_PMS_PORT_TRANS.nextval into v_trans_id from dual;

  insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) 
  values (v_trans_id, v_port_id, rec.stock_nam, rec.stock_sym, rec.stock_exchg, rec.no_of_share, 
          rec.trans_price, rec.no_of_share * rec.trans_price, rec.created_by, rec.created_dt, rec.remarks, rec.action);

  if rec.action = 'SELL' then
    dbms_output.put_line('SELL action');
    SELECT NVL(MIN(total_share), 0) - rec.no_of_share into v_shares_left FROM pms_port_hold where port_id = v_port_id and stock_sym = rec.stock_sym;

    dbms_output.put_line('v_shares_left: ' || v_shares_left);

    if v_shares_left < 0 then
      v_error := 'There is insufficient shares in holdings to register the following SELL transaction: ' || rec.stock_nam 
      || ' : ' || rec.stock_sym || ' ' || rec.no_of_share || ' AT ' || rec.trans_price || v_newline; 

      dbms_output.put_line('v_error: ' || v_error);
    else
      SP_POPULATE_PORT_HOLD(v_trans_id, v_port_id, v_error);
      dbms_output.put_line('populate OK');
    end if;
  elsif rec.action = 'BUY' then
      dbms_output.put_line('BUY action');
      SP_POPULATE_PORT_HOLD(v_trans_id, v_port_id, v_error);
  end if;


      dbms_output.put_line('error output: ' || v_error);
      dbms_output.put_line('v_error_log output: ' || v_error_log);
   if v_error is not null then
      dbms_output.put_line('v_error is not null...');
      v_error_log := v_error_log || v_error;
      dbms_output.put_line('error final output: ' || v_error_log);
   end if;

end loop;

if v_error_log is not null then
  rollback;
end if;

EXCEPTION
   WHEN OTHERS THEN
      rollback;
      v_error_log := 'An unexpected error occurred. Please contact the administrator.' || SQLERRM;
      dbms_output.put_line( SQLERRM );  
END SP_PORT_TRANS_UPLOAD;

/

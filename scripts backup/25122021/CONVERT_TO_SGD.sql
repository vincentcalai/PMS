--------------------------------------------------------
--  DDL for Function CONVERT_TO_SGD
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "PMS_APP"."CONVERT_TO_SGD" ( v_val IN number, v_curr IN varchar2)
   RETURN number
IS
  sgd_curr  VARCHAR2(3) := 'SGD';
  usd_curr  VARCHAR2(3) := 'USD';
  hkd_curr   VARCHAR2(3) := 'HKD';
  
  usd_to_sgd_forex_sym   VARCHAR2(5) := 'SGD=X';
  hkd_to_sgd_forex_sym   VARCHAR2(8) := 'HKDSGD=X';
  
  v_convert_val NUMBER;
BEGIN

  IF v_curr = sgd_curr THEN
    RETURN v_val;
  ELSIF v_curr = usd_curr THEN
    select LAST into v_convert_val from PMS_FOREX where FOREX_SYM = usd_to_sgd_forex_sym;
  ELSIF v_curr = hkd_curr THEN
    select LAST into v_convert_val from PMS_FOREX where FOREX_SYM = hkd_to_sgd_forex_sym;
  ELSE
    raise_application_error(-20001,'An error was encountered. Invalid currency.');
  END IF;
  
  RETURN v_val * v_convert_val;

EXCEPTION
WHEN OTHERS THEN
   raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
END;

/

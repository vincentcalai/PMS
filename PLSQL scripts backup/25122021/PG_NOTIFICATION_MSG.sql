--------------------------------------------------------
--  DDL for Package Body PG_NOTIFICATION_MSG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PMS_APP"."PG_NOTIFICATION_MSG" AS

  PROCEDURE gen_watchlist_noti_msg AS
    
  type_up5pct VARCHAR2(15):= 'UP5PCT';
  type_up10pct VARCHAR2(15):= 'UP10PCT';
  type_down5pct VARCHAR2(15):= 'DOWN5PCT';
  type_down10pct VARCHAR2(15):= 'DOWN10PCT';
  type_custom_up_pct VARCHAR2(15) := 'CUSTOMUPPCT';
  type_custom_down_pct VARCHAR2(15) := 'CUSTOMDOWNPCT';
  
  type_dist VARCHAR(1) := 'D';
  type_prem VARCHAR(1) := 'P';

  BEGIN
    
    --trigger all other notification
    
    for rec in (select * from PMS_OTHER_NOTI where del_ind = 'N') 
    loop

        if rec.type = type_up5pct then 

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_up5pct, 'Notification Alert: Watchlist Stock UP 5%', 
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is up 5% today.', rec.username, sysdate); 

        elsif rec.type = type_up10pct then
          --dbms_output.put_line('Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is up 10% today.');

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_up10pct, 'Notification Alert: Watchlist Stock UP 10%', 
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is up 10% today.', rec.username, sysdate); 

        elsif rec.type = type_down5pct then 
          --dbms_output.put_line('Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is down 5% today.');

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_down5pct, 'Notification Alert: Watchlist Stock DOWN 5%', 
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is down 5% today.', rec.username, sysdate); 

        elsif rec.type = type_down10pct then
          --dbms_output.put_line('Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is down 10% today.');

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_down10pct, 'Notification Alert: Watchlist Stock DOWN 10%', 
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is down 10% today.', rec.username, sysdate);

        elsif rec.type = type_custom_down_pct and rec.custom_pct is not null then
          --dbms_output.put_line('Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is down 10% today.');

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_custom_down_pct, 'Notification Alert: Watchlist Stock DOWN ' || to_char(abs(rec.custom_pct),'FM990.00') || '%', 
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is down ' || to_char(abs(rec.custom_pct),'FM990.00') || '% today.'
          , rec.username, sysdate); 

        elsif rec.type = type_custom_up_pct and rec.custom_pct is not null then
          --dbms_output.put_line('Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is down 10% today.');

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_custom_up_pct, 'Notification Alert: Watchlist Stock UP ' || to_char(abs(rec.custom_pct),'FM990.00') || '%',
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is up ' || to_char(abs(rec.custom_pct),'FM990.00') || '% today.'
          , rec.username, sysdate); 

        end if;

        update PMS_OTHER_NOTI set del_ind = 'Y' where id = rec.id and watch_id = rec.watch_id and type = rec.type;

    end loop;
    
    --trigger all premium/discount notification
    
    for rec in (select * from PMS_DISC_PREM_NOTI where del_ind = 'N') 
    loop

        if rec.type = type_dist then 

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_dist, 'Notification Alert: Watchlist Stock at Discount', 
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is at discount of ' || rec.disc_prem_pct || '%.', rec.username, sysdate); 

        elsif rec.type = type_prem then

          insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
          (SQ_PMS_MSG.NEXTVAL, type_up10pct, 'Notification Alert: Watchlist Stock at Premium', 
          'Notification Alert: ' || rec.stock_nam || '[' || rec.stock_sym || ']' || ' is at premium of ' || rec.disc_prem_pct || '%.', rec.username, sysdate); 

        end if;

        update PMS_DISC_PREM_NOTI set del_ind = 'Y' where id = rec.id and watch_id = rec.watch_id and type = rec.type;

    end loop;

  END gen_watchlist_noti_msg;
  
  PROCEDURE gen_trigger_noti_msg
  (stock_nam IN VARCHAR2, 
   stock_sym IN VARCHAR2, 
   trigger_no_type IN VARCHAR2, 
   trigger_price IN NUMBER,
   username VARCHAR2) AS
  BEGIN
    if trigger_no_type = 'TRIG1' then
        insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
       (SQ_PMS_MSG.NEXTVAL, trigger_no_type, 'Notification Alert: Watchlist Stock hits 1st Trigger', 
       'Notification Alert: ' || stock_nam || '[' || stock_sym || ']' || ' hits 1st Trigger at ' || trigger_price || '.', username, sysdate);
    elsif trigger_no_type = 'TRIG2' then
        insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
       (SQ_PMS_MSG.NEXTVAL, trigger_no_type, 'Notification Alert: Watchlist Stock hits 2nd Trigger ', 
       'Notification Alert: ' || stock_nam || '[' || stock_sym || ']' || ' hits 2nd Trigger at ' || trigger_price || '.', username, sysdate);
    elsif trigger_no_type = 'TRIG3' then
        insert into PMS_MSG (ID, TYPE, SUBJECT, MSG, USERNAME, GEN_DT) values 
       (SQ_PMS_MSG.NEXTVAL, trigger_no_type, 'Notification Alert: Watchlist Stock hits 3rd Trigger ', 
       'Notification Alert: ' || stock_nam || '[' || stock_sym || ']' || ' hits 3rd Trigger at ' || trigger_price || '.', username, sysdate);
    end if;
  
  END gen_trigger_noti_msg;

END PG_NOTIFICATION_MSG;

/

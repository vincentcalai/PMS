--------------------------------------------------------
--  DDL for Package Body PG_WATCHLIST_NOTI
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PMS_APP"."PG_WATCHLIST_NOTI" AS
  
  PROCEDURE update_watchlist_entry_price(p_stock in VARCHAR2, p_last_price in NUMBER, p_change in NUMBER, p_change_pct in NUMBER) AS 

  BEGIN
    update PMS_WATCHLIST_ENTRY 
    set LAST_PRICE = p_last_price, 
        CHANGE = p_change,
        CHANGE_PCT = p_change_pct 
    where STOCK_SYM = p_stock;

    update PMS_WATCHLIST_ENTRY 
    set PREMIUM_DISC = ( (LAST_PRICE - TARGET_PRICE)/LAST_PRICE * 100 )
    where STOCK_SYM = p_stock;
    
    update PMS_TRIGGER_NOTI set LAST_PRICE = p_last_price where STOCK_SYM = p_stock; 

  END update_watchlist_entry_price;

  PROCEDURE init_notification (
      p_id                     IN       NUMBER,
      p_watch_id               IN       NUMBER,
      p_target_price           IN       NUMBER,
      p_user                   IN       VARCHAR2
   ) AS
  BEGIN

    insert into PMS_WATCHLIST_NOTI(ID, WATCH_ID, TRIGGER1_IND, TRIGGER1_PRICE, TRIGGER2_IND, TRIGGER2_PRICE, TRIGGER3_IND, TRIGGER3_PRICE, 
    UP_5PCT_IND, DOWN_5PCT_IND, UP_10PCT_IND, DOWN_10PCT_IND, CUSTOM_UP_IND, CUSTOM_UP_PCT, CUSTOM_DOWN_IND, CUSTOM_DOWN_PCT, 
    DISC_PREM_TYPE, DISC_PREM_PCT, LAST_MDFY_BY, LAST_MDFY_DT) values
    (p_id, p_watch_id, 'Y', p_target_price, 'N', null, 'N', null, 'N', 'N', 'N', 'N', 'N', null, 'N', null, 'N', null, p_user, sysdate);

    insert into PMS_TRIGGER_NOTI(ID, WATCH_ID, NXT_TRIGGER_NO, STOCK_NAM, STOCK_SYM, LAST_PRICE, NXT_TRIGGER_PRICE, USERNAME, GEN_DT)
    select p_id, p_watch_id, 1, STOCK_NAM, STOCK_SYM, LAST_PRICE, p_target_price, p_user, sysdate from PMS_WATCHLIST_ENTRY
    where id = p_id and watch_id = p_watch_id;

  END init_notification;

  PROCEDURE update_notification (
      p_id                 IN       NUMBER,
      p_watch_id           IN       NUMBER,
      p_trigger1_ind       IN       VARCHAR2,
      p_trigger1_price     IN       NUMBER,
      p_trigger2_ind       IN       VARCHAR2,
      p_trigger2_price     IN       NUMBER,
      p_trigger3_ind       IN       VARCHAR2,
      p_trigger3_price     IN       NUMBER,
      p_up_5pct_ind        IN       VARCHAR2,
      p_down_5pct_ind      IN       VARCHAR2,
      p_up_10pct_ind       IN       VARCHAR2,
      p_down_10pct_ind     IN       VARCHAR2,
      p_custom_up_ind      IN       VARCHAR2,
      p_custom_up_pct      IN       NUMBER,
      p_custom_down_ind    IN       VARCHAR2,
      p_custom_down_pct    IN       NUMBER,
      p_disc_prem_type     IN       VARCHAR2,
      p_disc_prem_pct      IN       NUMBER,
      p_last_mdfy_by       IN       VARCHAR2
   ) AS

  BEGIN

    --delete current notification for the stock if there is changes to notification
    delete from PMS_DISC_PREM_NOTI where id = p_id and watch_id = p_watch_id;
    delete from PMS_OTHER_NOTI where id = p_id and watch_id = p_watch_id;
    --delete from PMS_TRIGGER_NOTI where id = p_id and watch_id = p_watch_id;

    update PMS_WATCHLIST_NOTI set 
    trigger1_ind = p_trigger1_ind,
    trigger2_ind = p_trigger2_ind,
    trigger3_ind = p_trigger3_ind,
    up_5pct_ind = p_up_5pct_ind,
    down_5pct_ind = p_down_5pct_ind,
    up_10pct_ind = p_up_10pct_ind,
    down_10pct_ind = p_down_10pct_ind,
    custom_up_ind = p_custom_up_ind,
    custom_down_ind = p_custom_down_ind,
    disc_prem_type = p_disc_prem_type,
    last_mdfy_by = p_last_mdfy_by,
    last_mdfy_dt = sysdate
    where id = p_id and watch_id = p_watch_id;

    if p_trigger1_ind = 'Y' and p_trigger1_ind is not null then 
      update PMS_WATCHLIST_NOTI set trigger1_price = p_trigger1_price, last_mdfy_by = p_last_mdfy_by, last_mdfy_dt = sysdate where id = p_id and watch_id = p_watch_id;
      update PMS_WATCHLIST_ENTRY set target_price = p_trigger1_price, premium_disc = ((LAST_PRICE - p_trigger1_price)/LAST_PRICE * 100),
      last_mdfy_by = p_last_mdfy_by, last_mdfy_dt = sysdate
      where id = p_id and watch_id = p_watch_id;
      
--      insert into PMS_TRIGGER_NOTI (ID, WATCH_ID, NXT_TRIGGER_NO, STOCK_NAM, STOCK_SYM, LAST_PRICE, NXT_TRIGGER_PRICE, USERNAME, GEN_DT) 
--      select p_id, p_watch_id, 1, stock_nam, stock_sym, last_price, p_trigger1_price, last_mdfy_by, last_mdfy_dt from PMS_WATCHLIST_ENTRY 
--      where id = p_id and watch_id = p_watch_id;
    else
      update PMS_WATCHLIST_NOTI set trigger1_price = null where id = p_id and watch_id = p_watch_id;
    end if;
    if p_trigger2_ind = 'Y' and p_trigger2_ind is not null then 
      update PMS_WATCHLIST_NOTI set trigger2_price = p_trigger2_price where id = p_id and watch_id = p_watch_id;
    else
      update PMS_WATCHLIST_NOTI set trigger2_price = null where id = p_id and watch_id = p_watch_id;
    end if;
    if p_trigger3_ind = 'Y' and p_trigger3_ind is not null then 
      update PMS_WATCHLIST_NOTI set trigger3_price = p_trigger3_price where id = p_id and watch_id = p_watch_id;
    else
      update PMS_WATCHLIST_NOTI set trigger3_price = null where id = p_id and watch_id = p_watch_id;
    end if;
    if p_custom_up_ind = 'Y' and p_custom_up_ind is not null then 
      update PMS_WATCHLIST_NOTI set custom_up_pct = ROUND(p_custom_up_pct,2) where id = p_id and watch_id = p_watch_id;
    else
      update PMS_WATCHLIST_NOTI set custom_up_pct = null where id = p_id and watch_id = p_watch_id;
    end if;
    if p_custom_down_ind = 'Y' and p_custom_down_ind is not null then 
      update PMS_WATCHLIST_NOTI set custom_down_pct = ROUND(-p_custom_down_pct,2) where id = p_id and watch_id = p_watch_id;
    else
      update PMS_WATCHLIST_NOTI set custom_down_pct = null where id = p_id and watch_id = p_watch_id;
    end if;
    if p_disc_prem_type = 'P' and p_disc_prem_type != 'N' and p_disc_prem_type is not null then 
      update PMS_WATCHLIST_NOTI set disc_prem_pct = ROUND(p_disc_prem_pct,2) where id = p_id and watch_id = p_watch_id;
    elsif p_disc_prem_type = 'D' and p_disc_prem_type != 'N' and p_disc_prem_type is not null then
      update PMS_WATCHLIST_NOTI set disc_prem_pct = ROUND(-p_disc_prem_pct,2) where id = p_id and watch_id = p_watch_id;
    else
      update PMS_WATCHLIST_NOTI set disc_prem_pct = null where id = p_id and watch_id = p_watch_id;
    end if;
    
    --update next trigger price
    update PMS_TRIGGER_NOTI set nxt_trigger_no = 1, nxt_trigger_price = p_trigger1_price
    where nvl(nxt_trigger_no, 0) = 0 and nxt_trigger_price is null 
    and id = p_id and watch_id = p_watch_id;
    
    update PMS_TRIGGER_NOTI set nxt_trigger_price = p_trigger2_price
    where nxt_trigger_no = 2 and nxt_trigger_price is not null
    and id = p_id and watch_id = p_watch_id;
    
    update PMS_TRIGGER_NOTI set nxt_trigger_price = p_trigger3_price
    where nxt_trigger_no = 3 and nxt_trigger_price is not null
    and id = p_id and watch_id = p_watch_id;

    update_other_noti;

  END update_notification;

  PROCEDURE update_other_noti AS 

  v_custom_up_noti_exist          NUMBER := 0 ;
  v_custom_down_noti_exist        NUMBER := 0 ;
  v_prem_noti_exist               NUMBER := 0 ;
  v_disc_noti_exist               NUMBER := 0 ;

  cursor cur_user_watchlist is 
  select n.*, e.stock_nam, e.stock_sym, e.stock_exchg, e.last_price, 
  e.change, e.change_pct, e.target_price, e.premium_disc, e.remarks, w.name, w.created_by 
  from PMS_WATCHLIST_NOTI n
  inner join
  PMS_WATCHLIST w
  on n.watch_id = w.id
  inner join PMS_WATCHLIST_ENTRY e
  on n.watch_id = e.watch_id
  and w.id = e.watch_id
  and e.id = n.id;

  BEGIN
    for rec in cur_user_watchlist 
    loop

      if rec.UP_5PCT_IND = 'Y' and rec.change_pct >= 5 then
        insert into PMS_OTHER_NOTI (ID, WATCH_ID, WATCHLIST_NAM, TYPE, STOCK_NAM, STOCK_SYM, CHANGE_PCT, CUSTOM_PCT, USERNAME, DEL_IND, GEN_DT)
        select rec.id, rec.watch_id, rec.name, 'UP5PCT', rec.stock_nam, rec.stock_sym, rec.change_pct, null, rec.created_by, 'N', sysdate
        from dual
        where not exists (select 1 from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'UP5PCT');
      elsif rec.UP_5PCT_IND = 'N' then
        delete from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'UP5PCT';
      end if;

      if rec.DOWN_5PCT_IND = 'Y' and rec.change_pct <= -5 then
        insert into PMS_OTHER_NOTI (ID, WATCH_ID, WATCHLIST_NAM,TYPE, STOCK_NAM, STOCK_SYM, CHANGE_PCT, CUSTOM_PCT, USERNAME, DEL_IND, GEN_DT)
        select rec.id, rec.watch_id, rec.name, 'DOWN5PCT', rec.stock_nam, rec.stock_sym, rec.change_pct, null, rec.created_by, 'N', sysdate
        from dual
        where not exists (select 1 from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'DOWN5PCT');
      elsif rec.DOWN_5PCT_IND = 'N' then
        delete from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'DOWN5PCT';
      end if;

      if rec.UP_10PCT_IND = 'Y' and rec.change_pct >= 10 then
        insert into PMS_OTHER_NOTI (ID, WATCH_ID, WATCHLIST_NAM, TYPE, STOCK_NAM, STOCK_SYM, CHANGE_PCT, CUSTOM_PCT, USERNAME, DEL_IND, GEN_DT)
        select rec.id, rec.watch_id, rec.name, 'UP10PCT', rec.stock_nam, rec.stock_sym, rec.change_pct, null, rec.created_by, 'N', sysdate
        from dual
        where not exists (select 1 from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'UP10PCT');
      elsif rec.UP_10PCT_IND = 'N' then
        delete from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'UP10PCT';
      end if;

      if rec.DOWN_10PCT_IND = 'Y' and rec.change_pct <= -10 then
        insert into PMS_OTHER_NOTI (ID, WATCH_ID, WATCHLIST_NAM, TYPE, STOCK_NAM, STOCK_SYM, CHANGE_PCT, CUSTOM_PCT, USERNAME, DEL_IND, GEN_DT)
        select rec.id, rec.watch_id, rec.name, 'DOWN10PCT', rec.stock_nam, rec.stock_sym, rec.change_pct, null, rec.created_by, 'N', sysdate
        from dual
        where not exists (select 1 from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'DOWN10PCT');
      elsif rec.DOWN_10PCT_IND = 'N' then
        delete from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'DOWN10PCT';
      end if;

      if rec.CUSTOM_UP_IND = 'Y' and  rec.CHANGE_PCT >= rec.CUSTOM_UP_PCT then 
          select count(*) into v_custom_up_noti_exist from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'CUSTOMUPPCT';

          if v_custom_up_noti_exist > 0 then
            update PMS_OTHER_NOTI set custom_pct = rec.custom_up_pct where id = rec.id and watch_id = rec.watch_id and type = 'CUSTOMUPPCT';
          else
            insert into PMS_OTHER_NOTI (ID, WATCH_ID, WATCHLIST_NAM, TYPE, STOCK_NAM, STOCK_SYM, CHANGE_PCT, CUSTOM_PCT, USERNAME, DEL_IND, GEN_DT)
            select rec.id, rec.watch_id, rec.name, 'CUSTOMUPPCT', rec.stock_nam, rec.stock_sym, rec.change_pct, rec.custom_up_pct, rec.created_by, 'N', sysdate
            from dual;
          end if;
      elsif rec.CUSTOM_UP_IND = 'N' then
        delete from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'CUSTOMUPPCT';
      end if;

      if rec.CUSTOM_DOWN_IND = 'Y' and  rec.CHANGE_PCT <= rec.CUSTOM_DOWN_PCT then 
          select count(*) into v_custom_down_noti_exist from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'CUSTOMDOWNPCT';

          if v_custom_down_noti_exist > 0 then
            update PMS_OTHER_NOTI set custom_pct = rec.custom_down_pct where id = rec.id and watch_id = rec.watch_id and type = 'CUSTOMDOWNPCT';
          else
            insert into PMS_OTHER_NOTI (ID, WATCH_ID, WATCHLIST_NAM, TYPE, STOCK_NAM, STOCK_SYM, CHANGE_PCT, CUSTOM_PCT, USERNAME, DEL_IND, GEN_DT)
            select rec.id, rec.watch_id, rec.name, 'CUSTOMDOWNPCT', rec.stock_nam, rec.stock_sym, rec.change_pct, rec.custom_down_pct, rec.created_by, 'N', sysdate
            from dual;
          end if;
      elsif rec.CUSTOM_DOWN_IND = 'N' then
          delete from PMS_OTHER_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'CUSTOMDOWNPCT';
      end if;

      if rec.DISC_PREM_TYPE = 'P' and rec.PREMIUM_DISC >= rec.DISC_PREM_PCT then 
          select count(*) into v_prem_noti_exist from PMS_DISC_PREM_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'P';

          if v_prem_noti_exist > 0 then
            update PMS_DISC_PREM_NOTI set disc_prem_pct = rec.disc_prem_pct where id = rec.id and watch_id = rec.watch_id and type = 'P';
          else
            insert into PMS_DISC_PREM_NOTI (ID, WATCH_ID, WATCHLIST_NAM, TYPE, STOCK_NAM, STOCK_SYM, PREMIUM_DISC, DISC_PREM_PCT, USERNAME, GEN_DT, DEL_IND)
            select rec.id, rec.watch_id, rec.name, 'P', rec.stock_nam, rec.stock_sym, rec.premium_disc, rec.disc_prem_pct, rec.created_by, sysdate, 'N'
            from dual;
          end if;
--      elsif rec.DISC_PREM_TYPE != 'P' then
--          delete from PMS_DISC_PREM_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'P';
      end if;

      if rec.DISC_PREM_TYPE = 'D' and rec.PREMIUM_DISC <= rec.DISC_PREM_PCT then 
          select count(*) into v_disc_noti_exist from PMS_DISC_PREM_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'D';

          if v_disc_noti_exist > 0 then
            update PMS_DISC_PREM_NOTI set disc_prem_pct = rec.disc_prem_pct where id = rec.id and watch_id = rec.watch_id and type = 'D';
          else
            insert into PMS_DISC_PREM_NOTI (ID, WATCH_ID, WATCHLIST_NAM, TYPE, STOCK_NAM, STOCK_SYM, PREMIUM_DISC, DISC_PREM_PCT, USERNAME, GEN_DT, DEL_IND)
            select rec.id, rec.watch_id, rec.name, 'D', rec.stock_nam, rec.stock_sym, rec.premium_disc, rec.disc_prem_pct, rec.created_by, sysdate, 'N'
            from dual;
          end if;
--      elsif rec.DISC_PREM_TYPE != 'D' then
--          delete from PMS_DISC_PREM_NOTI where id = rec.id and watch_id = rec.watch_id and type = 'D';
      end if;

    end loop;
  END;
  
  PROCEDURE update_trigger_noti AS 
    v_type_trig_1 VARCHAR(5) := 'TRIG1';
    v_type_trig_2 VARCHAR(5) := 'TRIG2';
    v_type_trig_3 VARCHAR(5) := 'TRIG3';
  BEGIN
    for rec in (select t.ID, t.WATCH_ID, NXT_TRIGGER_NO, STOCK_NAM, STOCK_SYM, 
                LAST_PRICE, NXT_TRIGGER_PRICE, USERNAME, GEN_DT, TRIGGER1_IND, TRIGGER1_PRICE, TRIGGER2_IND, TRIGGER2_PRICE,	
                TRIGGER3_IND, TRIGGER3_PRICE, LAST_MDFY_BY, LAST_MDFY_DT
                from PMS_TRIGGER_NOTI t inner join PMS_WATCHLIST_NOTI w on t.id = w.id and t.watch_id = w.watch_id) 
    loop
        if rec.last_price <= rec.nxt_trigger_price and rec.nxt_trigger_no = 1 then 
            
            PG_NOTIFICATION_MSG.gen_trigger_noti_msg(rec.stock_nam, rec.stock_sym, 
            v_type_trig_1, rec.nxt_trigger_price, rec.username);
            
            --set up 2nd trigger if 1st trigger is triggered
            if rec.trigger2_ind = 'Y' then
                update PMS_TRIGGER_NOTI set nxt_trigger_no = 2, nxt_trigger_price = rec.TRIGGER2_PRICE 
                where id = rec.id and watch_id = rec.watch_id;
            else 
                update PMS_TRIGGER_NOTI set nxt_trigger_no = 0, nxt_trigger_price = null
                where id = rec.id and watch_id = rec.watch_id;
            end if;
            
        elsif rec.last_price <= rec.nxt_trigger_price and rec.nxt_trigger_no = 2 then 
            
            PG_NOTIFICATION_MSG.gen_trigger_noti_msg(rec.stock_nam, rec.stock_sym, 
            v_type_trig_2, rec.nxt_trigger_price, rec.username);
        
            --set up 3rd trigger if 2nd trigger is triggered
            if rec.trigger3_ind = 'Y' then
                update PMS_TRIGGER_NOTI set nxt_trigger_no = 3, nxt_trigger_price = rec.TRIGGER3_PRICE 
                where id = rec.id and watch_id = rec.watch_id;
            else 
                update PMS_TRIGGER_NOTI set nxt_trigger_no = 0, nxt_trigger_price = null
                where id = rec.id and watch_id = rec.watch_id;
            end if;
            
        elsif rec.last_price <= rec.nxt_trigger_price and rec.nxt_trigger_no = 3 then
            PG_NOTIFICATION_MSG.gen_trigger_noti_msg(rec.stock_nam, rec.stock_sym, 
            v_type_trig_3, rec.nxt_trigger_price, rec.username);
            
            update PMS_TRIGGER_NOTI set nxt_trigger_no = 0, nxt_trigger_price = null
            where id = rec.id and watch_id = rec.watch_id;
        end if;
    end loop;
  END;

  PROCEDURE delete_all_other_noti AS 
  BEGIN
    delete from PMS_OTHER_NOTI;
  END delete_all_other_noti;

END PG_WATCHLIST_NOTI;

/

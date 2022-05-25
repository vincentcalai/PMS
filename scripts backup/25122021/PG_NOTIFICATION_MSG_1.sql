--------------------------------------------------------
--  DDL for Package PG_NOTIFICATION_MSG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PMS_APP"."PG_NOTIFICATION_MSG" AS 

    PROCEDURE gen_watchlist_noti_msg;
    
    PROCEDURE gen_trigger_noti_msg(stock_nam VARCHAR2, stock_sym VARCHAR2, 
    trigger_no_type VARCHAR2, trigger_price NUMBER, username VARCHAR2);

END PG_NOTIFICATION_MSG;

/

--------------------------------------------------------
--  DDL for Package PG_WATCHLIST_NOTI
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PMS_APP"."PG_WATCHLIST_NOTI" AS 

   PROCEDURE update_watchlist_entry_price(
      p_stock in VARCHAR2, 
      p_last_price in NUMBER, 
      p_change in NUMBER, 
      p_change_pct in NUMBER
   );

   PROCEDURE init_notification (
        p_id                 IN       NUMBER,
        p_watch_id           IN       NUMBER,
        p_target_price       IN       NUMBER,
        p_user               IN       VARCHAR2
   );

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
    );

    PROCEDURE update_other_noti;
    
    PROCEDURE update_trigger_noti;

    PROCEDURE delete_all_other_noti;
    
END PG_WATCHLIST_NOTI;

/

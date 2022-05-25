--------------------------------------------------------
--  DDL for Procedure SP_COMPUTE_HOLD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "PMS_APP"."SP_COMPUTE_HOLD" (p_stock in VARCHAR2, p_last_trans_price in NUMBER) AS 

BEGIN
  update PMS_PORT_HOLD set last_trans_price = p_last_trans_price where stock_sym = p_stock;

  update PMS_PORT_HOLD set mkt_value = last_trans_price * total_share;

  update PMS_PORT_HOLD set profit_loss = mkt_value - total_amt, profit_loss_pct = (mkt_value - total_amt)/total_amt * 100;

END SP_COMPUTE_HOLD;

/

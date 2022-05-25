--------------------------------------------------------
--  File created - Wednesday-May-25-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PMS_CASH_SOL
--------------------------------------------------------

  CREATE TABLE "PMS_CASH_SOL" 
   (	"ID" NUMBER(10,0), 
	"USR_NAM" VARCHAR2(20), 
	"BANK_BAL" NUMBER(20,0)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_DISC_PREM_NOTI
--------------------------------------------------------

  CREATE TABLE "PMS_DISC_PREM_NOTI" 
   (	"ID" NUMBER(10,0), 
	"WATCH_ID" NUMBER(10,0), 
	"TYPE" VARCHAR2(15), 
	"WATCHLIST_NAM" VARCHAR2(100), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"PREMIUM_DISC" NUMBER(7,2), 
	"DISC_PREM_PCT" NUMBER(15,2), 
	"USERNAME" VARCHAR2(25), 
	"GEN_DT" TIMESTAMP (6), 
	"DEL_IND" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_FOREX
--------------------------------------------------------

  CREATE TABLE "PMS_FOREX" 
   (	"ID" NUMBER, 
	"FOREX_NAME" VARCHAR2(10), 
	"FOREX_SYM" VARCHAR2(10), 
	"FOREX_DESC" VARCHAR2(100), 
	"LAST" NUMBER, 
	"CHANGE" NUMBER, 
	"CHANGE_PCT" NUMBER, 
	"SUFFIX" VARCHAR2(5), 
	"LAST_UPDATED_DT" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_INDEX
--------------------------------------------------------

  CREATE TABLE "PMS_INDEX" 
   (	"ID" NUMBER, 
	"INDEX_SYM" VARCHAR2(10), 
	"INDEX_NAME" VARCHAR2(50), 
	"LAST" NUMBER, 
	"CHANGE" NUMBER, 
	"CHANGE_PCT" NUMBER, 
	"LAST_UPDATED_DT" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_LOAD_DIV
--------------------------------------------------------

  CREATE TABLE "PMS_LOAD_DIV" 
   (	"ID" NUMBER(10,0), 
	"UPLOAD_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"NO_OF_SHARE" NUMBER(15,0), 
	"DATE_PURCHASE" DATE, 
	"DATE_SOLD" DATE, 
	"CURR_HOLD_IND" VARCHAR2(1), 
	"CREATED_BY" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_LOAD_DIV_UPLOAD
--------------------------------------------------------

  CREATE TABLE "PMS_LOAD_DIV_UPLOAD" 
   (	"UPLOAD_ID" NUMBER(12,0), 
	"PORT_NAME" VARCHAR2(25), 
	"FILE_DATA" BLOB, 
	"FILE_NAME" VARCHAR2(87), 
	"LOG_DATA" CLOB, 
	"LOG_NAME" VARCHAR2(87), 
	"CREATED_BY" VARCHAR2(20), 
	"CREATED_DT" TIMESTAMP (6), 
	"STATUS" VARCHAR2(1), 
	"DEL_IND" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_LOAD_PORT_TRANS
--------------------------------------------------------

  CREATE TABLE "PMS_LOAD_PORT_TRANS" 
   (	"ID" NUMBER(10,0), 
	"UPLOAD_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"NO_OF_SHARE" NUMBER(15,0), 
	"TRANS_PRICE" NUMBER(7,3), 
	"ACTION" VARCHAR2(4), 
	"CREATED_BY" VARCHAR2(20), 
	"CREATED_DT" DATE, 
	"REMARKS" VARCHAR2(100)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_LOAD_PORT_UPLOAD
--------------------------------------------------------

  CREATE TABLE "PMS_LOAD_PORT_UPLOAD" 
   (	"UPLOAD_ID" NUMBER(12,0), 
	"PORT_NAME" VARCHAR2(25), 
	"FILE_DATA" BLOB, 
	"FILE_NAME" VARCHAR2(87), 
	"LOG_DATA" CLOB, 
	"LOG_NAME" VARCHAR2(87), 
	"CREATED_BY" VARCHAR2(20), 
	"CREATED_DT" TIMESTAMP (6), 
	"STATUS" VARCHAR2(1), 
	"DEL_IND" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_MKT_EXCHG
--------------------------------------------------------

  CREATE TABLE "PMS_MKT_EXCHG" 
   (	"MKT_EXCHG_NAME" VARCHAR2(10), 
	"MKT_EXCHG_DESC" VARCHAR2(100), 
	"CURR" VARCHAR2(5), 
	"SUFFIX" VARCHAR2(5), 
	"GPHY" VARCHAR2(6)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_MSG
--------------------------------------------------------

  CREATE TABLE "PMS_MSG" 
   (	"ID" NUMBER(10,0), 
	"TYPE" VARCHAR2(25), 
	"SUBJECT" VARCHAR2(100), 
	"MSG" VARCHAR2(1000), 
	"USERNAME" VARCHAR2(25), 
	"GEN_DT" TIMESTAMP (6), 
	"DEL_IND" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_OTHER_NOTI
--------------------------------------------------------

  CREATE TABLE "PMS_OTHER_NOTI" 
   (	"ID" NUMBER(10,0), 
	"WATCH_ID" NUMBER(10,0), 
	"TYPE" VARCHAR2(15), 
	"WATCHLIST_NAM" VARCHAR2(100), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"CHANGE_PCT" NUMBER(7,2), 
	"CUSTOM_PCT" NUMBER(15,2), 
	"USERNAME" VARCHAR2(25), 
	"GEN_DT" TIMESTAMP (6), 
	"DEL_IND" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_PORT
--------------------------------------------------------

  CREATE TABLE "PMS_PORT" 
   (	"ID" NUMBER(10,0), 
	"PORT_NAME" VARCHAR2(25), 
	"CREATED_BY" VARCHAR2(20), 
	"CREATED_DT" DATE, 
	"LAST_MDFY_BY" VARCHAR2(20), 
	"LAST_MDFY_DT" TIMESTAMP (6), 
	"REMARKS" VARCHAR2(100)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_PORT_DIV
--------------------------------------------------------

  CREATE TABLE "PMS_PORT_DIV" 
   (	"ID" NUMBER(10,0), 
	"PORT_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"NO_OF_SHARE" NUMBER(20,0), 
	"DATE_PURCHASE" DATE, 
	"DATE_SOLD" DATE, 
	"CURR_HOLD_IND" VARCHAR2(1), 
	"CREATED_BY" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_PORT_DIV_DET
--------------------------------------------------------

  CREATE TABLE "PMS_PORT_DIV_DET" 
   (	"ID" NUMBER(10,0), 
	"DIV_ID" NUMBER(10,0), 
	"PORT_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"EX_DATE" DATE, 
	"NO_OF_SHARE" NUMBER(20,0), 
	"ADJ_DIV" NUMBER(15,7), 
	"DIV_PAYOUT" NUMBER(15,2), 
	"SGD_DIV_PAYOUT" NUMBER(15,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_PORT_HOLD
--------------------------------------------------------

  CREATE TABLE "PMS_PORT_HOLD" 
   (	"PORT_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"TOTAL_SHARE" NUMBER(15,0), 
	"AVG_PRICE" NUMBER(7,3), 
	"TOTAL_AMT" NUMBER(15,2), 
	"LAST_TRANS_PRICE" NUMBER(7,3), 
	"MKT_VALUE" NUMBER(15,2), 
	"PROFIT_LOSS" NUMBER(15,2), 
	"PROFIT_LOSS_PCT" NUMBER(7,2), 
	"LAST_TRANS_BY" VARCHAR2(20), 
	"LAST_TRANS_DT" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_PORT_TRANS
--------------------------------------------------------

  CREATE TABLE "PMS_PORT_TRANS" 
   (	"ID" NUMBER(10,0), 
	"PORT_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"NO_OF_SHARE" NUMBER(15,0), 
	"TRANS_PRICE" NUMBER(7,3), 
	"TOTAL_AMT" NUMBER(15,2), 
	"CREATED_BY" VARCHAR2(20), 
	"CREATED_DT" DATE, 
	"REMARKS" VARCHAR2(100), 
	"ACTION" VARCHAR2(4)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_REAL_PL
--------------------------------------------------------

  CREATE TABLE "PMS_REAL_PL" 
   (	"TRANS_ID" NUMBER(10,0), 
	"PORT_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"DOM_CURR" VARCHAR2(6), 
	"TOTAL_SHARE" NUMBER(15,0), 
	"SELL_DT" DATE, 
	"AVG_COST" NUMBER(7,3), 
	"SELL_PRICE" NUMBER(7,3), 
	"PROFIT_LOSS" NUMBER(15,2), 
	"CONV_PROFIT_LOSS" NUMBER(15,2), 
	"PROFIT_LOSS_PCT" NUMBER(7,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_REAL_PL_TMP
--------------------------------------------------------

  CREATE TABLE "PMS_REAL_PL_TMP" 
   (	"TRANS_ID" NUMBER(10,0), 
	"PORT_ID" NUMBER(10,0), 
	"STOCK_SYM" VARCHAR2(10), 
	"CONVERT_CURR" VARCHAR2(6), 
	"TOTAL_COST" NUMBER(15,2), 
	"TOTAL_SOLD_AMT" NUMBER(15,2), 
	"CONV_PROFIT_LOSS" NUMBER(15,2), 
	"PROFIT_LOSS_PCT" NUMBER(7,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_REAL_TOTAL_PL
--------------------------------------------------------

  CREATE TABLE "PMS_REAL_TOTAL_PL" 
   (	"PORT_ID" NUMBER(10,0), 
	"CONVERT_CURR" VARCHAR2(8), 
	"TOTAL_COST" NUMBER(15,2), 
	"TOTAL_SOLD_AMT" NUMBER(15,2), 
	"CONV_PROFIT_LOSS" NUMBER(15,2), 
	"PROFIT_LOSS_PCT" NUMBER(7,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_STOCK_CURR_EXCHG_SPEC
--------------------------------------------------------

  CREATE TABLE "PMS_STOCK_CURR_EXCHG_SPEC" 
   (	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"DOM_CURR" VARCHAR2(6)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_TRIGGER_NOTI
--------------------------------------------------------

  CREATE TABLE "PMS_TRIGGER_NOTI" 
   (	"ID" NUMBER(10,0), 
	"WATCH_ID" NUMBER(10,0), 
	"NXT_TRIGGER_NO" NUMBER(1,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"LAST_PRICE" NUMBER(15,3), 
	"NXT_TRIGGER_PRICE" NUMBER(15,3), 
	"GEN_DT" TIMESTAMP (6), 
	"USERNAME" VARCHAR2(25)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_UNREAL_PL
--------------------------------------------------------

  CREATE TABLE "PMS_UNREAL_PL" 
   (	"PORT_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"DOM_CURR" VARCHAR2(6), 
	"TOTAL_SHARE" NUMBER(15,0), 
	"AVG_PRICE" NUMBER(7,3), 
	"TOTAL_AMT" NUMBER(15,2), 
	"LAST_TRANS_PRICE" NUMBER(7,3), 
	"MKT_VALUE" NUMBER(15,2), 
	"PROFIT_LOSS" NUMBER(15,2), 
	"CONV_PROFIT_LOSS" NUMBER(15,2), 
	"PROFIT_LOSS_PCT" NUMBER(7,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_UNREAL_PL_TMP
--------------------------------------------------------

  CREATE TABLE "PMS_UNREAL_PL_TMP" 
   (	"PORT_ID" NUMBER(10,0), 
	"STOCK_SYM" VARCHAR2(10), 
	"CONVERT_CURR" VARCHAR2(6), 
	"TOTAL_AMT" NUMBER(15,2), 
	"MKT_VALUE" NUMBER(15,2), 
	"CONV_PROFIT_LOSS" NUMBER(15,2), 
	"PROFIT_LOSS_PCT" NUMBER(7,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_UNREAL_TOTAL_PL
--------------------------------------------------------

  CREATE TABLE "PMS_UNREAL_TOTAL_PL" 
   (	"PORT_ID" NUMBER(10,0), 
	"CONVERT_CURR" VARCHAR2(8), 
	"TOTAL_AMT" NUMBER(15,2), 
	"MKT_VALUE" NUMBER(15,2), 
	"CONV_PROFIT_LOSS" NUMBER(15,2), 
	"PROFIT_LOSS_PCT" NUMBER(7,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_USR
--------------------------------------------------------

  CREATE TABLE "PMS_USR" 
   (	"ID" NUMBER(10,0), 
	"USR_NAM" VARCHAR2(20), 
	"PWD" VARCHAR2(100), 
	"ROLES" VARCHAR2(100), 
	"EMAIL" VARCHAR2(100), 
	"CONTACT_NO" VARCHAR2(30), 
	"DEL_IND" VARCHAR2(1), 
	"CREATED_BY" VARCHAR2(20), 
	"CREATED_DT" DATE
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_USR_ROLE
--------------------------------------------------------

  CREATE TABLE "PMS_USR_ROLE" 
   (	"ID" NUMBER(10,0), 
	"ROLE" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_WATCHLIST
--------------------------------------------------------

  CREATE TABLE "PMS_WATCHLIST" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(50), 
	"REMARKS" VARCHAR2(100), 
	"CREATED_BY" VARCHAR2(20), 
	"CREATED_DT" DATE, 
	"LAST_MDFY_BY" VARCHAR2(20), 
	"LAST_MDFY_DT" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_WATCHLIST_ENTRY
--------------------------------------------------------

  CREATE TABLE "PMS_WATCHLIST_ENTRY" 
   (	"ID" NUMBER(10,0), 
	"WATCH_ID" NUMBER(10,0), 
	"STOCK_NAM" VARCHAR2(100), 
	"STOCK_SYM" VARCHAR2(10), 
	"STOCK_EXCHG" VARCHAR2(6), 
	"LAST_PRICE" NUMBER(15,3), 
	"CHANGE" NUMBER(15,2), 
	"CHANGE_PCT" NUMBER(7,2), 
	"TARGET_PRICE" NUMBER(15,3), 
	"PREMIUM_DISC" NUMBER(7,2), 
	"REMARKS" VARCHAR2(100), 
	"LAST_MDFY_BY" VARCHAR2(25), 
	"LAST_MDFY_DT" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Table PMS_WATCHLIST_NOTI
--------------------------------------------------------

  CREATE TABLE "PMS_WATCHLIST_NOTI" 
   (	"ID" NUMBER(10,0), 
	"WATCH_ID" NUMBER(10,0), 
	"TRIGGER1_IND" VARCHAR2(1), 
	"TRIGGER1_PRICE" NUMBER(15,3), 
	"TRIGGER2_IND" VARCHAR2(1), 
	"TRIGGER2_PRICE" NUMBER(15,3), 
	"TRIGGER3_IND" VARCHAR2(1), 
	"TRIGGER3_PRICE" NUMBER(15,3), 
	"UP_5PCT_IND" VARCHAR2(1), 
	"DOWN_5PCT_IND" VARCHAR2(1), 
	"UP_10PCT_IND" VARCHAR2(1), 
	"DOWN_10PCT_IND" VARCHAR2(1), 
	"CUSTOM_UP_IND" VARCHAR2(1), 
	"CUSTOM_UP_PCT" NUMBER(7,2), 
	"CUSTOM_DOWN_IND" VARCHAR2(1), 
	"CUSTOM_DOWN_PCT" NUMBER(7,2), 
	"DISC_PREM_TYPE" VARCHAR2(1), 
	"DISC_PREM_PCT" NUMBER(7,2), 
	"LAST_MDFY_BY" VARCHAR2(25), 
	"LAST_MDFY_DT" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_LOAD_DIV
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_LOAD_DIV"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 127 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_LOAD_DIV_UPLOAD
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_LOAD_DIV_UPLOAD"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 674 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_LOAD_PORT_TRANS
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_LOAD_PORT_TRANS"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 2346 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_LOAD_PORT_UPLOAD
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_LOAD_PORT_UPLOAD"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 602 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_MSG
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_MSG"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 709 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_PORT
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_PORT"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 456 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_PORT_DIV
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_PORT_DIV"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 236 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_PORT_DIV_DET
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_PORT_DIV_DET"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 827 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_PORT_TRANS
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_PORT_TRANS"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 2976 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_USR
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_USR"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 81 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_WATCHLIST
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_WATCHLIST"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 83 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_PMS_WATCHLIST_ENTRY
--------------------------------------------------------

   CREATE SEQUENCE  "SQ_PMS_WATCHLIST_ENTRY"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 466 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
REM INSERTING into PMS_CASH_SOL
SET DEFINE OFF;
Insert into PMS_CASH_SOL (ID,USR_NAM,BANK_BAL) values (1,'choonann',12300);
Insert into PMS_CASH_SOL (ID,USR_NAM,BANK_BAL) values (2,'testuser',0);
Insert into PMS_CASH_SOL (ID,USR_NAM,BANK_BAL) values (3,'admin',50000);
REM INSERTING into PMS_DISC_PREM_NOTI
SET DEFINE OFF;
REM INSERTING into PMS_FOREX
SET DEFINE OFF;
Insert into PMS_FOREX (ID,FOREX_NAME,FOREX_SYM,FOREX_DESC,LAST,CHANGE,CHANGE_PCT,SUFFIX,LAST_UPDATED_DT) values (1,'USD/SGD','SGD=X','Forex Rate: USD to SGD',1.3722,-0.00068,-0.05,'=X',to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_FOREX (ID,FOREX_NAME,FOREX_SYM,FOREX_DESC,LAST,CHANGE,CHANGE_PCT,SUFFIX,LAST_UPDATED_DT) values (2,'SGD/USD','SGDUSD=X','Forex Rate: SGD to USD',0.7287567,0.0003609,0.05,'=X',to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_FOREX (ID,FOREX_NAME,FOREX_SYM,FOREX_DESC,LAST,CHANGE,CHANGE_PCT,SUFFIX,LAST_UPDATED_DT) values (3,'HKD/SGD','HKDSGD=X','Forex Rate: HKD to SGD',0.17478,-0.00013,-0.07,'=X',to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_FOREX (ID,FOREX_NAME,FOREX_SYM,FOREX_DESC,LAST,CHANGE,CHANGE_PCT,SUFFIX,LAST_UPDATED_DT) values (4,'SGD/HKD','SGDHKD=X','Forex Rate: SGD to HKD',5.7194,0.0074,0.13,'=X',to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_FOREX (ID,FOREX_NAME,FOREX_SYM,FOREX_DESC,LAST,CHANGE,CHANGE_PCT,SUFFIX,LAST_UPDATED_DT) values (5,'USD/HKD','HKD=X','Forex Rate: USD to HKD',7.84962,0.00042,0.01,'=X',to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_FOREX (ID,FOREX_NAME,FOREX_SYM,FOREX_DESC,LAST,CHANGE,CHANGE_PCT,SUFFIX,LAST_UPDATED_DT) values (6,'HKD/USD','HKDUSD=X','Forex Rate: HKD to USD',0.1273947,-0.00000682,-0.01,'=X',to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
REM INSERTING into PMS_INDEX
SET DEFINE OFF;
Insert into PMS_INDEX (ID,INDEX_SYM,INDEX_NAME,LAST,CHANGE,CHANGE_PCT,LAST_UPDATED_DT) values (1,'^GSPC','S&P 500',3885.15,-88.6,-2.23,to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_INDEX (ID,INDEX_SYM,INDEX_NAME,LAST,CHANGE,CHANGE_PCT,LAST_UPDATED_DT) values (2,'^DJI','Dow Jones Industrial Average',31452.24,-428,-1.34,to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_INDEX (ID,INDEX_SYM,INDEX_NAME,LAST,CHANGE,CHANGE_PCT,LAST_UPDATED_DT) values (3,'^IXIC','NASDAQ Composite',11128.314,-406.96,-3.53,to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_INDEX (ID,INDEX_SYM,INDEX_NAME,LAST,CHANGE,CHANGE_PCT,LAST_UPDATED_DT) values (4,'^HSI','Hang Seng Index',20112.1,-357.96,-1.75,to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_INDEX (ID,INDEX_SYM,INDEX_NAME,LAST,CHANGE,CHANGE_PCT,LAST_UPDATED_DT) values (5,'^STI','
Straits Times Index',3195.04,-18.61,-0.58,to_timestamp('24-MAY-22 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
REM INSERTING into PMS_LOAD_DIV
SET DEFINE OFF;
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (4,606,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N',null);
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (12,616,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (75,671,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (76,671,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (77,671,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (80,671,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('09-MAR-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (82,671,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (83,671,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (84,671,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (87,671,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (88,671,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('04-AUG-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (111,673,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (112,673,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (113,673,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (116,673,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('09-MAR-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (118,673,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (119,673,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (120,673,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (123,673,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (124,673,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('04-AUG-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (5,607,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (6,608,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (7,609,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (10,612,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (14,618,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (55,670,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (56,670,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (57,670,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (58,670,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (59,670,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (60,670,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (61,670,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('03-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (62,670,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('03-SEP-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (63,670,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (64,670,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (65,670,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (66,670,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (67,670,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (68,670,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (69,670,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (70,670,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('04-AUG-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (71,670,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (72,670,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('07-SEP-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (73,671,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (74,671,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (78,671,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (79,671,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (81,671,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (85,671,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (86,671,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (89,671,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (90,671,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('07-SEP-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (93,672,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (94,672,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (95,672,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (96,672,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (97,672,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (99,672,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (105,672,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (107,672,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (108,672,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('07-SEP-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (109,673,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (110,673,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (114,673,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (115,673,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (117,673,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (121,673,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (122,673,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (125,673,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (126,673,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('07-SEP-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (11,615,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (15,621,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-20','DD-MON-RR'),to_date('11-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (16,622,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-20','DD-MON-RR'),to_date('11-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (18,666,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),null,'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (52,669,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('04-AUG-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (53,669,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (54,669,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('07-SEP-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (8,610,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (9,611,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (13,617,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1900,to_date('10-OCT-19','DD-MON-RR'),to_date('10-OCT-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (17,665,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),null,'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (19,668,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (20,668,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (21,668,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (22,668,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (23,668,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (24,668,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (25,668,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('03-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (26,668,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('03-SEP-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (27,668,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (28,668,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (29,668,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (30,668,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (31,668,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (32,668,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (33,668,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (34,668,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('04-AUG-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (35,668,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (36,668,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('07-SEP-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (37,669,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (38,669,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (39,669,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (40,669,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (41,669,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (42,669,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (43,669,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('03-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (44,669,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('03-SEP-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (45,669,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (46,669,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (47,669,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (48,669,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (49,669,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (50,669,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (51,669,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (91,672,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (92,672,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (98,672,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('09-MAR-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (100,672,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (101,672,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (102,672,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (103,672,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (104,672,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
Insert into PMS_LOAD_DIV (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (106,672,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('04-AUG-20','DD-MON-RR'),to_date('22-AUG-21','DD-MON-RR'),'Y','choonann');
REM INSERTING into PMS_LOAD_DIV_UPLOAD
SET DEFINE OFF;
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (628,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.36.37.557000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (660,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.37.17.118000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (661,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.41.27.322000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (662,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.42.52.203000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (663,'New Portfolio','myDividend',null,'choonann',to_timestamp('22-AUG-21 11.44.50.548000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'P','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (664,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.46.37.905000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (665,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.50.52.521000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (666,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.54.36.234000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (667,'New Portfolio','myDividend',null,'choonann',to_timestamp('22-AUG-21 11.57.24.642000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'P','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (668,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 12.00.20.620000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (669,'My Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 12.09.39.171000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (670,'Load Div Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.02.25.991000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (671,'My Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.06.02.618000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (672,'My Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.07.27.464000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (673,'My Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.08.46.795000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (606,'Test Dividend','myDividend','myDividend.txt','choonann',to_timestamp('21-AUG-21 10.07.43.520000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (607,'Test Dividend','myDividend','myDividend.txt','choonann',to_timestamp('21-AUG-21 10.08.38.327000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (608,'Load Dividend Portfolio','myDividend','myDividend.txt','choonann',to_timestamp('21-AUG-21 12.41.48.513000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (609,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 12.53.27.933000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (612,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 05.57.08.033000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (613,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 06.00.28.723000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (617,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 06.40.46.209000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (621,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.26.41.373000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (622,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.29.40.500000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (623,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.38.02.038000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (625,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.41.01.164000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (629,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.37.18.119000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (630,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.38.30.569000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (602,'Test Dividend','myDividend','myDividend.txt','choonann',to_timestamp('15-AUG-21 11.05.01.096000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (614,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 06.00.44.328000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (615,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 06.05.40.230000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (616,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 06.39.20.235000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (619,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.25.12.417000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (620,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.26.03.247000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (624,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.40.15.411000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (626,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.42.43.806000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (627,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 07.43.15.683000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (631,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.38.57.349000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (632,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.40.00.768000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (633,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.40.37.874000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (634,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.41.08.795000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (635,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.41.29.812000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (636,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.42.29.942000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (637,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 08.46.03.132000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (603,'Test Dividend','myDividend','myDividend.txt','choonann',to_timestamp('15-AUG-21 11.09.43.302000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (604,'Test Dividend','myDividend','myDividend.txt','choonann',to_timestamp('15-AUG-21 11.11.34.674000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (605,'Test Dividend','myDividend','myDividend.txt','choonann',to_timestamp('21-AUG-21 09.50.59.436000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (638,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 09.11.06.511000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (639,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 09.15.12.611000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (640,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.02.39.910000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (641,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.03.53.110000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (642,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.04.29.798000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (643,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.10.01.893000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (644,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.11.05.385000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (645,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.12.29.413000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (646,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.15.52.339000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (647,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.17.01.712000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (648,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.23.28.462000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (610,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 12.54.42.027000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (611,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 12.55.57.851000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (618,'Load Dividend Portfolio','myDividend','myDividend','choonann',to_timestamp('21-AUG-21 06.49.08.762000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (649,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.25.46.666000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (650,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.27.22.158000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (651,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.28.22.918000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (652,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.31.13.798000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (653,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.32.46.907000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (654,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.33.36.866000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (655,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.33.52.854000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (656,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.34.37.212000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (657,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.35.08.131000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (658,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.35.31.165000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_DIV_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (659,'New Portfolio','myDividend','myDividend','choonann',to_timestamp('22-AUG-21 11.36.53.589000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
REM INSERTING into PMS_LOAD_PORT_TRANS
SET DEFINE OFF;
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (1995,585,'CapitaLand Limited','C31.SI','SGX',1500,3.48,'BUY','choonann',to_date('10-SEP-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2000,585,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2005,585,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,'BUY','choonann',to_date('30-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2010,585,'CapitaLand Limited','C31.SI','SGX',1500,3.58,'SELL','choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2015,585,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.78,'SELL','choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2020,585,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,'BUY','choonann',to_date('03-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2025,585,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,'BUY','choonann',to_date('28-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2030,585,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,'BUY','choonann',to_date('11-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2035,585,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,'BUY','choonann',to_date('18-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2040,585,'Alphabet Inc.','GOOG','NASDAQ',1,2270,'SELL','choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2041,586,'Microsoft Corporation','MSFT','NASDAQ',1,280,'SELL','choonann',to_date('01-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2198,599,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2201,599,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2202,599,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2205,599,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2206,599,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,'BUY','choonann',to_date('15-NOV-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2209,599,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,'BUY','choonann',to_date('19-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2210,599,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,'BUY','choonann',to_date('30-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2213,599,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2214,599,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2217,599,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,'SELL','choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2218,599,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.975,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2221,599,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2222,599,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2225,599,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,'BUY','choonann',to_date('03-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2226,599,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,'BUY','choonann',to_date('04-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2229,599,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,'BUY','choonann',to_date('30-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2230,599,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,'BUY','choonann',to_date('28-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2233,599,'Tencent Holdings Limited','0700.HK','HKEX',100,515,'BUY','choonann',to_date('09-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2234,599,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,'BUY','choonann',to_date('09-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2237,599,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.452,'BUY','choonann',to_date('23-FEB-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2238,599,'JD.com, Inc.','JD','NASDAQ',10,78.7,'BUY','choonann',to_date('28-APR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2241,599,'JD.com, Inc.','JD','NASDAQ',27,73.8,'BUY','choonann',to_date('21-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2242,599,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,'BUY','choonann',to_date('27-JUL-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2245,599,'Alphabet Inc.','GOOG','NASDAQ',1,2270,'SELL','choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2337,601,'JD.com, Inc.','JD','NASDAQ',10,78.7,'BUY','choonann',to_date('28-APR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2338,601,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,'BUY','choonann',to_date('13-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2339,601,'iShares Hang Seng TECH ETF','3067.HK','HKEX',1000,15.8,'BUY','choonann',to_date('14-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2340,601,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,'BUY','choonann',to_date('18-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2341,601,'JD.com, Inc.','JD','NASDAQ',27,73.8,'BUY','choonann',to_date('21-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2342,601,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,'BUY','choonann',to_date('27-JUL-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2343,601,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,'SELL','choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2344,601,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,'SELL','choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2345,601,'Alphabet Inc.','GOOG','NASDAQ',1,2270,'SELL','choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (1993,585,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (1996,585,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (1998,585,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.91,'BUY','choonann',to_date('23-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2001,585,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,'BUY','choonann',to_date('15-NOV-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2003,585,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,'BUY','choonann',to_date('16-DEC-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2006,585,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,'BUY','choonann',to_date('02-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2008,585,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2011,585,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2013,585,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.97,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2016,585,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2018,585,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2021,585,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,'BUY','choonann',to_date('04-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2023,585,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2026,585,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,'BUY','choonann',to_date('27-JUN-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2028,585,'Tencent Holdings Limited','0700.HK','HKEX',100,515,'BUY','choonann',to_date('09-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2031,585,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.1,'BUY','choonann',to_date('28-DEC-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2033,585,'JD.com, Inc.','JD','NASDAQ',10,78.7,'BUY','choonann',to_date('28-APR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2036,585,'JD.com, Inc.','JD','NASDAQ',27,73.8,'BUY','choonann',to_date('21-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2038,585,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,'SELL','choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2042,587,'Microsoft Corporation','MSFT','NASDAQ',1,280,'SELL','choonann',to_date('01-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2044,588,'Microsoft Corporation','MSFT','NASDAQ',2,250,'BUY','choonann',to_date('01-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2150,598,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2151,598,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2152,598,'CapitaLand Limited','C31.SI','SGX',1500,3.48,'BUY','choonann',to_date('10-SEP-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2153,598,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2154,598,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2155,598,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.905,'BUY','choonann',to_date('23-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2156,598,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2157,598,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2158,598,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,'BUY','choonann',to_date('15-NOV-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2159,598,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,'BUY','choonann',to_date('12-MAR-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2160,598,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,'BUY','choonann',to_date('16-DEC-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2161,598,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,'BUY','choonann',to_date('19-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2162,598,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,'BUY','choonann',to_date('30-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2163,598,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,'BUY','choonann',to_date('02-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2164,598,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,'BUY','choonann',to_date('23-MAR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2165,598,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2166,598,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2167,598,'CapitaLand Limited','C31.SI','SGX',1500,3.58,'SELL','choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2168,598,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2169,598,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,'SELL','choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2170,598,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.975,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2171,598,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2172,598,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.775,'SELL','choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2173,598,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2174,598,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2175,598,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2176,598,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,'BUY','choonann',to_date('19-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2177,598,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,'BUY','choonann',to_date('03-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2178,598,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,'BUY','choonann',to_date('04-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2179,598,'Microsoft Corporation','MSFT','NASDAQ',13,165,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2180,598,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2181,598,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,'BUY','choonann',to_date('30-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2182,598,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,'BUY','choonann',to_date('28-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2183,598,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,'BUY','choonann',to_date('27-JUN-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2184,598,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,'BUY','choonann',to_date('08-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2185,598,'Tencent Holdings Limited','0700.HK','HKEX',100,515,'BUY','choonann',to_date('09-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2186,598,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,'BUY','choonann',to_date('09-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2187,598,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,'BUY','choonann',to_date('11-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2188,598,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.102,'BUY','choonann',to_date('28-DEC-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2189,598,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.452,'BUY','choonann',to_date('23-FEB-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2190,598,'JD.com, Inc.','JD','NASDAQ',10,78.7,'BUY','choonann',to_date('28-APR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2191,598,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,'BUY','choonann',to_date('13-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2192,598,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,'BUY','choonann',to_date('18-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2193,598,'JD.com, Inc.','JD','NASDAQ',27,73.8,'BUY','choonann',to_date('21-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2194,598,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,'BUY','choonann',to_date('27-JUL-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2195,598,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,'SELL','choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2196,598,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,'SELL','choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2197,598,'Alphabet Inc.','GOOG','NASDAQ',1,2270,'SELL','choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2199,599,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2203,599,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.905,'BUY','choonann',to_date('23-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2207,599,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,'BUY','choonann',to_date('12-MAR-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2211,599,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,'BUY','choonann',to_date('02-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2215,599,'CapitaLand Limited','C31.SI','SGX',1500,3.58,'SELL','choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2219,599,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2223,599,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2227,599,'Microsoft Corporation','MSFT','NASDAQ',13,165,'BUY','choonann',to_date('08-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (1997,585,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2002,585,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,'BUY','choonann',to_date('12-MAR-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2007,585,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,'BUY','choonann',to_date('23-MAR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2012,585,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,'SELL','choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2017,585,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2022,585,'Microsoft Corporation','MSFT','NASDAQ',13,165,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2027,585,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,'BUY','choonann',to_date('08-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2032,585,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.45,'BUY','choonann',to_date('23-FEB-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2037,585,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,'BUY','choonann',to_date('27-JUL-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2045,589,'Microsoft Corporation','MSFT','NASDAQ',2,250,'BUY','choonann',to_date('01-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2046,589,'Microsoft Corporation','MSFT','NASDAQ',1,280,'SELL','choonann',to_date('01-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2054,596,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2055,596,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2056,596,'CapitaLand Limited','C31.SI','SGX',1500,3.48,'BUY','choonann',to_date('10-SEP-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2057,596,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2058,596,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2059,596,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.905,'BUY','choonann',to_date('23-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2060,596,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2061,596,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2062,596,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,'BUY','choonann',to_date('15-NOV-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2063,596,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,'BUY','choonann',to_date('12-MAR-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2064,596,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,'BUY','choonann',to_date('16-DEC-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2065,596,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,'BUY','choonann',to_date('19-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2066,596,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,'BUY','choonann',to_date('30-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2067,596,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,'BUY','choonann',to_date('02-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2068,596,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,'BUY','choonann',to_date('23-MAR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2069,596,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2070,596,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2071,596,'CapitaLand Limited','C31.SI','SGX',1500,3.58,'SELL','choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2072,596,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2073,596,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,'SELL','choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2074,596,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.975,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2075,596,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2076,596,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.775,'SELL','choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2077,596,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2078,596,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2079,596,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2080,596,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,'BUY','choonann',to_date('19-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2081,596,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,'BUY','choonann',to_date('03-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2082,596,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,'BUY','choonann',to_date('04-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2083,596,'Microsoft Corporation','MSFT','NASDAQ',13,165,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2084,596,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2085,596,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,'BUY','choonann',to_date('30-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2086,596,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,'BUY','choonann',to_date('28-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2087,596,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,'BUY','choonann',to_date('27-JUN-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2088,596,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,'BUY','choonann',to_date('08-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2089,596,'Tencent Holdings Limited','0700.HK','HKEX',100,515,'BUY','choonann',to_date('09-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2090,596,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,'BUY','choonann',to_date('09-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2091,596,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,'BUY','choonann',to_date('11-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2092,596,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.102,'BUY','choonann',to_date('28-DEC-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2093,596,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.452,'BUY','choonann',to_date('23-FEB-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2094,596,'JD.com, Inc.','JD','NASDAQ',10,78.7,'BUY','choonann',to_date('28-APR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2095,596,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,'BUY','choonann',to_date('13-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2096,596,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,'BUY','choonann',to_date('18-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2097,596,'JD.com, Inc.','JD','NASDAQ',27,73.8,'BUY','choonann',to_date('21-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2098,596,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,'BUY','choonann',to_date('27-JUL-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2099,596,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,'SELL','choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2100,596,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,'SELL','choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2101,596,'Alphabet Inc.','GOOG','NASDAQ',1,2270,'SELL','choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2102,597,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2103,597,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2104,597,'CapitaLand Limited','C31.SI','SGX',1500,3.48,'BUY','choonann',to_date('10-SEP-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2105,597,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2106,597,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2107,597,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.905,'BUY','choonann',to_date('23-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2108,597,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2109,597,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2110,597,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,'BUY','choonann',to_date('15-NOV-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2111,597,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,'BUY','choonann',to_date('12-MAR-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2112,597,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,'BUY','choonann',to_date('16-DEC-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2113,597,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,'BUY','choonann',to_date('19-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2114,597,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,'BUY','choonann',to_date('30-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2115,597,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,'BUY','choonann',to_date('02-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2116,597,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,'BUY','choonann',to_date('23-MAR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2117,597,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2118,597,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2119,597,'CapitaLand Limited','C31.SI','SGX',1500,3.58,'SELL','choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2047,590,'Facebook, Inc.','FB','NASDAQ',20,300,'BUY','otheruser',to_date('10-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2051,593,'Facebook, Inc.','FB','NASDAQ',20,300,'BUY','admin',to_date('10-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2052,593,'Facebook, Inc.','FB','NASDAQ',20,300,'BUY','choonann',to_date('10-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2053,593,'Facebook, Inc.','FB','NASDAQ',20,300,'BUY','testuser1',to_date('10-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2120,597,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2121,597,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,'SELL','choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2122,597,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.975,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2123,597,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2124,597,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.775,'SELL','choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2125,597,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2126,597,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2127,597,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2128,597,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,'BUY','choonann',to_date('19-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2129,597,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,'BUY','choonann',to_date('03-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2130,597,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,'BUY','choonann',to_date('04-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2131,597,'Microsoft Corporation','MSFT','NASDAQ',13,165,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2132,597,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,'BUY','choonann',to_date('04-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2133,597,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,'BUY','choonann',to_date('30-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2134,597,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,'BUY','choonann',to_date('28-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2135,597,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,'BUY','choonann',to_date('27-JUN-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2136,597,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,'BUY','choonann',to_date('08-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2137,597,'Tencent Holdings Limited','0700.HK','HKEX',100,515,'BUY','choonann',to_date('09-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2138,597,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,'BUY','choonann',to_date('09-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2139,597,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,'BUY','choonann',to_date('11-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2140,597,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.102,'BUY','choonann',to_date('28-DEC-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2141,597,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.452,'BUY','choonann',to_date('23-FEB-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2142,597,'JD.com, Inc.','JD','NASDAQ',10,78.7,'BUY','choonann',to_date('28-APR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2143,597,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,'BUY','choonann',to_date('13-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2144,597,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,'BUY','choonann',to_date('18-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2145,597,'JD.com, Inc.','JD','NASDAQ',27,73.8,'BUY','choonann',to_date('21-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2146,597,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,'BUY','choonann',to_date('27-JUL-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2147,597,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,'SELL','choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2148,597,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,'SELL','choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2149,597,'Alphabet Inc.','GOOG','NASDAQ',1,2270,'SELL','choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2231,599,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,'BUY','choonann',to_date('27-JUN-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2235,599,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,'BUY','choonann',to_date('05-NOV-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2239,599,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,'BUY','choonann',to_date('13-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2243,599,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,'SELL','choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2246,600,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2248,600,'CapitaLand Limited','C31.SI','SGX',1500,3.48,'BUY','choonann',to_date('10-SEP-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2249,600,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2251,600,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.905,'BUY','choonann',to_date('23-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2252,600,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2254,600,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,'BUY','choonann',to_date('15-NOV-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2255,600,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,'BUY','choonann',to_date('12-MAR-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2257,600,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,'BUY','choonann',to_date('19-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2258,600,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,'BUY','choonann',to_date('30-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2260,600,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,'BUY','choonann',to_date('23-MAR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2261,600,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2263,600,'CapitaLand Limited','C31.SI','SGX',1500,3.58,'SELL','choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2264,600,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2266,600,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.975,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2267,600,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2269,600,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2270,600,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2272,600,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,'BUY','choonann',to_date('19-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2273,600,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,'BUY','choonann',to_date('03-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2275,600,'Microsoft Corporation','MSFT','NASDAQ',13,165,'BUY','choonann',to_date('08-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2276,600,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,'BUY','choonann',to_date('08-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2278,600,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,'BUY','choonann',to_date('28-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2279,600,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,'BUY','choonann',to_date('27-JUN-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2281,600,'Tencent Holdings Limited','0700.HK','HKEX',100,515,'BUY','choonann',to_date('09-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2282,600,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,'BUY','choonann',to_date('09-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2284,600,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.102,'BUY','choonann',to_date('28-DEC-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2285,600,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.452,'BUY','choonann',to_date('23-FEB-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2287,600,'JD.com, Inc.','JD','NASDAQ',10,78.7,'BUY','choonann',to_date('28-APR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2288,600,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,'BUY','choonann',to_date('13-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2290,600,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,'BUY','choonann',to_date('18-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2291,600,'JD.com, Inc.','JD','NASDAQ',27,73.8,'BUY','choonann',to_date('21-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2293,600,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,'SELL','choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2294,600,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,'SELL','choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2296,601,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2297,601,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2298,601,'CapitaLand Limited','C31.SI','SGX',1500,3.48,'BUY','choonann',to_date('10-SEP-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2299,601,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2300,601,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2301,601,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.905,'BUY','choonann',to_date('23-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2302,601,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2303,601,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (1994,585,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (1999,585,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2004,585,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,'BUY','choonann',to_date('19-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2009,585,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2014,585,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2019,585,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,'BUY','choonann',to_date('19-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2024,585,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,'BUY','choonann',to_date('30-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2029,585,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,'BUY','choonann',to_date('09-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2034,585,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,'BUY','choonann',to_date('13-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2039,585,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,'SELL','choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2043,588,'Microsoft Corporation','MSFT','NASDAQ',1,280,'SELL','choonann',to_date('01-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2048,592,'Facebook, Inc.','FB','NASDAQ',20,300,'BUY','admin',to_date('10-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2049,592,'Facebook, Inc.','FB','NASDAQ',20,300,'BUY','choonann',to_date('10-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2050,592,'Facebook, Inc.','FB','NASDAQ',20,300,'BUY','testuser',to_date('10-JAN-21','DD-MON-RR'),'test');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2200,599,'CapitaLand Limited','C31.SI','SGX',1500,3.48,'BUY','choonann',to_date('10-SEP-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2204,599,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2208,599,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,'BUY','choonann',to_date('16-DEC-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2212,599,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,'BUY','choonann',to_date('23-MAR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2216,599,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2220,599,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.775,'SELL','choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2224,599,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,'BUY','choonann',to_date('19-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2228,599,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,'BUY','choonann',to_date('08-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2232,599,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,'BUY','choonann',to_date('08-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2236,599,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.102,'BUY','choonann',to_date('28-DEC-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2240,599,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,'BUY','choonann',to_date('18-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2244,599,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,'SELL','choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2247,600,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,'BUY','choonann',to_date('25-SEP-18','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2250,600,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,'BUY','choonann',to_date('15-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2253,600,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,'BUY','choonann',to_date('30-OCT-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2256,600,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,'BUY','choonann',to_date('16-DEC-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2259,600,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,'BUY','choonann',to_date('02-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2262,600,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2265,600,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,'SELL','choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2268,600,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.775,'SELL','choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2271,600,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2274,600,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,'BUY','choonann',to_date('04-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2277,600,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,'BUY','choonann',to_date('30-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2280,600,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,'BUY','choonann',to_date('08-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2283,600,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,'BUY','choonann',to_date('05-NOV-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2286,600,'Amazon.com, Inc.','AMZN','NASDAQ',1,2977,'BUY','choonann',to_date('03-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2289,600,'iShares Hang Seng TECH ETF','3067.HK','HKEX',1000,15.8,'BUY','choonann',to_date('14-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2292,600,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,'BUY','choonann',to_date('27-JUL-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2295,600,'Alphabet Inc.','GOOG','NASDAQ',1,2270,'SELL','choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2304,601,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,'BUY','choonann',to_date('15-NOV-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2305,601,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,'BUY','choonann',to_date('12-MAR-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2306,601,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,'BUY','choonann',to_date('16-DEC-19','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2307,601,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,'BUY','choonann',to_date('19-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2308,601,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,'BUY','choonann',to_date('30-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2309,601,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,'BUY','choonann',to_date('02-MAY-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2310,601,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,'BUY','choonann',to_date('23-MAR-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2311,601,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2312,601,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2313,601,'CapitaLand Limited','C31.SI','SGX',1500,3.58,'SELL','choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2314,601,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,'SELL','choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2315,601,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,'SELL','choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2316,601,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.975,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2317,601,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2318,601,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.775,'SELL','choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2319,601,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,'SELL','choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2320,601,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,'SELL','choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2321,601,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,'SELL','choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent');
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2322,601,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,'BUY','choonann',to_date('19-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2323,601,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,'BUY','choonann',to_date('03-FEB-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2324,601,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,'BUY','choonann',to_date('04-MAR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2325,601,'Microsoft Corporation','MSFT','NASDAQ',13,165,'BUY','choonann',to_date('08-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2326,601,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,'BUY','choonann',to_date('08-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2327,601,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,'BUY','choonann',to_date('30-APR-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2328,601,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,'BUY','choonann',to_date('28-MAY-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2329,601,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,'BUY','choonann',to_date('27-JUN-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2330,601,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,'BUY','choonann',to_date('08-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2331,601,'Tencent Holdings Limited','0700.HK','HKEX',100,515,'BUY','choonann',to_date('09-JUL-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2332,601,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,'BUY','choonann',to_date('09-AUG-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2333,601,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,'BUY','choonann',to_date('05-NOV-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2334,601,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.102,'BUY','choonann',to_date('28-DEC-20','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2335,601,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.452,'BUY','choonann',to_date('23-FEB-21','DD-MON-RR'),null);
Insert into PMS_LOAD_PORT_TRANS (ID,UPLOAD_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,ACTION,CREATED_BY,CREATED_DT,REMARKS) values (2336,601,'Amazon.com, Inc.','AMZN','NASDAQ',1,2977,'BUY','choonann',to_date('03-MAY-21','DD-MON-RR'),null);
REM INSERTING into PMS_LOAD_PORT_UPLOAD
SET DEFINE OFF;
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (587,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.02.06.611000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (600,'test portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('05-AUG-21 11.14.18.918000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (589,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.05.45.202000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (590,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.06.36.393000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (585,'Choon Ann''s Portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('05-AUG-21 09.58.28.996000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (594,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.19.55.767000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (595,'My Portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('05-AUG-21 10.36.02.365000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (593,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.19.17.643000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (599,'test portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('05-AUG-21 11.02.36.143000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (586,'Choon Ann''s Portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.01.33.425000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (588,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.02.57.288000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (591,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.17.28.585000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'F','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (592,'test portfolio','testing','testing.txt','choonann',to_timestamp('05-AUG-21 10.18.50.182000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (596,'My Portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('05-AUG-21 10.37.20.906000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (597,'My Portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('05-AUG-21 10.39.45.307000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (598,'test portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('05-AUG-21 10.45.04.717000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
Insert into PMS_LOAD_PORT_UPLOAD (UPLOAD_ID,PORT_NAME,FILE_NAME,LOG_NAME,CREATED_BY,CREATED_DT,STATUS,DEL_IND) values (601,'My Portfolio','myPortfolio','myPortfolio.txt','choonann',to_timestamp('13-AUG-21 08.24.01.693000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'C','N');
REM INSERTING into PMS_MKT_EXCHG
SET DEFINE OFF;
Insert into PMS_MKT_EXCHG (MKT_EXCHG_NAME,MKT_EXCHG_DESC,CURR,SUFFIX,GPHY) values ('NYSE','New York Stock Exchange','USD',null,'US');
Insert into PMS_MKT_EXCHG (MKT_EXCHG_NAME,MKT_EXCHG_DESC,CURR,SUFFIX,GPHY) values ('NASDAQ','National Association of Securities Dealers Automated Quotations','USD',null,'US');
Insert into PMS_MKT_EXCHG (MKT_EXCHG_NAME,MKT_EXCHG_DESC,CURR,SUFFIX,GPHY) values ('HKEX','Hong Kong Stock Exchange','HKD','.HK','HK');
Insert into PMS_MKT_EXCHG (MKT_EXCHG_NAME,MKT_EXCHG_DESC,CURR,SUFFIX,GPHY) values ('SGX','Singapore Stock Exchange','SGD','.SI','SG');
Insert into PMS_MKT_EXCHG (MKT_EXCHG_NAME,MKT_EXCHG_DESC,CURR,SUFFIX,GPHY) values ('OTC','Over-The-Counter','USD',null,'US');
REM INSERTING into PMS_MSG
SET DEFINE OFF;
Insert into PMS_MSG (ID,TYPE,SUBJECT,MSG,USERNAME,GEN_DT,DEL_IND) values (708,'DOWN5PCT','Notification Alert: Watchlist Stock DOWN 5%','Notification Alert: Sea Limited[SE] is down 5% today.','choonann',to_timestamp('24-MAY-22 10.30.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),null);
Insert into PMS_MSG (ID,TYPE,SUBJECT,MSG,USERNAME,GEN_DT,DEL_IND) values (704,'TRIG1','Notification Alert: Watchlist Stock hits 1st Trigger','Notification Alert: Adobe Inc.[ADBE] hits 1st Trigger at 457.87.','choonann',to_timestamp('18-MAR-22 09.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Y');
Insert into PMS_MSG (ID,TYPE,SUBJECT,MSG,USERNAME,GEN_DT,DEL_IND) values (702,'TRIG1','Notification Alert: Watchlist Stock hits 1st Trigger','Notification Alert: Alibaba Group Holding Limited[BABA] hits 1st Trigger at 150.','choonann',to_timestamp('25-DEC-21 12.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Y');
Insert into PMS_MSG (ID,TYPE,SUBJECT,MSG,USERNAME,GEN_DT,DEL_IND) values (703,'TRIG1','Notification Alert: Watchlist Stock hits 1st Trigger','Notification Alert: Sea Limited[SE] hits 1st Trigger at 200.','choonann',to_timestamp('29-JAN-22 09.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Y');
Insert into PMS_MSG (ID,TYPE,SUBJECT,MSG,USERNAME,GEN_DT,DEL_IND) values (705,'TRIG1','Notification Alert: Watchlist Stock hits 1st Trigger','Notification Alert: Taiwan Semiconductor Manufacturing Company Limited[TSM] hits 1st Trigger at 107.87.','choonann',to_timestamp('18-MAR-22 09.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Y');
Insert into PMS_MSG (ID,TYPE,SUBJECT,MSG,USERNAME,GEN_DT,DEL_IND) values (707,'DOWN5PCT','Notification Alert: Watchlist Stock DOWN 5%','Notification Alert: Sea Limited[SE] is down 5% today.','choonann',to_timestamp('19-MAY-22 11.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),null);
Insert into PMS_MSG (ID,TYPE,SUBJECT,MSG,USERNAME,GEN_DT,DEL_IND) values (706,'DOWN5PCT','Notification Alert: Watchlist Stock DOWN 5%','Notification Alert: Sea Limited[SE] is down 5% today.','choonann',to_timestamp('19-MAY-22 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),null);
REM INSERTING into PMS_OTHER_NOTI
SET DEFINE OFF;
Insert into PMS_OTHER_NOTI (ID,WATCH_ID,TYPE,WATCHLIST_NAM,STOCK_NAM,STOCK_SYM,CHANGE_PCT,CUSTOM_PCT,USERNAME,GEN_DT,DEL_IND) values (462,81,'DOWN5PCT','test watchlist','Sea Limited','SE',-6.77,null,'choonann',to_timestamp('24-MAY-22 10.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Y');
REM INSERTING into PMS_PORT
SET DEFINE OFF;
Insert into PMS_PORT (ID,PORT_NAME,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT,REMARKS) values (455,'Perf Invest Amount Test','admin',to_date('23-MAY-22','DD-MON-RR'),'admin',to_timestamp('23-MAY-22 08.34.56.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Total Wealth/Investment amount test');
Insert into PMS_PORT (ID,PORT_NAME,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT,REMARKS) values (451,'My Dividend Portfolio','choonann',to_date('22-AUG-21','DD-MON-RR'),'choonann',to_timestamp('22-AUG-21 11.08.39.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),null);
Insert into PMS_PORT (ID,PORT_NAME,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT,REMARKS) values (454,'Performance Test PF','testuser',to_date('18-MAY-22','DD-MON-RR'),'choonann',to_timestamp('18-MAY-22 03.52.14.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'For Testing purpose');
Insert into PMS_PORT (ID,PORT_NAME,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT,REMARKS) values (452,'Demo Portfolio','testuser',to_date('19-JAN-22','DD-MON-RR'),'choonann',to_timestamp('19-JAN-22 05.07.49.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'testing');
Insert into PMS_PORT (ID,PORT_NAME,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT,REMARKS) values (446,'My Portfolio','choonann',to_date('13-AUG-21','DD-MON-RR'),'choonann',to_timestamp('13-AUG-21 08.23.26.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),null);
REM INSERTING into PMS_PORT_DIV
SET DEFINE OFF;
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (229,452,'Mapletree Logistics Trust','M44U.SI','SGX',2000,to_date('29-JAN-22','DD-MON-RR'),to_date('29-JAN-22','DD-MON-RR'),'N','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',1000,to_date('01-JAN-18','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (83,446,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (87,446,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (226,446,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',1000,to_date('29-JAN-22','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (100,446,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (231,452,'Microsoft Corporation','MSFT','NASDAQ',10,to_date('29-JAN-22','DD-MON-RR'),to_date('29-JAN-22','DD-MON-RR'),'Y','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (101,446,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('09-JUL-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (232,452,'Microsoft Corporation','MSFT','NASDAQ',10,to_date('29-JAN-22','DD-MON-RR'),null,'Y','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (234,452,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',700,to_date('29-JAN-22','DD-MON-RR'),null,'Y','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (235,452,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('29-JAN-22','DD-MON-RR'),to_date('29-JAN-22','DD-MON-RR'),'N','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (202,451,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (203,451,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (207,451,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (208,451,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (210,451,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (214,451,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (215,451,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (218,451,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,to_date('28-MAY-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (219,451,'Tencent Holdings Limited','0700.HK','HKEX',100,to_date('07-SEP-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (233,452,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',300,to_date('29-JAN-22','DD-MON-RR'),to_date('29-JAN-22','DD-MON-RR'),'N','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (94,446,'CapitaLand China Trust','AU8U.SI','SGX',3700,to_date('05-FEB-21','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (95,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('09-MAR-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (99,446,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('08-APR-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (204,451,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (205,451,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (206,451,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (209,451,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('09-MAR-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (211,451,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (212,451,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (213,451,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (217,451,'Microsoft Corporation','MSFT','NASDAQ',13,to_date('04-AUG-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (228,452,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',500,to_date('29-JAN-22','DD-MON-RR'),null,'Y','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (230,452,'Keppel DC REIT','AJBU.SI','SGX',1000,to_date('29-JAN-22','DD-MON-RR'),to_date('29-JAN-22','DD-MON-RR'),'N','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (224,453,'Keppel DC REIT','AJBU.SI','SGX',1000,to_date('01-DEC-20','DD-MON-RR'),to_date('19-JAN-22','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (227,452,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',1000,to_date('29-JAN-22','DD-MON-RR'),null,'Y','testuser');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (223,451,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',1000,to_date('01-DEC-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (90,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('12-MAR-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (84,446,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (85,446,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (91,446,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,to_date('16-DEC-19','DD-MON-RR'),null,'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (93,446,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,to_date('30-JUL-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (96,446,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,to_date('23-FEB-21','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,to_date('02-MAR-20','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',1000,to_date('01-JAN-19','DD-MON-RR'),null,'Y','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (86,446,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (88,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('30-OCT-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (97,446,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('09-AUG-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (130,446,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,to_date('25-SEP-18','DD-MON-RR'),to_date('15-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (131,446,'Keppel DC REIT','AJBU.SI','SGX',3700,to_date('25-SEP-18','DD-MON-RR'),to_date('15-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (132,446,'CapitaLand Limited','C31.SI','SGX',1500,to_date('09-OCT-19','DD-MON-RR'),to_date('21-OCT-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (133,446,'Keppel DC REIT','AJBU.SI','SGX',5600,to_date('15-OCT-19','DD-MON-RR'),to_date('28-NOV-19','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (134,446,'Keppel DC REIT','AJBU.SI','SGX',3800,to_date('28-NOV-19','DD-MON-RR'),to_date('27-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (135,446,'NetLink NBN Trust','CJLU.SI','SGX',6000,to_date('23-OCT-19','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (136,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',8000,to_date('23-OCT-19','DD-MON-RR'),to_date('03-SEP-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (137,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,to_date('03-SEP-20','DD-MON-RR'),to_date('07-JAN-21','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (138,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,to_date('03-DEC-19','DD-MON-RR'),to_date('09-MAR-20','DD-MON-RR'),'N','choonann');
Insert into PMS_PORT_DIV (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,DATE_PURCHASE,DATE_SOLD,CURR_HOLD_IND,CREATED_BY) values (140,446,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,to_date('19-MAR-20','DD-MON-RR'),to_date('08-SEP-20','DD-MON-RR'),'N','choonann');
REM INSERTING into PMS_PORT_DIV_DET
SET DEFINE OFF;
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (585,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('20-MAR-20','DD-MON-RR'),10,1.406,9.84,13.37);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (115,83,446,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('24-MAY-19','DD-MON-RR'),2200,0.018965,41.72,41.72);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (575,99,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('18-AUG-21','DD-MON-RR'),13,0.56,5.1,6.93);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (586,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('19-JUN-20','DD-MON-RR'),10,1.366,9.56,12.99);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (587,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-SEP-20','DD-MON-RR'),10,1.339,9.37,12.73);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (117,84,446,'Keppel DC REIT','AJBU.SI','SGX',to_date('23-SEP-19','DD-MON-RR'),3700,0.017774,65.76,65.76);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (123,88,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',to_date('17-FEB-20','DD-MON-RR'),8000,0.0129,103.2,103.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (124,90,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',to_date('07-MAY-19','DD-MON-RR'),2000,0.079611,159.22,159.22);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (127,91,446,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('29-APR-20','DD-MON-RR'),2700,0.0091,24.57,24.57);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (150,98,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-SEP-20','DD-MON-RR'),10,1.339,9.37,12.71);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (144,96,446,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('03-AUG-21','DD-MON-RR'),1800,0.0114,20.52,20.52);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (146,97,446,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',to_date('29-APR-20','DD-MON-RR'),1700,0.0332,56.44,56.44);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (588,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-DEC-20','DD-MON-RR'),10,1.58,11.06,15.03);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (156,99,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('18-NOV-20','DD-MON-RR'),13,0.56,5.1,6.92);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (589,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('19-MAR-21','DD-MON-RR'),10,1.278,8.95,12.16);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (590,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-JUN-21','DD-MON-RR'),10,1.376,9.63,13.08);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (596,218,451,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',to_date('28-SEP-21','DD-MON-RR'),500,1.056806,528.4,92.06);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (599,214,451,'CapitaLand China Trust','AU8U.SI','SGX',to_date('19-OCT-21','DD-MON-RR'),3700,0.027,99.9,99.9);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (803,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('01-AUG-18','DD-MON-RR'),1000,0.022213,22.21,22.21);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (806,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-APR-19','DD-MON-RR'),1000,0.02301,23.01,23.01);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (614,215,451,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('02-NOV-21','DD-MON-RR'),1800,0.0347,62.46,62.46);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (620,217,451,'Microsoft Corporation','MSFT','NASDAQ',to_date('17-NOV-21','DD-MON-RR'),13,0.62,5.64,7.66);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (625,211,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('03-NOV-21','DD-MON-RR'),2500,0.0439,109.75,109.75);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (635,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('17-SEP-21','DD-MON-RR'),10,1.428,10,13.59);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (636,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('17-DEC-21','DD-MON-RR'),10,1.636,11.45,15.55);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (426,202,451,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('31-OCT-19','DD-MON-RR'),2200,0.02894,63.67,63.67);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (428,202,451,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('30-OCT-18','DD-MON-RR'),2200,0.028402,62.48,62.48);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (430,202,451,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('30-JUL-19','DD-MON-RR'),2200,0.010839,23.85,23.85);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (432,203,451,'Keppel DC REIT','AJBU.SI','SGX',to_date('23-JUL-19','DD-MON-RR'),3700,0.037806,139.88,139.88);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (434,206,451,'Keppel DC REIT','AJBU.SI','SGX',to_date('29-JAN-20','DD-MON-RR'),3800,0.0195,74.1,74.1);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (436,207,451,'NetLink NBN Trust','CJLU.SI','SGX',to_date('13-NOV-19','DD-MON-RR'),6000,0.0252,151.2,151.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (438,209,451,'Lendlease Global Commercial REIT','JYEU.SI','SGX',to_date('18-AUG-20','DD-MON-RR'),4000,0.01758,70.32,70.32);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (440,211,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('29-APR-20','DD-MON-RR'),2500,0.0091,22.75,22.75);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (442,211,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-JAN-20','DD-MON-RR'),2500,0.0185,46.25,46.25);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (444,212,451,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',to_date('29-APR-20','DD-MON-RR'),1700,0.0332,56.44,56.44);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (446,213,451,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',to_date('13-AUG-21','DD-MON-RR'),500,0.25,125,125);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (448,213,451,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',to_date('12-MAY-21','DD-MON-RR'),500,0.159,79.5,79.5);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (450,214,451,'CapitaLand China Trust','AU8U.SI','SGX',to_date('05-AUG-21','DD-MON-RR'),3700,0.0423,156.51,156.51);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (452,215,451,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('03-AUG-21','DD-MON-RR'),1800,0.0114,20.52,20.52);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (454,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('20-MAR-20','DD-MON-RR'),10,1.406,9.84,13.4);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (456,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-SEP-20','DD-MON-RR'),10,1.339,9.37,12.76);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (458,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('19-MAR-21','DD-MON-RR'),10,1.278,8.95,12.19);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (460,217,451,'Microsoft Corporation','MSFT','NASDAQ',to_date('19-AUG-20','DD-MON-RR'),13,0.51,4.64,6.32);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (462,217,451,'Microsoft Corporation','MSFT','NASDAQ',to_date('17-FEB-21','DD-MON-RR'),13,0.56,5.1,6.95);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (464,217,451,'Microsoft Corporation','MSFT','NASDAQ',to_date('18-AUG-21','DD-MON-RR'),13,0.56,5.1,6.95);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (466,218,451,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',to_date('16-SEP-20','DD-MON-RR'),500,0.896405,448.2,78.35);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (470,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('30-JUL-19','DD-MON-RR'),1000,0.0292,29.2,29.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (471,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('29-OCT-19','DD-MON-RR'),1000,0.0306,30.6,30.6);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (802,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-APR-18','DD-MON-RR'),1000,0.022611,22.61,22.61);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (805,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-JAN-19','DD-MON-RR'),1000,0.023209,23.21,23.21);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (808,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('23-OCT-19','DD-MON-RR'),1000,0.0293,29.3,29.3);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (824,224,453,'Keppel DC REIT','AJBU.SI','SGX',to_date('02-FEB-21','DD-MON-RR'),1000,0.04795,47.95,47.95);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (112,83,446,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('31-OCT-19','DD-MON-RR'),2200,0.02894,63.67,63.67);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (118,84,446,'Keppel DC REIT','AJBU.SI','SGX',to_date('23-JUL-19','DD-MON-RR'),3700,0.037806,139.88,139.88);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (120,86,446,'Keppel DC REIT','AJBU.SI','SGX',to_date('29-JAN-20','DD-MON-RR'),3800,0.0195,74.1,74.1);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (122,87,446,'NetLink NBN Trust','CJLU.SI','SGX',to_date('13-NOV-19','DD-MON-RR'),6000,0.0252,151.2,151.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (125,90,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',to_date('08-NOV-19','DD-MON-RR'),2000,0.078019,156.04,156.04);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (128,91,446,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('04-MAY-21','DD-MON-RR'),2700,0.0532,143.64,143.64);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (158,99,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('19-MAY-21','DD-MON-RR'),13,0.56,5.1,6.92);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (137,93,446,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',to_date('13-AUG-21','DD-MON-RR'),500,0.25,125,125);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (145,96,446,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('06-MAY-21','DD-MON-RR'),1800,0.032889,59.2,59.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (147,97,446,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',to_date('05-AUG-20','DD-MON-RR'),1700,0.0336,57.12,57.12);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (151,98,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-DEC-20','DD-MON-RR'),10,1.58,11.06,15.01);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (160,100,446,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',to_date('16-SEP-20','DD-MON-RR'),500,0.896405,448.2,78.11);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (425,202,451,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('02-MAY-19','DD-MON-RR'),2200,0.031131,68.49,68.49);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (427,202,451,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('28-JAN-19','DD-MON-RR'),2200,0.02997,65.93,65.93);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (429,202,451,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('24-MAY-19','DD-MON-RR'),2200,0.018965,41.72,41.72);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (431,203,451,'Keppel DC REIT','AJBU.SI','SGX',to_date('23-SEP-19','DD-MON-RR'),3700,0.017774,65.76,65.76);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (433,203,451,'Keppel DC REIT','AJBU.SI','SGX',to_date('29-JAN-19','DD-MON-RR'),3700,0.036333,134.43,134.43);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (435,207,451,'NetLink NBN Trust','CJLU.SI','SGX',to_date('21-MAY-20','DD-MON-RR'),6000,0.0253,151.8,151.8);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (437,208,451,'Lendlease Global Commercial REIT','JYEU.SI','SGX',to_date('17-FEB-20','DD-MON-RR'),8000,0.0129,103.2,103.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (439,210,451,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',to_date('07-FEB-20','DD-MON-RR'),2000,0.035033,70.07,70.07);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (441,211,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('04-MAY-21','DD-MON-RR'),2500,0.0532,133,133);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (443,211,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('29-OCT-20','DD-MON-RR'),2500,0.0417,104.25,104.25);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (445,212,451,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',to_date('05-AUG-20','DD-MON-RR'),1700,0.0336,57.12,57.12);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (447,213,451,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',to_date('21-AUG-20','DD-MON-RR'),500,0.159,79.5,79.5);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (449,214,451,'CapitaLand China Trust','AU8U.SI','SGX',to_date('05-FEB-21','DD-MON-RR'),3700,0.0058,21.46,21.46);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (451,215,451,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('28-MAY-21','DD-MON-RR'),1800,0.0221,39.78,39.78);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (453,215,451,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('06-MAY-21','DD-MON-RR'),1800,0.032889,59.2,59.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (455,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('19-JUN-20','DD-MON-RR'),10,1.366,9.56,13.02);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (457,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-DEC-20','DD-MON-RR'),10,1.58,11.06,15.06);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (459,216,451,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-JUN-21','DD-MON-RR'),10,1.376,9.63,13.12);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (461,217,451,'Microsoft Corporation','MSFT','NASDAQ',to_date('18-NOV-20','DD-MON-RR'),13,0.56,5.1,6.95);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (463,217,451,'Microsoft Corporation','MSFT','NASDAQ',to_date('19-MAY-21','DD-MON-RR'),13,0.56,5.1,6.95);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (465,218,451,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',to_date('22-APR-21','DD-MON-RR'),500,1.6706,835.3,146.02);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (467,219,451,'Tencent Holdings Limited','0700.HK','HKEX',to_date('24-MAY-21','DD-MON-RR'),100,1.6,160,27.97);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (826,224,453,'Keppel DC REIT','AJBU.SI','SGX',to_date('19-AUG-21','DD-MON-RR'),1000,0.01421,14.21,14.21);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (487,94,446,'CapitaLand China Trust','AU8U.SI','SGX',to_date('19-OCT-21','DD-MON-RR'),3700,0.027,99.9,99.9);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (491,96,446,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('02-NOV-21','DD-MON-RR'),1800,0.0347,62.46,62.46);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (498,99,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('17-NOV-21','DD-MON-RR'),13,0.62,5.64,7.66);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (503,91,446,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('03-NOV-21','DD-MON-RR'),2700,0.0439,118.53,118.53);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (513,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('17-SEP-21','DD-MON-RR'),10,1.428,10,13.59);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (514,144,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('17-DEC-21','DD-MON-RR'),10,1.636,11.45,15.55);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (799,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('04-AUG-21','DD-MON-RR'),1000,0.0518,51.8,51.8);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (800,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('14-DEC-21','DD-MON-RR'),1000,0.0485,48.5,48.5);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (797,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('19-OCT-20','DD-MON-RR'),1000,0.0399,39.9,39.9);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (819,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-JAN-20','DD-MON-RR'),1000,0.0185,18.5,18.5);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (817,223,451,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',to_date('11-MAY-21','DD-MON-RR'),1000,0.0563,56.3,56.3);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (798,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('28-JAN-21','DD-MON-RR'),1000,0.0174,17.4,17.4);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (818,223,451,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',to_date('10-AUG-21','DD-MON-RR'),1000,0.0203,20.3,20.3);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (820,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('29-APR-20','DD-MON-RR'),1000,0.0091,9.1,9.1);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (821,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('29-OCT-20','DD-MON-RR'),1000,0.0417,41.7,41.7);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (111,83,446,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('02-MAY-19','DD-MON-RR'),2200,0.031131,68.49,68.49);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (116,83,446,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('30-JUL-19','DD-MON-RR'),2200,0.010839,23.85,23.85);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (822,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('04-MAY-21','DD-MON-RR'),1000,0.0532,53.2,53.2);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (823,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('03-NOV-21','DD-MON-RR'),1000,0.0439,43.9,43.9);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (155,99,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('19-AUG-20','DD-MON-RR'),13,0.51,4.64,6.3);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (148,98,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('20-MAR-20','DD-MON-RR'),10,1.406,9.84,13.35);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (153,98,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('18-JUN-21','DD-MON-RR'),10,1.376,9.63,13.07);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (825,224,453,'Keppel DC REIT','AJBU.SI','SGX',to_date('02-AUG-21','DD-MON-RR'),1000,0.04924,49.24,49.24);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (469,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('02-MAY-19','DD-MON-RR'),1000,0.0288,28.8,28.8);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (472,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('30-JAN-20','DD-MON-RR'),1000,0.0311,31.1,31.1);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (474,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('29-JUL-20','DD-MON-RR'),1000,0.0211,21.1,21.1);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (484,100,446,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',to_date('28-SEP-21','DD-MON-RR'),500,1.056806,528.4,92.06);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (804,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-OCT-18','DD-MON-RR'),1000,0.022611,22.61,22.61);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (807,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('01-AUG-19','DD-MON-RR'),1000,0.02301,23.01,23.01);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (814,223,451,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',to_date('09-FEB-21','DD-MON-RR'),1000,0.01678,16.78,16.78);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (114,83,446,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('30-OCT-18','DD-MON-RR'),2200,0.028402,62.48,62.48);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (119,84,446,'Keppel DC REIT','AJBU.SI','SGX',to_date('29-JAN-19','DD-MON-RR'),3700,0.036333,134.43,134.43);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (121,87,446,'NetLink NBN Trust','CJLU.SI','SGX',to_date('21-MAY-20','DD-MON-RR'),6000,0.0253,151.8,151.8);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (126,90,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',to_date('07-FEB-20','DD-MON-RR'),2000,0.035033,70.07,70.07);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (129,91,446,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-JAN-20','DD-MON-RR'),2700,0.0185,49.95,49.95);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (130,91,446,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('29-OCT-20','DD-MON-RR'),2700,0.0417,112.59,112.59);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (154,99,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('20-MAY-20','DD-MON-RR'),13,0.51,4.64,6.3);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (157,99,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('17-FEB-21','DD-MON-RR'),13,0.56,5.1,6.92);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (159,100,446,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',to_date('22-APR-21','DD-MON-RR'),500,1.6706,835.3,145.57);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (138,93,446,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',to_date('21-AUG-20','DD-MON-RR'),500,0.159,79.5,79.5);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (113,83,446,'Frasers Centrepoint Trust','J69U.SI','SGX',to_date('28-JAN-19','DD-MON-RR'),2200,0.02997,65.93,65.93);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (139,93,446,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',to_date('12-MAY-21','DD-MON-RR'),500,0.159,79.5,79.5);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (140,94,446,'CapitaLand China Trust','AU8U.SI','SGX',to_date('05-FEB-21','DD-MON-RR'),3700,0.0058,21.46,21.46);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (141,94,446,'CapitaLand China Trust','AU8U.SI','SGX',to_date('05-AUG-21','DD-MON-RR'),3700,0.0423,156.51,156.51);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (142,95,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',to_date('18-AUG-20','DD-MON-RR'),4000,0.01758,70.32,70.32);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (143,96,446,'Mapletree Industrial Trust','ME8U.SI','SGX',to_date('28-MAY-21','DD-MON-RR'),1800,0.0221,39.78,39.78);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (149,98,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('19-JUN-20','DD-MON-RR'),10,1.366,9.56,12.97);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (152,98,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',to_date('19-MAR-21','DD-MON-RR'),10,1.278,8.95,12.14);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (161,101,446,'Tencent Holdings Limited','0700.HK','HKEX',to_date('24-MAY-21','DD-MON-RR'),100,1.6,160,27.88);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (292,145,446,'Microsoft Corporation','MSFT','NASDAQ',to_date('18-AUG-21','DD-MON-RR'),13,0.56,5.1,6.95);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (468,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('30-JAN-19','DD-MON-RR'),1000,0.0156,15.6,15.6);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (473,220,451,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',to_date('11-MAY-20','DD-MON-RR'),1000,0.0085,8.5,8.5);
Insert into PMS_PORT_DIV_DET (ID,DIV_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,EX_DATE,NO_OF_SHARE,ADJ_DIV,DIV_PAYOUT,SGD_DIV_PAYOUT) values (801,222,451,'Mapletree Commercial Trust','N2IU.SI','SGX',to_date('30-JAN-18','DD-MON-RR'),1000,0.02291,22.91,22.91);
REM INSERTING into PMS_PORT_HOLD
SET DEFINE OFF;
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',700,12.42,8694,11.6,8120,-574,-6.6,'testuser',to_timestamp('29-JAN-22 12.00.18.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'Meta Platforms, Inc.','FB','NASDAQ',50,301.71,15085.5,176.94,8847,-6238.5,-41.35,'testuser',to_timestamp('29-JAN-22 11.40.44.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'SPDR S&P 500 ETF Trust','SPY','NYSE',40,408.32,16332.8,388.04,15521.6,-811.2,-4.97,'testuser',to_timestamp('18-MAY-22 03.55.55.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'KraneShares CSI China Internet ETF','KWEB','NYSE',500,34.54,17270,24.87,12435,-4835,-28,'testuser',to_timestamp('18-MAY-22 03.56.21.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'Plug Power Inc.','PLUG','NASDAQ',200,20,4000,15.335,3067,-933,-23.33,'testuser',to_timestamp('18-MAY-22 04.09.49.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'iShares Hang Seng TECH ETF','3067.HK','HKEX',1000,14.2,14200,8.41,8410,-5790,-40.77,'testuser',to_timestamp('18-MAY-22 04.10.41.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'Casa Holdings Limited','C04.SI','SGX',100000,0.08,7500,0.075,7500,0,0,'testuser',to_timestamp('18-MAY-22 04.13.07.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'Sunny Optical Technology (Group) Company Limited','2382.HK','HKEX',500,113.8,56900,109.1,54550,-2350,-4.13,'testuser',to_timestamp('18-MAY-22 04.13.33.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (455,'SPDR S&P 500 ETF Trust','SPY','NYSE',20,400.05,8001,388.04,7760.8,-240.2,-3,'admin',to_timestamp('23-MAY-22 08.37.11.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'Hang Seng Index ETF','2833.HK','HKEX',1000,20,20000,20.5,20500,500,2.5,'testuser',to_timestamp('21-MAY-22 03.06.37.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'Amazon.com, Inc.','AMZN','NASDAQ',5,3200.32,16001.6,2066.375,10331.88,-5669.72,-35.43,'testuser',to_timestamp('18-MAY-22 03.56.52.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',500,1.94,970,2.23,1115,145,14.95,'testuser',to_timestamp('29-JAN-22 11.46.43.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'Microsoft Corporation','MSFT','NASDAQ',10,308.26,3082.6,255.12,2551.2,-531.4,-17.24,'testuser',to_timestamp('29-JAN-22 11.58.57.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Meta Platforms, Inc.','FB','NASDAQ',12,266.665,3199.98,176.94,2123.28,-1076.7,-33.65,'choonann',to_timestamp('26-FEB-22 05.09.03.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (455,'Sembcorp Marine Ltd','S51.SI','SGX',10000,0.31,3080,0.106,1060,-2020,-65.58,'admin',to_timestamp('23-MAY-22 08.40.31.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'PayPal Holdings, Inc.','PYPL','NASDAQ',5,180,900,77.5,387.5,-512.5,-56.94,'testuser',to_timestamp('19-JAN-22 05.11.40.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'Amazon.com, Inc.','AMZN','NASDAQ',2,2879.56,5759.12,2066.375,4132.75,-1626.37,-28.24,'testuser',to_timestamp('29-JAN-22 10.22.20.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (455,'DXC Technology Company','DXC','NYSE',200,25.8,5160,28.755,5751,591,11.45,'admin',to_timestamp('23-MAY-22 08.40.53.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (455,'China Construction Bank Corporation','0939.HK','HKEX',15000,5.1,76500,5.61,84150,7650,10,'admin',to_timestamp('23-MAY-22 08.43.45.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,4340,11.6,5800,1460,33.64,'choonann',to_timestamp('30-JUL-20 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,4995,1.11,4107,-888,-17.78,'choonann',to_timestamp('02-MAY-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,4878,2.43,4374,-504,-10.33,'choonann',to_timestamp('23-MAR-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,2950,388.04,3880.4,930.4,31.54,'choonann',to_timestamp('03-FEB-20 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Alphabet Inc.','GOOG','NASDAQ',2,1195.667,2391.33,2064.55,4129.1,1737.77,72.67,'choonann',to_timestamp('04-SEP-20 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Microsoft Corporation','MSFT','NASDAQ',13,165,2145,255.12,3316.56,1171.56,54.62,'choonann',to_timestamp('08-APR-20 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Alibaba Group Holding Limited','BABA','NYSE',30,231.914,6957.41,82.73,2481.9,-4475.51,-64.33,'choonann',to_timestamp('18-MAY-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,38450,47,23500,-14950,-38.88,'choonann',to_timestamp('28-MAY-20 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Tencent Holdings Limited','0700.HK','HKEX',100,515,51500,338,33800,-17700,-34.37,'choonann',to_timestamp('09-JUL-20 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,1623.57,140.78,1830.14,206.57,12.72,'choonann',to_timestamp('09-AUG-20 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'iShares Hang Seng TECH ETF','9067.HK','HKEX',2000,2.242,4484,1.07,2140,-2344,-52.27,'choonann',to_timestamp('23-FEB-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Amazon.com, Inc.','AMZN','NASDAQ',2,2598.485,5196.97,2066.375,4132.75,-1064.22,-20.48,'choonann',to_timestamp('15-MAY-22 08.24.47.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'JD.com, Inc.','JD','NASDAQ',37,75.124,2779.6,49.73,1840.01,-939.59,-33.8,'choonann',to_timestamp('21-MAY-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,1751,11.78,1001.3,-749.7,-42.82,'choonann',to_timestamp('13-MAY-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'iShares Hang Seng TECH ETF','3067.HK','HKEX',1000,15.8,15800,8.41,8410,-7390,-46.77,'choonann',to_timestamp('14-MAY-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,18430,83.6,8360,-10070,-54.64,'choonann',to_timestamp('27-JUL-21 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (446,'Adobe Inc.','ADBE','NASDAQ',4,430.85,1723.4,394.295,1577.18,-146.22,-8.48,'choonann',to_timestamp('15-MAY-22 08.23.11.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (452,'Grab Holdings Limited','GRAB','NASDAQ',300,5.51,1653,2.665,799.5,-853.5,-51.63,'testuser',to_timestamp('29-JAN-22 10.21.44.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'First Trust Cloud Computing ETF','SKYY','NASDAQ',100,65,6500,64.28,6428,-72,-1.11,'testuser',to_timestamp('18-MAY-22 04.09.15.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'Alphabet Inc.','GOOG','NASDAQ',12,1800.02,21600.24,2064.55,24774.6,3174.36,14.7,'testuser',to_timestamp('18-MAY-22 04.11.51.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'SPDR Straits Times Index ETF','ES3.SI','SGX',4500,2.39,10764,3.26,14670,3906,36.29,'testuser',to_timestamp('18-MAY-22 04.12.29.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'City Developments Limited','C09.SI','SGX',1200,8.14,9768,8.09,9708,-60,-0.61,'testuser',to_timestamp('18-MAY-22 04.14.37.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'Yangzijiang Financial Holding Ltd.','YF8.SI','SGX',50000,0.38,19100,0.475,23750,4650,24.35,'testuser',to_timestamp('18-MAY-22 04.15.04.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (454,'iShares Core MSCI China ETF','2801.HK','HKEX',1000,21.28,21280,20.76,20760,-520,-2.44,'testuser',to_timestamp('18-MAY-22 04.38.52.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (455,'iShares Core MSCI China ETF','2801.HK','HKEX',600,22.5,13500,20.76,12456,-1044,-7.73,'admin',to_timestamp('23-MAY-22 08.38.16.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_PORT_HOLD (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,PROFIT_LOSS_PCT,LAST_TRANS_BY,LAST_TRANS_DT) values (455,'SPDR Straits Times Index ETF','ES3.SI','SGX',3000,3.2,9606,3.26,9780,174,1.81,'admin',to_timestamp('23-MAY-22 08.38.58.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
REM INSERTING into PMS_PORT_TRANS
SET DEFINE OFF;
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2940,452,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',500,1.94,970,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2942,452,'Mapletree Logistics Trust','M44U.SI','SGX',2000,1.69,3380,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2944,452,'Keppel DC REIT','AJBU.SI','SGX',1000,2.16,2160,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2945,452,'Microsoft Corporation','MSFT','NASDAQ',20,308.26,6165.2,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2947,452,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',1000,12.42,12420,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2948,452,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',300,12.42,3726,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2949,452,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,1.81,4525,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2950,452,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,1.81,4525,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2953,446,'Adobe Inc.','ADBE','NASDAQ',4,430.85,1723.4,'choonann',to_date('23-MAR-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2957,454,'Amazon.com, Inc.','AMZN','NASDAQ',5,3200.32,16001.6,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2963,454,'SPDR Straits Times Index ETF','ES3.SI','SGX',4500,2.39,10764,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2959,454,'First Trust Cloud Computing ETF','SKYY','NASDAQ',100,65,6500,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2962,454,'Alphabet Inc.','GOOG','NASDAQ',12,1800.02,21600.24,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2966,454,'City Developments Limited','C09.SI','SGX',1200,8.14,9768,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2967,454,'Yangzijiang Financial Holding Ltd.','YF8.SI','SGX',50000,0.38,19100,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2968,454,'iShares Core MSCI China ETF','2801.HK','HKEX',1000,21.28,21280,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2971,455,'iShares Core MSCI China ETF','2801.HK','HKEX',600,22.5,13500,'admin',to_date('23-MAY-22','DD-MON-RR'),'China ETF 1','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2973,455,'Sembcorp Marine Ltd','S51.SI','SGX',10000,0.31,3080,'admin',to_date('23-MAY-22','DD-MON-RR'),'SG Stock 1','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2974,455,'DXC Technology Company','DXC','NYSE',200,25.8,5160,'admin',to_date('23-MAY-22','DD-MON-RR'),'US Stock 1','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2938,452,'Meta Platforms, Inc.','FB','NASDAQ',50,301.71,15085.5,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2939,452,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX',1000,1.94,1940,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2935,452,'Adobe Inc.','ADBE','NASDAQ',3,518.16,1554.48,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2951,446,'Meta Platforms, Inc.','FB','NASDAQ',6,302.33,1813.98,'choonann',to_date('26-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2952,446,'Meta Platforms, Inc.','FB','NASDAQ',6,231,1386,'choonann',to_date('10-FEB-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2955,454,'SPDR S&P 500 ETF Trust','SPY','NYSE',40,408.32,16332.8,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2956,454,'KraneShares CSI China Internet ETF','KWEB','NYSE',500,34.54,17270,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2926,452,'PayPal Holdings, Inc.','PYPL','NASDAQ',5,180,900,'testuser',to_date('19-JAN-22','DD-MON-RR'),'TEST','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2934,452,'Adobe Inc.','ADBE','NASDAQ',5,518.16,2590.8,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2937,452,'Meta Platforms, Inc.','FB','NASDAQ',100,301.71,30171,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2933,452,'Amazon.com, Inc.','AMZN','NASDAQ',2,2879.56,5759.12,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2936,452,'Adobe Inc.','ADBE','NASDAQ',2,518.16,1036.32,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2941,452,'Mapletree Logistics Trust','M44U.SI','SGX',2000,1.69,3380,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2943,452,'Keppel DC REIT','AJBU.SI','SGX',1000,2.16,2160,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2946,452,'Microsoft Corporation','MSFT','NASDAQ',10,308.26,3082.6,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2970,455,'SPDR S&P 500 ETF Trust','SPY','NYSE',20,400.05,8001,'admin',to_date('23-MAY-22','DD-MON-RR'),'US ETF Stock 1','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2972,455,'SPDR Straits Times Index ETF','ES3.SI','SGX',3000,3.2,9606,'admin',to_date('23-MAY-22','DD-MON-RR'),'SG ETF 1','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2975,455,'China Construction Bank Corporation','0939.HK','HKEX',15000,5.1,76500,'admin',to_date('23-MAY-22','DD-MON-RR'),'HK Stock 1','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2930,452,'Grab Holdings Limited','GRAB','NASDAQ',500,5.51,2755,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2875,446,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.27,4994,'choonann',to_date('25-SEP-18','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2876,446,'Keppel DC REIT','AJBU.SI','SGX',3700,1.37,5069,'choonann',to_date('25-SEP-18','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2877,446,'CapitaLand Limited','C31.SI','SGX',1500,3.48,5220,'choonann',to_date('10-SEP-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2878,446,'Keppel DC REIT','AJBU.SI','SGX',100,1.71,171,'choonann',to_date('15-OCT-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2879,446,'Keppel DC REIT','AJBU.SI','SGX',1800,1.71,3078,'choonann',to_date('15-OCT-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2880,446,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.905,5430,'choonann',to_date('23-OCT-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2881,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,3800,'choonann',to_date('30-OCT-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2882,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.95,3800,'choonann',to_date('30-OCT-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2883,446,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.68,5896,'choonann',to_date('15-NOV-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2884,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,2.95,5900,'choonann',to_date('12-MAR-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2885,446,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,2.27,5675,'choonann',to_date('16-DEC-19','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2886,446,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,2.76,4692,'choonann',to_date('19-MAR-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2887,446,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX',500,8.68,4340,'choonann',to_date('30-JUL-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2888,446,'CapitaLand China Trust','AU8U.SI','SGX',3700,1.35,4995,'choonann',to_date('02-MAY-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2889,446,'Mapletree Industrial Trust','ME8U.SI','SGX',1800,2.71,4878,'choonann',to_date('23-MAR-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2890,446,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,5874,'choonann',to_date('15-NOV-19','DD-MON-RR'),'Took profit after REITs correction. Took profit too early.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2891,446,'Keppel DC REIT','AJBU.SI','SGX',3700,2.31,8547,'choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2892,446,'CapitaLand Limited','C31.SI','SGX',1500,3.58,5370,'choonann',to_date('21-OCT-19','DD-MON-RR'),'Did a quick trade for small profit.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2893,446,'Keppel DC REIT','AJBU.SI','SGX',100,2.31,231,'choonann',to_date('27-MAR-20','DD-MON-RR'),'Took profit. Find that KDC has potential in long term, but overvalued.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2894,446,'Keppel DC REIT','AJBU.SI','SGX',1800,2.04,3672,'choonann',to_date('28-NOV-19','DD-MON-RR'),'Exposure in this position is too huge, decided to do portfolio rebalancing. Bought Netlink','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2895,446,'NetLink NBN Trust','CJLU.SI','SGX',6000,0.975,5850,'choonann',to_date('09-AUG-20','DD-MON-RR'),'Slow growth. Going for more growth stocks','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2896,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.8,3200,'choonann',to_date('09-MAR-20','DD-MON-RR'),'Cut 50% loss due to negative outlook impacted by Covid19','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2897,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX',4000,0.775,3100,'choonann',to_date('01-JUL-20','DD-MON-RR'),'Sold for better opportunities','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2898,446,'Frasers Centrepoint Trust','J69U.SI','SGX',2200,2.67,5874,'choonann',to_date('15-NOV-19','DD-MON-RR'),'Execute wrong trade. Sold immediately.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2899,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX',2000,3.22,6440,'choonann',to_date('03-SEP-20','DD-MON-RR'),'Took profit negative outlook impacted by Covid19','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2900,446,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX',1700,4.09,6953,'choonann',to_date('09-AUG-20','DD-MON-RR'),'Parkway yield became low. Decided to sell and raised fund for Tencent','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2901,446,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,51.74,3777.02,'choonann',to_date('19-FEB-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2902,446,'SPDR S&P 500 ETF Trust','SPY','NYSE',10,295,2950,'choonann',to_date('03-FEB-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2903,446,'Alphabet Inc.','GOOG','NASDAQ',2,1098.25,2196.5,'choonann',to_date('04-MAR-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2904,446,'Microsoft Corporation','MSFT','NASDAQ',13,165,2145,'choonann',to_date('08-APR-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2905,446,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,45.75,2333.25,'choonann',to_date('08-APR-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2906,446,'Alibaba Group Holding Limited','BABA','NYSE',11,205.03,2255.33,'choonann',to_date('30-APR-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2907,446,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX',500,76.9,38450,'choonann',to_date('28-MAY-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2908,446,'Alphabet Inc.','GOOG','NASDAQ',1,1390.5,1390.5,'choonann',to_date('27-JUN-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2909,446,'Alibaba Group Holding Limited','BABA','NYSE',6,250.05,1500.3,'choonann',to_date('08-AUG-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2910,446,'Tencent Holdings Limited','0700.HK','HKEX',100,515,51500,'choonann',to_date('09-JUL-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2911,446,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ',13,124.89,1623.57,'choonann',to_date('09-AUG-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2912,446,'Alibaba Group Holding Limited','BABA','NYSE',6,284.01,1704.06,'choonann',to_date('05-NOV-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2913,446,'iShares Hang Seng TECH ETF','9067.HK','HKEX',1200,2.102,2522.4,'choonann',to_date('28-DEC-20','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2914,446,'iShares Hang Seng TECH ETF','9067.HK','HKEX',800,2.452,1961.6,'choonann',to_date('23-FEB-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2915,446,'Amazon.com, Inc.','AMZN','NASDAQ',1,2977,2977,'choonann',to_date('03-MAY-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2916,446,'JD.com, Inc.','JD','NASDAQ',10,78.7,787,'choonann',to_date('28-APR-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2917,446,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC',85,20.6,1751,'choonann',to_date('13-MAY-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2918,446,'iShares Hang Seng TECH ETF','3067.HK','HKEX',1000,15.8,15800,'choonann',to_date('14-MAY-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2919,446,'Alibaba Group Holding Limited','BABA','NYSE',7,213.96,1497.72,'choonann',to_date('18-MAY-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2920,446,'JD.com, Inc.','JD','NASDAQ',27,73.8,1992.6,'choonann',to_date('21-MAY-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2921,446,'Alibaba Group Holding Limited','9988.HK','HKEX',100,184.3,18430,'choonann',to_date('27-JUL-21','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2922,446,'KraneShares CSI China Internet ETF','KWEB','NYSE',73,52.4,3825.2,'choonann',to_date('21-MAY-20','DD-MON-RR'),'Risk of China listed firms delisting.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2923,446,'KraneShares CSI China Internet ETF','KWEB','NYSE',51,53.9,2748.9,'choonann',to_date('20-MAY-20','DD-MON-RR'),'Too much exposure. Sold some shares.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2924,446,'Alphabet Inc.','GOOG','NASDAQ',1,2270,2270,'choonann',to_date('04-SEP-20','DD-MON-RR'),'Took profit','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2925,452,'Alibaba Group Holding Limited','BABA','NYSE',500,150,75000,'testuser',to_date('19-JAN-22','DD-MON-RR'),'TEST','BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2929,446,'Mapletree Commercial Trust','N2IU.SI','SGX',2500,1.85,4625,'choonann',to_date('19-JAN-22','DD-MON-RR'),'Sold due to merge with MNACT.','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2932,452,'Grab Holdings Limited','GRAB','NASDAQ',200,5.51,1102,'testuser',to_date('29-JAN-22','DD-MON-RR'),null,'SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2931,452,'Alibaba Group Holding Limited','BABA','NYSE',500,50,25000,'testuser',to_date('29-JAN-22','DD-MON-RR'),'TEST','SELL');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2954,446,'Amazon.com, Inc.','AMZN','NASDAQ',1,2219.97,2219.97,'choonann',to_date('13-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2960,454,'Plug Power Inc.','PLUG','NASDAQ',200,20,4000,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2961,454,'iShares Hang Seng TECH ETF','3067.HK','HKEX',1000,14.2,14200,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2964,454,'Casa Holdings Limited','C04.SI','SGX',100000,0.08,7500,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2965,454,'Sunny Optical Technology (Group) Company Limited','2382.HK','HKEX',500,113.8,56900,'testuser',to_date('18-MAY-22','DD-MON-RR'),null,'BUY');
Insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,CREATED_BY,CREATED_DT,REMARKS,ACTION) values (2969,452,'Hang Seng Index ETF','2833.HK','HKEX',1000,20,20000,'testuser',to_date('21-MAY-22','DD-MON-RR'),'Testing on first HKEX ETF transaction in Performance','BUY');
REM INSERTING into PMS_REAL_PL
SET DEFINE OFF;
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2935,452,'Adobe Inc.','ADBE','NASDAQ','USD',3,to_date('29-JAN-22','DD-MON-RR'),518.16,518.16,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2936,452,'Adobe Inc.','ADBE','NASDAQ','USD',2,to_date('29-JAN-22','DD-MON-RR'),518.16,518.16,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2940,452,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX','SGD',500,to_date('29-JAN-22','DD-MON-RR'),1.94,1.94,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2942,452,'Mapletree Logistics Trust','M44U.SI','SGX','SGD',2000,to_date('29-JAN-22','DD-MON-RR'),1.69,1.69,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2946,452,'Microsoft Corporation','MSFT','NASDAQ','USD',10,to_date('29-JAN-22','DD-MON-RR'),308.26,308.26,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2950,452,'Mapletree Commercial Trust','N2IU.SI','SGX','SGD',2500,to_date('29-JAN-22','DD-MON-RR'),1.81,1.81,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2938,452,'Meta Platforms, Inc.','FB','NASDAQ','USD',50,to_date('29-JAN-22','DD-MON-RR'),301.71,301.71,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2944,452,'Keppel DC REIT','AJBU.SI','SGX','SGD',1000,to_date('29-JAN-22','DD-MON-RR'),2.16,2.16,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2948,452,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX','SGD',300,to_date('29-JAN-22','DD-MON-RR'),12.42,12.42,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2931,452,'Alibaba Group Holding Limited','BABA','NYSE','USD',500,to_date('29-JAN-22','DD-MON-RR'),150,50,-50000,-69460,-66.67);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2932,452,'Grab Holdings Limited','GRAB','NASDAQ','USD',200,to_date('29-JAN-22','DD-MON-RR'),5.51,5.51,0,0,0);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2890,446,'Frasers Centrepoint Trust','J69U.SI','SGX','SGD',2200,to_date('15-NOV-19','DD-MON-RR'),2.475,2.67,429,429,7.88);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2891,446,'Keppel DC REIT','AJBU.SI','SGX','SGD',3700,to_date('27-MAR-20','DD-MON-RR'),1.485,2.31,3052.5,3052.5,55.56);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2892,446,'CapitaLand Limited','C31.SI','SGX','SGD',1500,to_date('21-OCT-19','DD-MON-RR'),3.48,3.58,150,150,2.87);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2893,446,'Keppel DC REIT','AJBU.SI','SGX','SGD',100,to_date('27-MAR-20','DD-MON-RR'),1.485,2.31,82.5,82.5,55.56);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2894,446,'Keppel DC REIT','AJBU.SI','SGX','SGD',1800,to_date('28-NOV-19','DD-MON-RR'),1.485,2.04,999,999,37.37);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2895,446,'NetLink NBN Trust','CJLU.SI','SGX','SGD',6000,to_date('09-AUG-20','DD-MON-RR'),0.905,0.975,420,420,7.73);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2896,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX','SGD',4000,to_date('03-SEP-20','DD-MON-RR'),0.95,0.8,-600,-600,-15.79);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2897,446,'Lendlease Global Commercial REIT','JYEU.SI','SGX','SGD',4000,to_date('01-JUL-20','DD-MON-RR'),0.95,0.775,-700,-700,-18.42);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2898,446,'Frasers Centrepoint Trust','J69U.SI','SGX','SGD',2200,to_date('15-NOV-19','DD-MON-RR'),2.475,2.67,429,429,7.88);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2899,446,'Ascendas Real Estate Investment Trust','A17U.SI','SGX','SGD',2000,to_date('03-SEP-20','DD-MON-RR'),2.95,3.22,540,540,9.15);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2900,446,'Parkway Life Real Estate Investment Trust','C2PU.SI','SGX','SGD',1700,to_date('09-AUG-20','DD-MON-RR'),2.76,4.09,2261,2261,48.19);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2922,446,'KraneShares CSI China Internet ETF','KWEB','NYSE','USD',73,to_date('21-MAY-20','DD-MON-RR'),49.276,52.4,228.05,313.3,6.34);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2923,446,'KraneShares CSI China Internet ETF','KWEB','NYSE','USD',51,to_date('20-MAY-20','DD-MON-RR'),49.276,53.9,235.82,323.97,9.38);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2924,446,'Alphabet Inc.','GOOG','NASDAQ','USD',1,to_date('04-SEP-20','DD-MON-RR'),1195.667,2270,1074.33,1475.94,89.85);
Insert into PMS_REAL_PL (TRANS_ID,PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,SELL_DT,AVG_COST,SELL_PRICE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (2929,446,'Mapletree Commercial Trust','N2IU.SI','SGX','SGD',2500,to_date('29-JAN-22','DD-MON-RR'),2.27,1.85,-1050,-1050,-18.5);
REM INSERTING into PMS_REAL_PL_TMP
SET DEFINE OFF;
REM INSERTING into PMS_REAL_TOTAL_PL
SET DEFINE OFF;
Insert into PMS_REAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_COST,TOTAL_SOLD_AMT,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (439,'SGD',57918.27,67059.38,9141.11,15.78);
Insert into PMS_REAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_COST,TOTAL_SOLD_AMT,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (441,'SGD',57941.64,67087.68,9146.04,15.78);
Insert into PMS_REAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_COST,TOTAL_SOLD_AMT,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (453,'SGD',3776.86,2697.76,-1079.1,-28.57);
Insert into PMS_REAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_COST,TOTAL_SOLD_AMT,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (440,'SGD',57916.44,67057.17,9140.72,15.78);
Insert into PMS_REAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_COST,TOTAL_SOLD_AMT,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (444,'SGD',134.27,134.27,0,0);
Insert into PMS_REAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_COST,TOTAL_SOLD_AMT,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'SGD',149320.17,79860.17,-69460,-46.52);
Insert into PMS_REAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_COST,TOTAL_SOLD_AMT,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'SGD',63759.97,71886.2,8126.21,12.75);
REM INSERTING into PMS_STOCK_CURR_EXCHG_SPEC
SET DEFINE OFF;
Insert into PMS_STOCK_CURR_EXCHG_SPEC (STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR) values ('iShares Hang Seng TECH ETF','9067.HK','HKEX','USD');
REM INSERTING into PMS_TRIGGER_NOTI
SET DEFINE OFF;
Insert into PMS_TRIGGER_NOTI (ID,WATCH_ID,NXT_TRIGGER_NO,STOCK_NAM,STOCK_SYM,LAST_PRICE,NXT_TRIGGER_PRICE,GEN_DT,USERNAME) values (461,81,0,'Alibaba Group Holding Limited','BABA',111.96,null,to_timestamp('05-AUG-21 10.56.24.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'choonann');
Insert into PMS_TRIGGER_NOTI (ID,WATCH_ID,NXT_TRIGGER_NO,STOCK_NAM,STOCK_SYM,LAST_PRICE,NXT_TRIGGER_PRICE,GEN_DT,USERNAME) values (465,82,1,'CrowdStrike Holdings, Inc.','CRWD',156.29,150,to_timestamp('15-MAY-22 09.58.23.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'choonann');
Insert into PMS_TRIGGER_NOTI (ID,WATCH_ID,NXT_TRIGGER_NO,STOCK_NAM,STOCK_SYM,LAST_PRICE,NXT_TRIGGER_PRICE,GEN_DT,USERNAME) values (462,81,0,'Sea Limited','SE',72.44,null,to_timestamp('25-DEC-21 12.27.10.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'choonann');
Insert into PMS_TRIGGER_NOTI (ID,WATCH_ID,NXT_TRIGGER_NO,STOCK_NAM,STOCK_SYM,LAST_PRICE,NXT_TRIGGER_PRICE,GEN_DT,USERNAME) values (463,82,0,'Adobe Inc.','ADBE',394.295,null,to_timestamp('26-FEB-22 05.30.30.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'choonann');
Insert into PMS_TRIGGER_NOTI (ID,WATCH_ID,NXT_TRIGGER_NO,STOCK_NAM,STOCK_SYM,LAST_PRICE,NXT_TRIGGER_PRICE,GEN_DT,USERNAME) values (464,82,2,'Taiwan Semiconductor Manufacturing Company Limited','TSM',88.81,81.95,to_timestamp('26-FEB-22 05.31.10.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'choonann');
REM INSERTING into PMS_UNREAL_PL
SET DEFINE OFF;
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (455,'SPDR S&P 500 ETF Trust','SPY','NYSE','USD',20,400.05,8001,389.63,7792.6,-208.4,-285.97,-2.6);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (455,'Sembcorp Marine Ltd','S51.SI','SGX','SGD',10000,0.31,3080,0.103,1030,-2050,-2050,-66.56);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (455,'DXC Technology Company','DXC','NYSE','USD',200,25.8,5160,29.6,5920,760,1044.44,14.73);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (455,'China Construction Bank Corporation','0939.HK','HKEX','HKD',15000,5.1,76500,5.61,84150,7650,1339.06,10);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (455,'iShares Core MSCI China ETF','2801.HK','HKEX','HKD',600,22.5,13500,21.14,12684,-816,-142.83,-6.04);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (455,'SPDR Straits Times Index ETF','ES3.SI','SGX','SGD',3000,3.2,9606,3.276,9828,222,222,2.31);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Meta Platforms, Inc.','FB','NASDAQ','USD',12,266.665,3199.98,176.94,2123.28,-1076.7,-1477.45,-33.65);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX','SGD',500,8.68,4340,11.6,5800,1460,1460,33.64);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'CapitaLand China Trust','AU8U.SI','SGX','SGD',3700,1.35,4995,1.11,4107,-888,-888,-17.78);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Mapletree Industrial Trust','ME8U.SI','SGX','SGD',1800,2.71,4878,2.43,4374,-504,-504,-10.33);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'SPDR S&P 500 ETF Trust','SPY','NYSE','USD',10,295,2950,388.04,3880.4,930.4,1276.69,31.54);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Alphabet Inc.','GOOG','NASDAQ','USD',2,1195.667,2391.33,2064.55,4129.1,1737.77,2384.57,72.67);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Microsoft Corporation','MSFT','NASDAQ','USD',13,165,2145,255.12,3316.56,1171.56,1607.61,54.62);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Alibaba Group Holding Limited','BABA','NYSE','USD',30,231.914,6957.41,82.73,2481.9,-4475.51,-6141.29,-64.33);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Ping An Insurance (Group) Company of China, Ltd.','2318.HK','HKEX','HKD',500,76.9,38450,47,23500,-14950,-2612.96,-38.88);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Tencent Holdings Limited','0700.HK','HKEX','HKD',100,515,51500,338,33800,-17700,-3093.61,-34.37);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'CrowdStrike Holdings, Inc.','CRWD','NASDAQ','USD',13,124.89,1623.57,140.78,1830.14,206.57,283.46,12.72);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'iShares Hang Seng TECH ETF','9067.HK','HKEX','USD',2000,2.242,4484,1.07,2140,-2344,-3216.44,-52.27);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Amazon.com, Inc.','AMZN','NASDAQ','USD',2,2598.485,5196.97,2066.375,4132.75,-1064.22,-1460.32,-20.48);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'JD.com, Inc.','JD','NASDAQ','USD',37,75.124,2779.6,49.73,1840.01,-939.59,-1289.31,-33.8);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Ping An Insurance (Group) Company of China, Ltd.','PNGAY','OTC','USD',85,20.6,1751,11.78,1001.3,-749.7,-1028.74,-42.82);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'iShares Hang Seng TECH ETF','3067.HK','HKEX','HKD',1000,15.8,15800,8.41,8410,-7390,-1291.62,-46.77);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Alibaba Group Holding Limited','9988.HK','HKEX','HKD',100,184.3,18430,83.6,8360,-10070,-1760.03,-54.64);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'Adobe Inc.','ADBE','NASDAQ','USD',4,430.85,1723.4,394.295,1577.18,-146.22,-200.64,-8.48);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'Oversea-Chinese Banking Corporation Limited','O39.SI','SGX','SGD',700,12.42,8694,11.72,8204,-490,-490,-5.64);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'Meta Platforms, Inc.','FB','NASDAQ','USD',50,301.71,15085.5,193.54,9677,-5408.5,-7421.54,-35.85);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'Hang Seng Index ETF','2833.HK','HKEX','HKD',1000,20,20000,20.86,20860,860,150.53,4.3);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'CapitaLand Integrated Commercial Trust','C38U.SI','SGX','SGD',500,1.94,970,2.24,1120,150,150,15.46);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'Microsoft Corporation','MSFT','NASDAQ','USD',10,308.26,3082.6,252.56,2525.6,-557,-764.32,-18.07);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'PayPal Holdings, Inc.','PYPL','NASDAQ','USD',5,180,900,80.54,402.7,-497.3,-683.42,-55.26);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'Amazon.com, Inc.','AMZN','NASDAQ','USD',2,2879.56,5759.12,2151.82,4303.64,-1455.48,-1997.21,-25.27);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'Grab Holdings Limited','GRAB','NASDAQ','USD',300,5.51,1653,3.21,963,-690,-948.24,-41.74);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'SPDR S&P 500 ETF Trust','SPY','NYSE','USD',40,408.32,16332.8,389.63,15585.2,-747.6,-1025.86,-4.58);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'KraneShares CSI China Internet ETF','KWEB','NYSE','USD',500,34.54,17270,26.94,13470,-3800,-5220.52,-22);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'Plug Power Inc.','PLUG','NASDAQ','USD',200,20,4000,16.45,3290,-710,-975.41,-17.75);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'iShares Hang Seng TECH ETF','3067.HK','HKEX','HKD',1000,14.2,14200,8.735,8735,-5465,-955.17,-38.49);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'Casa Holdings Limited','C04.SI','SGX','SGD',100000,0.08,7500,0.075,7500,0,0,0);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'Sunny Optical Technology (Group) Company Limited','2382.HK','HKEX','HKD',500,113.8,56900,113.5,56750,-150,-26.24,-0.26);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'Amazon.com, Inc.','AMZN','NASDAQ','USD',5,3200.32,16001.6,2151.82,10759.1,-5242.5,-7193.76,-32.76);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'First Trust Cloud Computing ETF','SKYY','NASDAQ','USD',100,65,6500,66.54,6654,154,211.57,2.37);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'Alphabet Inc.','GOOG','NASDAQ','USD',12,1800.02,21600.24,2186.26,26235.12,4634.88,6359.98,21.46);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'SPDR Straits Times Index ETF','ES3.SI','SGX','SGD',4500,2.39,10764,3.276,14742,3978,3978,36.96);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'City Developments Limited','C09.SI','SGX','SGD',1200,8.14,9768,8.09,9708,-60,-60,-0.61);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'Yangzijiang Financial Holding Ltd.','YF8.SI','SGX','SGD',50000,0.38,19100,0.435,21750,2650,2650,13.87);
Insert into PMS_UNREAL_PL (PORT_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,DOM_CURR,TOTAL_SHARE,AVG_PRICE,TOTAL_AMT,LAST_TRANS_PRICE,MKT_VALUE,PROFIT_LOSS,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'iShares Core MSCI China ETF','2801.HK','HKEX','HKD',1000,21.28,21280,21.14,21140,-140,-24.51,-0.66);
REM INSERTING into PMS_UNREAL_PL_TMP
SET DEFINE OFF;
REM INSERTING into PMS_UNREAL_TOTAL_PL
SET DEFINE OFF;
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (455,'SGD',46526.23,46652.51,126.27,0.27);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (441,'SGD',74205.82,83235.75,9029.94,12.17);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (453,'SGD',3776.86,4287.21,510.35,13.51);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (444,'SGD',3898.58,3944.11,45.53,1.17);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (446,'SGD',84221.71,66269.62,-17952.08,-21.32);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (440,'SGD',67310.58,76631.84,9321.28,13.85);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (452,'SGD',49555.5,37536.01,-12019.49,-24.25);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (454,'SGD',175540.43,173255.47,-2284.97,-1.3);
Insert into PMS_UNREAL_TOTAL_PL (PORT_ID,CONVERT_CURR,TOTAL_AMT,MKT_VALUE,CONV_PROFIT_LOSS,PROFIT_LOSS_PCT) values (439,'SGD',67320.26,76708.84,9388.58,13.95);
REM INSERTING into PMS_USR
SET DEFINE OFF;
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (42,'testuser7','$2a$10$jnrsexNniRvlhjybT.J6puPasGxzHVIoCNxHm.eTFIE8sgOnl5tFy','USER','testuser8@hotmail.com.sg','9999999','Y','choonann',to_date('21-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (39,'testuser4','$2a$10$bdS0KzI9eeEqAeze8IgYCuEQQ4RN/kjH3R5F/H8vczwlxHdK3Ifsa','USER','vincentlai91@hotmail.com','99999999','Y','choonann',to_date('21-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (40,'testuser5','$2a$10$9wWxyIuOcfTg7qt3a.vmFOGsdJjz08BHOJ0DZ.3xm6Us9avQEQNFu','ADMIN','vincentlai91@hotmail.com','99999999','Y','choonann',to_date('21-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (35,'testuser1','$2a$10$1wzxu007I01vjtnQKZbzgewYHMQsPqeyAYJ9w7kuma1eb.n4.h9bG','ADMIN, USER','test@test','99999999','Y','choonann',to_date('21-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (36,'testuser2','$2a$10$gCujkBMziLoUMyOEhhKCY.4M4pdVpwErGUVmhFKVN7HJjjZu9.DPi','ADMIN, USER','testtest@test.com.sg','99999999','Y','choonann',to_date('21-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (62,'testuser9','$2a$10$2ghEnDSxaIVC/tGWfrfBSuJ3tvlv8AzGNxW0/rQpnMsI2xCD1jnbu','ADMIN','test@test.com.sg','99999999','Y','choonann',to_date('22-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (37,'testuser3','$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S','ADMIN, USER','test@test','99999999','Y','choonann',to_date('21-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (41,'testuser6','$2a$10$5SOb8U96UiKIOazr9odg2u0RIX6ytHWjO2KtgGjUSAlLtia9eqcTq','ADMIN, USER','vincentlai@hotmail.com','99667788','Y','choonann',to_date('21-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (1,'choonann','$2a$10$1lOT3CIq7OMVsKo7wdz1xuEh1hBmAW.2ep.uYm1Wk7F.ry4pl3lrS','ADMIN, USER','vincentlai91@hotmail.com','98252798','N','choonann',to_date('04-NOV-20','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (2,'admin','$2a$10$1lOT3CIq7OMVsKo7wdz1xuEh1hBmAW.2ep.uYm1Wk7F.ry4pl3lrS','ADMIN','testadmin@hotmail.com','91234567','N','choonann',to_date('28-NOV-20','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (3,'testuser','$2a$10$t/z.Ppd0AqSJvAcKjTmxhOJ2ag5st/TNHQpGp36tOCNQzqDi2Wa2m','USER','testuser@gmail.com','91234568','N','choonann',to_date('11-DEC-20','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (63,'testuser10','$2a$10$GHIhsyZ2He4QikGki0Ar1.Pp25FRdOtqDUsl2hdvJnPxru3OgorhW','ADMIN, USER','vincentlai91@hotmail.com','99999999','Y','choonann',to_date('22-JAN-21','DD-MON-RR'));
Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,DEL_IND,CREATED_BY,CREATED_DT) values (61,'testuser8','$2a$10$ZjhsxRUNTKU7sGJt1HdNNuU3HTUL8oBPyCkHrGm9WUMZWiYVb3KiW','USER','dummy@dummy.com','99999998','Y','choonann',to_date('22-JAN-21','DD-MON-RR'));
REM INSERTING into PMS_USR_ROLE
SET DEFINE OFF;
Insert into PMS_USR_ROLE (ID,ROLE) values (1,'ADMIN');
Insert into PMS_USR_ROLE (ID,ROLE) values (1,'USER');
Insert into PMS_USR_ROLE (ID,ROLE) values (2,'ADMIN');
Insert into PMS_USR_ROLE (ID,ROLE) values (3,'USER');
REM INSERTING into PMS_WATCHLIST
SET DEFINE OFF;
Insert into PMS_WATCHLIST (ID,NAME,REMARKS,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT) values (82,'My Watchlist','Created on 26 Feb 2022','choonann',to_date('26-FEB-22','DD-MON-RR'),'choonann',to_timestamp('26-FEB-22 05.26.18.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_WATCHLIST (ID,NAME,REMARKS,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT) values (81,'test watchlist',null,'choonann',to_date('05-AUG-21','DD-MON-RR'),'choonann',to_timestamp('05-AUG-21 10.55.56.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
REM INSERTING into PMS_WATCHLIST_ENTRY
SET DEFINE OFF;
Insert into PMS_WATCHLIST_ENTRY (ID,WATCH_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,LAST_PRICE,CHANGE,CHANGE_PCT,TARGET_PRICE,PREMIUM_DISC,REMARKS,LAST_MDFY_BY,LAST_MDFY_DT) values (463,82,'Adobe Inc.','ADBE','NASDAQ',394.295,-12.47,-3.06,457.87,-16.12,null,'choonann',to_timestamp('26-FEB-22 05.32.17.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_WATCHLIST_ENTRY (ID,WATCH_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,LAST_PRICE,CHANGE,CHANGE_PCT,TARGET_PRICE,PREMIUM_DISC,REMARKS,LAST_MDFY_BY,LAST_MDFY_DT) values (464,82,'Taiwan Semiconductor Manufacturing Company Limited','TSM','NYSE',88.81,-2.69,-2.94,107.87,-21.46,null,'choonann',to_timestamp('26-FEB-22 05.32.11.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_WATCHLIST_ENTRY (ID,WATCH_ID,STOCK_NAM,STOCK_SYM,STOCK_EXCHG,LAST_PRICE,CHANGE,CHANGE_PCT,TARGET_PRICE,PREMIUM_DISC,REMARKS,LAST_MDFY_BY,LAST_MDFY_DT) values (462,81,'Sea Limited','SE','NYSE',72.44,-4.81,-6.23,200,-176.09,null,'choonann',to_timestamp('25-DEC-21 12.27.30.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
REM INSERTING into PMS_WATCHLIST_NOTI
SET DEFINE OFF;
Insert into PMS_WATCHLIST_NOTI (ID,WATCH_ID,TRIGGER1_IND,TRIGGER1_PRICE,TRIGGER2_IND,TRIGGER2_PRICE,TRIGGER3_IND,TRIGGER3_PRICE,UP_5PCT_IND,DOWN_5PCT_IND,UP_10PCT_IND,DOWN_10PCT_IND,CUSTOM_UP_IND,CUSTOM_UP_PCT,CUSTOM_DOWN_IND,CUSTOM_DOWN_PCT,DISC_PREM_TYPE,DISC_PREM_PCT,LAST_MDFY_BY,LAST_MDFY_DT) values (461,81,'N',null,'N',null,'N',null,'N','N','N','N','N',null,'N',null,'N',null,'choonann',to_timestamp('25-DEC-21 12.26.38.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_WATCHLIST_NOTI (ID,WATCH_ID,TRIGGER1_IND,TRIGGER1_PRICE,TRIGGER2_IND,TRIGGER2_PRICE,TRIGGER3_IND,TRIGGER3_PRICE,UP_5PCT_IND,DOWN_5PCT_IND,UP_10PCT_IND,DOWN_10PCT_IND,CUSTOM_UP_IND,CUSTOM_UP_PCT,CUSTOM_DOWN_IND,CUSTOM_DOWN_PCT,DISC_PREM_TYPE,DISC_PREM_PCT,LAST_MDFY_BY,LAST_MDFY_DT) values (465,82,'Y',150,'N',null,'N',null,'N','N','N','N','N',null,'N',null,'N',null,'choonann',to_timestamp('15-MAY-22 09.58.23.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_WATCHLIST_NOTI (ID,WATCH_ID,TRIGGER1_IND,TRIGGER1_PRICE,TRIGGER2_IND,TRIGGER2_PRICE,TRIGGER3_IND,TRIGGER3_PRICE,UP_5PCT_IND,DOWN_5PCT_IND,UP_10PCT_IND,DOWN_10PCT_IND,CUSTOM_UP_IND,CUSTOM_UP_PCT,CUSTOM_DOWN_IND,CUSTOM_DOWN_PCT,DISC_PREM_TYPE,DISC_PREM_PCT,LAST_MDFY_BY,LAST_MDFY_DT) values (462,81,'Y',200,'N',null,'N',null,'N','Y','N','Y','N',null,'N',null,'N',null,'choonann',to_timestamp('25-DEC-21 12.27.30.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_WATCHLIST_NOTI (ID,WATCH_ID,TRIGGER1_IND,TRIGGER1_PRICE,TRIGGER2_IND,TRIGGER2_PRICE,TRIGGER3_IND,TRIGGER3_PRICE,UP_5PCT_IND,DOWN_5PCT_IND,UP_10PCT_IND,DOWN_10PCT_IND,CUSTOM_UP_IND,CUSTOM_UP_PCT,CUSTOM_DOWN_IND,CUSTOM_DOWN_PCT,DISC_PREM_TYPE,DISC_PREM_PCT,LAST_MDFY_BY,LAST_MDFY_DT) values (463,82,'Y',457.87,'N',null,'N',null,'Y','Y','Y','Y','N',null,'N',null,'N',null,'choonann',to_timestamp('26-FEB-22 05.32.17.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into PMS_WATCHLIST_NOTI (ID,WATCH_ID,TRIGGER1_IND,TRIGGER1_PRICE,TRIGGER2_IND,TRIGGER2_PRICE,TRIGGER3_IND,TRIGGER3_PRICE,UP_5PCT_IND,DOWN_5PCT_IND,UP_10PCT_IND,DOWN_10PCT_IND,CUSTOM_UP_IND,CUSTOM_UP_PCT,CUSTOM_DOWN_IND,CUSTOM_DOWN_PCT,DISC_PREM_TYPE,DISC_PREM_PCT,LAST_MDFY_BY,LAST_MDFY_DT) values (464,82,'Y',107.87,'Y',81.95,'Y',60.3,'Y','Y','Y','Y','N',null,'N',null,'N',null,'choonann',to_timestamp('26-FEB-22 05.32.11.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
--------------------------------------------------------
--  DDL for Index ID_FOREX_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_FOREX_PK" ON "PMS_FOREX" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_INDEX_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_INDEX_PK" ON "PMS_INDEX" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PK" ON "PMS_USR" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PMS_MSG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PMS_MSG_PK" ON "PMS_MSG" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PMS_PORT_DIV
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PMS_PORT_DIV" ON "PMS_PORT_DIV" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PMS_PORT_HOLD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PMS_PORT_HOLD_PK" ON "PMS_PORT_HOLD" ("PORT_ID", "STOCK_SYM") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PMS_REAL_PL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PMS_REAL_PL_PK" ON "PMS_REAL_PL" ("TRANS_ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PMS_UNREAL_PL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PMS_UNREAL_PL_PK" ON "PMS_UNREAL_PL" ("PORT_ID", "STOCK_SYM") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PMS_WATCHLIST_ENTRY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PMS_WATCHLIST_ENTRY_PK" ON "PMS_WATCHLIST_ENTRY" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PORT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PORT_PK" ON "PMS_PORT" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_PORT_TRANS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_PORT_TRANS_PK" ON "PMS_PORT_TRANS" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index ID_ROLE_UK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_ROLE_UK" ON "PMS_USR_ROLE" ("ID", "ROLE") 
  ;
--------------------------------------------------------
--  DDL for Index ID_WATCHLIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ID_WATCHLIST_PK" ON "PMS_WATCHLIST" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index INDEX_UK
--------------------------------------------------------

  CREATE UNIQUE INDEX "INDEX_UK" ON "PMS_INDEX" ("INDEX_SYM") 
  ;
--------------------------------------------------------
--  DDL for Index MKT_EXCHG_UK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MKT_EXCHG_UK" ON "PMS_MKT_EXCHG" ("MKT_EXCHG_NAME") 
  ;
--------------------------------------------------------
--  DDL for Index PK_ID_PMS_PORT_DIV_DET
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ID_PMS_PORT_DIV_DET" ON "PMS_PORT_DIV_DET" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_PMS_WATCHLIST_NOTI
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_PMS_WATCHLIST_NOTI" ON "PMS_WATCHLIST_NOTI" ("ID", "WATCH_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PMS_CASH_SOL_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "PMS_CASH_SOL_ID" ON "PMS_CASH_SOL" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index PMS_LOAD_DIV_UPLOAD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PMS_LOAD_DIV_UPLOAD_PK" ON "PMS_LOAD_DIV_UPLOAD" ("UPLOAD_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PMS_LOAD_PORT_UPLOAD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PMS_LOAD_PORT_UPLOAD_PK" ON "PMS_LOAD_PORT_UPLOAD" ("UPLOAD_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PMS_TRIGGER_NOTI_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PMS_TRIGGER_NOTI_PK" ON "PMS_TRIGGER_NOTI" ("ID", "WATCH_ID", "STOCK_SYM") 
  ;
--------------------------------------------------------
--  DDL for Index PMS_WATCHLIST_ENTRY_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "PMS_WATCHLIST_ENTRY_UK1" ON "PMS_WATCHLIST_ENTRY" ("WATCH_ID", "STOCK_NAM") 
  ;
--------------------------------------------------------
--  DDL for Index PORT_ID_PMS_REAL_TOTAL_PL_UK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PORT_ID_PMS_REAL_TOTAL_PL_UK" ON "PMS_REAL_TOTAL_PL" ("PORT_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PORT_ID_PMS_UNREAL_TOTAL_PL_UK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PORT_ID_PMS_UNREAL_TOTAL_PL_UK" ON "PMS_UNREAL_TOTAL_PL" ("PORT_ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_IL0000073573C00003$$
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IL0000073573C00003$$" ON "PMS_LOAD_PORT_UPLOAD" (
  ;
--------------------------------------------------------
--  DDL for Index SYS_IL0000073573C00005$$
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IL0000073573C00005$$" ON "PMS_LOAD_PORT_UPLOAD" (
  ;
--------------------------------------------------------
--  DDL for Index SYS_IL0000076001C00003$$
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IL0000076001C00003$$" ON "PMS_LOAD_DIV_UPLOAD" (
  ;
--------------------------------------------------------
--  DDL for Index SYS_IL0000076001C00005$$
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IL0000076001C00005$$" ON "PMS_LOAD_DIV_UPLOAD" (
  ;
--------------------------------------------------------
--  DDL for Index UK_FOREX_NAME
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_FOREX_NAME" ON "PMS_FOREX" ("FOREX_NAME") 
  ;
--------------------------------------------------------
--  DDL for Index UK_FOREX_SYMBOL
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_FOREX_SYMBOL" ON "PMS_FOREX" ("FOREX_SYM") 
  ;
--------------------------------------------------------
--  DDL for Procedure SP_COMPUTE_HOLD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SP_COMPUTE_HOLD" (p_stock in VARCHAR2, p_last_trans_price in NUMBER) AS 

BEGIN
  update PMS_PORT_HOLD set last_trans_price = p_last_trans_price where stock_sym = p_stock;

  update PMS_PORT_HOLD set mkt_value = last_trans_price * total_share;

  update PMS_PORT_HOLD set profit_loss = mkt_value - total_amt, profit_loss_pct = (mkt_value - total_amt)/total_amt * 100;

END SP_COMPUTE_HOLD;

/
--------------------------------------------------------
--  DDL for Procedure SP_POPULATE_PORT_HOLD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SP_POPULATE_PORT_HOLD" (p_id IN NUMBER, p_port_id IN NUMBER, v_error OUT VARCHAR2) AS 

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
          select v_trans.id, v_trans.port_id, v_trans.stock_nam, v_trans.stock_sym, v_trans.stock_exchg, '', v_trans.no_of_share, v_trans.created_dt, 
          hold.avg_price, v_trans.trans_price, v_trans.total_amt - (hold.avg_price * v_trans.no_of_share), null, (v_trans.trans_price - hold.avg_price) /  hold.avg_price * 100 
          from PMS_PORT_HOLD hold 
--          inner join PMS_MKT_EXCHG mkt
--          on hold.stock_exchg = mkt.mkt_exchg_name
          where hold.port_id = p_port_id and hold.stock_sym = v_trans.stock_sym and v_trans.action = 'SELL';
          
          --update currency for non-special stocks with other currency in corresponding stock exchange
          update PMS_REAL_PL u set dom_curr = (select curr from pms_mkt_exchg e where u.stock_exchg = e.mkt_exchg_name)
          where port_id = p_port_id and
          u.stock_sym not in (
            select p.stock_sym from pms_unreal_pl p 
            inner join pms_stock_curr_exchg_spec s
            on p.stock_sym = s.stock_sym
          );
        
          --update currency for special stocks with other currency in corresponding stock exchange. e.g. 9067.HK -> USD
          update PMS_REAL_PL u set u.dom_curr = (select dom_curr from pms_stock_curr_exchg_spec s where u.stock_sym = s.stock_sym)
          where port_id = p_port_id and
          u.stock_sym in (
            select p.stock_sym from pms_unreal_pl p 
            inner join pms_stock_curr_exchg_spec s
            on p.stock_sym = s.stock_sym
          );
          
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
--------------------------------------------------------
--  DDL for Procedure SP_PORT_TRANS_UPLOAD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SP_PORT_TRANS_UPLOAD" (p_id IN NUMBER, p_port_name IN VARCHAR2, v_error_log OUT VARCHAR2) AS 

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
--------------------------------------------------------
--  DDL for Package Body PG_COMPUTE_PL
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PG_COMPUTE_PL" AS

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
              PROFIT_LOSS_PCT from pms_real_pl where port_id = v_port_id and stock_sym = rec.stock_sym and trans_id = rec.trans_id;

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
    
    select id into v_port_id from PMS_PORT where port_name = p_portfolio;

    delete from pms_unreal_pl where port_id = v_port_id;

    insert into pms_unreal_pl (PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, TOTAL_SHARE, AVG_PRICE, TOTAL_AMT, LAST_TRANS_PRICE, 
    MKT_VALUE, PROFIT_LOSS, PROFIT_LOSS_PCT)
    select PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, TOTAL_SHARE, AVG_PRICE, TOTAL_AMT, LAST_TRANS_PRICE, 
    MKT_VALUE, PROFIT_LOSS, PROFIT_LOSS_PCT from pms_port_hold where port_id = v_port_id;
    
    --update currency for non-special stocks with other currency in corresponding stock exchange
    update pms_unreal_pl u set dom_curr = (select curr from pms_mkt_exchg e where u.stock_exchg = e.mkt_exchg_name)
    where port_id = v_port_id and
    u.stock_sym not in (
      select p.stock_sym from pms_unreal_pl p 
      inner join pms_stock_curr_exchg_spec s
      on p.stock_sym = s.stock_sym
    );
  
    --update currency for special stocks with other currency in corresponding stock exchange. e.g. 9067.HK -> USD
    update pms_unreal_pl u set u.dom_curr = (select dom_curr from pms_stock_curr_exchg_spec s where u.stock_sym = s.stock_sym)
    where port_id = v_port_id and
    u.stock_sym in (
      select p.stock_sym from pms_unreal_pl p 
      inner join pms_stock_curr_exchg_spec s
      on p.stock_sym = s.stock_sym
    );

--    update pms_unreal_pl u set dom_curr =
--    (select curr from pms_mkt_exchg e where u.stock_exchg = e.mkt_exchg_name) where port_id = v_port_id;

    FOR rec IN (select * from pms_unreal_pl where port_id = v_port_id)
    LOOP
         dbms_output.put_line('rec.dom_curr: ' || rec.dom_curr || ' p_curr: ' || p_curr);
         if rec.dom_curr = p_curr then
            update pms_unreal_pl set conv_profit_loss = rec.profit_loss where  port_id = v_port_id and stock_sym = rec.stock_sym;

            insert into pms_unreal_pl_tmp
            select port_id, stock_sym, p_curr, total_amt, mkt_value,
            conv_profit_loss, profit_loss_pct from pms_unreal_pl where  port_id = v_port_id and stock_sym = rec.stock_sym;
         else 
            if rec.dom_curr = v_usd_curr then
              select last into v_forex_rate from pms_forex where forex_sym = p_curr || '=X';
            else
              select last into v_forex_rate from pms_forex where forex_sym = rec.dom_curr || p_curr || '=X';
            end if;

            update pms_unreal_pl set conv_profit_loss = profit_loss * v_forex_rate where stock_sym = rec.stock_sym;

            insert into pms_unreal_pl_tmp
            select port_id, stock_sym, p_curr, total_amt * v_forex_rate, mkt_value * v_forex_rate,
            conv_profit_loss, profit_loss_pct from pms_unreal_pl where  port_id = v_port_id and stock_sym = rec.stock_sym;

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
--------------------------------------------------------
--  DDL for Package Body PG_DIV_PROCESS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PG_DIV_PROCESS" AS

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
     
--     update PMS_PORT_DIV_DET div set SGD_DIV_PAYOUT = CONVERT_TO_SGD(DIV_PAYOUT, (SELECT CURR FROM PMS_MKT_EXCHG mkt WHERE mkt.MKT_EXCHG_NAME = div.STOCK_EXCHG)) 
--     where ID = v_param_id;

     --update currency for non-special stocks with other currency in corresponding stock exchange
     update PMS_PORT_DIV_DET div set SGD_DIV_PAYOUT = CONVERT_TO_SGD(DIV_PAYOUT, (SELECT CURR FROM PMS_MKT_EXCHG mkt WHERE mkt.MKT_EXCHG_NAME = div.STOCK_EXCHG)) 
     where ID = v_param_id and
     div.stock_sym not in (
        select stock_sym from pms_stock_curr_exchg_spec s
     );
     
     --update currency for special stocks with other currency in corresponding stock exchange. e.g. 9067.HK -> USD
     update PMS_PORT_DIV_DET div set SGD_DIV_PAYOUT = CONVERT_TO_SGD(DIV_PAYOUT, (select dom_curr from pms_stock_curr_exchg_spec s where div.stock_sym = s.stock_sym)) 
     where ID = v_param_id and
     div.stock_sym not in (
        select stock_sym from pms_stock_curr_exchg_spec s
     );
                    
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
  
  PROCEDURE SP_UPDATE_DIV_REC (p_port_id IN NUMBER, p_stock_sym IN VARCHAR2, p_no_of_share IN NUMBER) AS
  
  v_no_of_share NUMBER(10,0);
  v_id NUMBER;
  
  BEGIN
      
      SELECT ID, NO_OF_SHARE into v_id, v_no_of_share FROM PMS_PORT_DIV WHERE PORT_ID = p_port_id AND STOCK_SYM = p_stock_sym;
      
      IF v_no_of_share = p_no_of_share then
        --sold all existing shares for this stock in portfolio
        UPDATE PMS_PORT_DIV SET CURR_HOLD_IND = 'N', DATE_SOLD = SYSDATE WHERE PORT_ID = p_port_id AND STOCK_SYM = p_stock_sym;
      ELSE
        --sold partial shares for this stock in portfolio, create another entry for leftover shares
        INSERT INTO PMS_PORT_DIV
        SELECT SQ_PMS_PORT_DIV.NEXTVAL, PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, NO_OF_SHARE - p_no_of_share, DATE_PURCHASE, null, 'Y', CREATED_BY
        FROM PMS_PORT_DIV WHERE PORT_ID = p_port_id and STOCK_SYM = p_stock_sym;
        --update previous entry for sold shares
        UPDATE PMS_PORT_DIV SET NO_OF_SHARE = p_no_of_share, CURR_HOLD_IND = 'N', DATE_SOLD = SYSDATE WHERE PORT_ID = p_port_id AND STOCK_SYM = p_stock_sym AND ID = v_id;
      END IF;
      
      EXCEPTION
         WHEN NO_DATA_FOUND THEN 
         --ignore updating of dividend record if this stock does not have dividend
         null;
        
  END;

END PG_DIV_PROCESS;

/
--------------------------------------------------------
--  DDL for Package Body PG_NOTIFICATION_MSG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PG_NOTIFICATION_MSG" AS

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
--------------------------------------------------------
--  DDL for Package Body PG_WATCHLIST_NOTI
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PG_WATCHLIST_NOTI" AS
  
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
--------------------------------------------------------
--  DDL for Package PG_COMPUTE_PL
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PG_COMPUTE_PL" AS 

  PROCEDURE compute_real_pl (
      p_portfolio      IN       VARCHAR2 := NULL,
      p_curr    IN       VARCHAR2 := NULL
   );

   PROCEDURE compute_unreal_pl (
      p_portfolio      IN       VARCHAR2 := NULL,
      p_curr    IN       VARCHAR2 := NULL
   );

   PROCEDURE compute_real_total_pl (
      p_port_id      IN       NUMBER := NULL,
      p_curr    IN       VARCHAR2 := NULL
   );

   PROCEDURE compute_unreal_total_pl (
      p_port_id      IN       NUMBER := NULL,
      p_curr    IN       VARCHAR2  := NULL
   );

END PG_COMPUTE_PL;

/
--------------------------------------------------------
--  DDL for Package PG_DIV_PROCESS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PG_DIV_PROCESS" AS 

  /* TODO enter package declarations (types, exceptions, methods etc) here */ 
  
  PROCEDURE SP_POPULATE_DIV_REC (p_id IN NUMBER, p_ex_date IN DATE, p_adj_div IN NUMBER);
  
  PROCEDURE SP_POPULATE_DIV_REC (p_id IN NUMBER, p_port_id IN NUMBER, p_ex_date IN DATE, p_adj_div IN NUMBER);
  
  PROCEDURE SP_UPDATE_DIV_REC (p_port_id IN NUMBER, p_stock_sym IN VARCHAR2, p_no_of_share IN NUMBER);

END PG_DIV_PROCESS;

/
--------------------------------------------------------
--  DDL for Package PG_NOTIFICATION_MSG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PG_NOTIFICATION_MSG" AS 

    PROCEDURE gen_watchlist_noti_msg;
    
    PROCEDURE gen_trigger_noti_msg(stock_nam VARCHAR2, stock_sym VARCHAR2, 
    trigger_no_type VARCHAR2, trigger_price NUMBER, username VARCHAR2);

END PG_NOTIFICATION_MSG;

/
--------------------------------------------------------
--  DDL for Package PG_WATCHLIST_NOTI
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PG_WATCHLIST_NOTI" AS 

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
--------------------------------------------------------
--  DDL for Function CONVERT_TO_SGD
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "CONVERT_TO_SGD" ( v_val IN number, v_curr IN varchar2)
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
--------------------------------------------------------
--  Constraints for Table PMS_CASH_SOL
--------------------------------------------------------

  ALTER TABLE "PMS_CASH_SOL" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_CASH_SOL" MODIFY ("USR_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_CASH_SOL" MODIFY ("BANK_BAL" NOT NULL ENABLE);
  ALTER TABLE "PMS_CASH_SOL" ADD CONSTRAINT "PMS_CASH_SOL_ID" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_DISC_PREM_NOTI
--------------------------------------------------------

  ALTER TABLE "PMS_DISC_PREM_NOTI" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_DISC_PREM_NOTI" MODIFY ("WATCH_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_DISC_PREM_NOTI" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "PMS_DISC_PREM_NOTI" MODIFY ("WATCHLIST_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_DISC_PREM_NOTI" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_DISC_PREM_NOTI" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_DISC_PREM_NOTI" MODIFY ("USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_FOREX
--------------------------------------------------------

  ALTER TABLE "PMS_FOREX" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_FOREX" MODIFY ("FOREX_NAME" NOT NULL ENABLE);
  ALTER TABLE "PMS_FOREX" MODIFY ("FOREX_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_FOREX" ADD CONSTRAINT "ID_FOREX_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "PMS_FOREX" ADD CONSTRAINT "UK_FOREX_NAME" UNIQUE ("FOREX_NAME")
  USING INDEX  ENABLE;
  ALTER TABLE "PMS_FOREX" ADD CONSTRAINT "UK_FOREX_SYMBOL" UNIQUE ("FOREX_SYM")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_INDEX
--------------------------------------------------------

  ALTER TABLE "PMS_INDEX" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_INDEX" MODIFY ("INDEX_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_INDEX" MODIFY ("INDEX_NAME" NOT NULL ENABLE);
  ALTER TABLE "PMS_INDEX" ADD CONSTRAINT "ID_INDEX_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "PMS_INDEX" ADD CONSTRAINT "INDEX_UK" UNIQUE ("INDEX_SYM")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_LOAD_DIV
--------------------------------------------------------

  ALTER TABLE "PMS_LOAD_DIV" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_LOAD_DIV" MODIFY ("UPLOAD_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_LOAD_DIV" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_LOAD_DIV" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_LOAD_DIV" MODIFY ("DATE_PURCHASE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_LOAD_DIV_UPLOAD
--------------------------------------------------------

  ALTER TABLE "PMS_LOAD_DIV_UPLOAD" ADD CONSTRAINT "PMS_LOAD_DIV_UPLOAD_PK" UNIQUE ("UPLOAD_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_LOAD_PORT_TRANS
--------------------------------------------------------

  ALTER TABLE "PMS_LOAD_PORT_TRANS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_LOAD_PORT_TRANS" MODIFY ("UPLOAD_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_LOAD_PORT_TRANS" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_LOAD_PORT_TRANS" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_LOAD_PORT_UPLOAD
--------------------------------------------------------

  ALTER TABLE "PMS_LOAD_PORT_UPLOAD" ADD CONSTRAINT "PMS_LOAD_PORT_UPLOAD_PK" UNIQUE ("UPLOAD_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_MKT_EXCHG
--------------------------------------------------------

  ALTER TABLE "PMS_MKT_EXCHG" MODIFY ("MKT_EXCHG_NAME" NOT NULL ENABLE);
  ALTER TABLE "PMS_MKT_EXCHG" MODIFY ("CURR" NOT NULL ENABLE);
  ALTER TABLE "PMS_MKT_EXCHG" ADD CONSTRAINT "MKT_EXCHG_UK" UNIQUE ("MKT_EXCHG_NAME")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_MSG
--------------------------------------------------------

  ALTER TABLE "PMS_MSG" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_MSG" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "PMS_MSG" ADD CONSTRAINT "ID_PMS_MSG_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_OTHER_NOTI
--------------------------------------------------------

  ALTER TABLE "PMS_OTHER_NOTI" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_OTHER_NOTI" MODIFY ("WATCH_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_OTHER_NOTI" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "PMS_OTHER_NOTI" MODIFY ("WATCHLIST_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_OTHER_NOTI" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_OTHER_NOTI" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_OTHER_NOTI" MODIFY ("USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_PORT
--------------------------------------------------------

  ALTER TABLE "PMS_PORT" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT" MODIFY ("PORT_NAME" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT" ADD CONSTRAINT "ID_PORT_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_PORT_DIV
--------------------------------------------------------

  ALTER TABLE "PMS_PORT_DIV" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV" ADD CONSTRAINT "ID_PMS_PORT_DIV" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "PMS_PORT_DIV" MODIFY ("NO_OF_SHARE" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV" MODIFY ("DATE_PURCHASE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_PORT_DIV_DET
--------------------------------------------------------

  ALTER TABLE "PMS_PORT_DIV_DET" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV_DET" MODIFY ("DIV_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV_DET" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV_DET" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV_DET" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_DIV_DET" ADD CONSTRAINT "PK_ID_PMS_PORT_DIV_DET" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_PORT_HOLD
--------------------------------------------------------

  ALTER TABLE "PMS_PORT_HOLD" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_HOLD" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_HOLD" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_HOLD" ADD CONSTRAINT "ID_PMS_PORT_HOLD_PK" PRIMARY KEY ("PORT_ID", "STOCK_SYM")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_PORT_TRANS
--------------------------------------------------------

  ALTER TABLE "PMS_PORT_TRANS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_TRANS" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_TRANS" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_TRANS" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_PORT_TRANS" ADD CONSTRAINT "ID_PORT_TRANS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_REAL_PL
--------------------------------------------------------

  ALTER TABLE "PMS_REAL_PL" MODIFY ("TRANS_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_REAL_PL" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_REAL_PL" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_REAL_PL" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_REAL_PL" ADD CONSTRAINT "ID_PMS_REAL_PL_PK" PRIMARY KEY ("TRANS_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_REAL_PL_TMP
--------------------------------------------------------

  ALTER TABLE "PMS_REAL_PL_TMP" MODIFY ("TRANS_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_REAL_PL_TMP" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_REAL_PL_TMP" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_REAL_TOTAL_PL
--------------------------------------------------------

  ALTER TABLE "PMS_REAL_TOTAL_PL" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_REAL_TOTAL_PL" ADD CONSTRAINT "PORT_ID_PMS_REAL_TOTAL_PL_UK" UNIQUE ("PORT_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_STOCK_CURR_EXCHG_SPEC
--------------------------------------------------------

  ALTER TABLE "PMS_STOCK_CURR_EXCHG_SPEC" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_STOCK_CURR_EXCHG_SPEC" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_STOCK_CURR_EXCHG_SPEC" MODIFY ("STOCK_EXCHG" NOT NULL ENABLE);
  ALTER TABLE "PMS_STOCK_CURR_EXCHG_SPEC" MODIFY ("DOM_CURR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_TRIGGER_NOTI
--------------------------------------------------------

  ALTER TABLE "PMS_TRIGGER_NOTI" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_TRIGGER_NOTI" MODIFY ("WATCH_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_TRIGGER_NOTI" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_TRIGGER_NOTI" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_TRIGGER_NOTI" ADD CONSTRAINT "PMS_TRIGGER_NOTI_PK" UNIQUE ("ID", "WATCH_ID", "STOCK_SYM")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_UNREAL_PL
--------------------------------------------------------

  ALTER TABLE "PMS_UNREAL_PL" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_UNREAL_PL" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_UNREAL_PL" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_UNREAL_PL" ADD CONSTRAINT "ID_PMS_UNREAL_PL_PK" PRIMARY KEY ("PORT_ID", "STOCK_SYM")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_UNREAL_PL_TMP
--------------------------------------------------------

  ALTER TABLE "PMS_UNREAL_PL_TMP" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_UNREAL_PL_TMP" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_UNREAL_PL_TMP" MODIFY ("CONVERT_CURR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_UNREAL_TOTAL_PL
--------------------------------------------------------

  ALTER TABLE "PMS_UNREAL_TOTAL_PL" MODIFY ("PORT_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_UNREAL_TOTAL_PL" ADD CONSTRAINT "PORT_ID_PMS_UNREAL_TOTAL_PL_UK" UNIQUE ("PORT_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_USR
--------------------------------------------------------

  ALTER TABLE "PMS_USR" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_USR" MODIFY ("USR_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_USR" MODIFY ("PWD" NOT NULL ENABLE);
  ALTER TABLE "PMS_USR" MODIFY ("ROLES" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PMS_USR_ROLE
--------------------------------------------------------

  ALTER TABLE "PMS_USR_ROLE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_USR_ROLE" MODIFY ("ROLE" NOT NULL ENABLE);
  ALTER TABLE "PMS_USR_ROLE" ADD CONSTRAINT "ID_ROLE_UK" UNIQUE ("ID", "ROLE")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_WATCHLIST
--------------------------------------------------------

  ALTER TABLE "PMS_WATCHLIST" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST" ADD CONSTRAINT "ID_WATCHLIST_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_WATCHLIST_ENTRY
--------------------------------------------------------

  ALTER TABLE "PMS_WATCHLIST_ENTRY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST_ENTRY" MODIFY ("WATCH_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST_ENTRY" MODIFY ("STOCK_NAM" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST_ENTRY" MODIFY ("STOCK_SYM" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST_ENTRY" ADD CONSTRAINT "ID_PMS_WATCHLIST_ENTRY_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "PMS_WATCHLIST_ENTRY" ADD CONSTRAINT "PMS_WATCHLIST_ENTRY_UK1" UNIQUE ("WATCH_ID", "STOCK_NAM")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table PMS_WATCHLIST_NOTI
--------------------------------------------------------

  ALTER TABLE "PMS_WATCHLIST_NOTI" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST_NOTI" MODIFY ("WATCH_ID" NOT NULL ENABLE);
  ALTER TABLE "PMS_WATCHLIST_NOTI" ADD CONSTRAINT "PK_PMS_WATCHLIST_NOTI" PRIMARY KEY ("ID", "WATCH_ID")
  USING INDEX  ENABLE;

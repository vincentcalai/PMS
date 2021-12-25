--------------------------------------------------------
--  DDL for Package PG_DIV_PROCESS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PMS_APP"."PG_DIV_PROCESS" AS 

  /* TODO enter package declarations (types, exceptions, methods etc) here */ 
  
  PROCEDURE SP_POPULATE_DIV_REC (p_id IN NUMBER, p_ex_date IN DATE, p_adj_div IN NUMBER);
  
  PROCEDURE SP_POPULATE_DIV_REC (p_id IN NUMBER, p_port_id IN NUMBER, p_ex_date IN DATE, p_adj_div IN NUMBER);

END PG_DIV_PROCESS;

/

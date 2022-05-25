--------------------------------------------------------
--  DDL for Package PG_COMPUTE_PL
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PMS_APP"."PG_COMPUTE_PL" AS 

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

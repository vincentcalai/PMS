package com.pms.pmsapp.performance.dao;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import com.pms.pmsapp.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Repository
public class PerformanceDaoImpl implements PerformanceDao {

  public ETFPerformance findEtfPerformance(String portfolio) {
    Session session = HibernateUtil.getSessionFactory().openSession();

    String sql = "select sum(total_amt) as INVESTAMT, sum(mkt_value) as CURRENTAM, sum(profit_loss) as PROFIT, (sum(mkt_value)-sum(total_amt))/sum(total_amt) * 100 as PROFITPCT " +
      "from pms_unreal_pl r inner join pms_port p on r.port_id = p.id where p.port_name = :portfolio and r.stock_nam like '%ETF%'";

    SQLQuery sqlQuery = session.createSQLQuery(sql)
      .setParameter("portfolio", portfolio);

    BigDecimal investAmt = new BigDecimal(0);
    BigDecimal currentVal = new BigDecimal(0);
    BigDecimal profit = new BigDecimal(0);
    BigDecimal profitPct = new BigDecimal(0);

    List<Object> result = (List<Object>) sqlQuery.list();
    Iterator itr = result.iterator();
    while(itr.hasNext()){
      Object[] obj = (Object[]) itr.next();
      if(obj[0] != null) {investAmt = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[0])));}
      if(obj[1] != null) {currentVal = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[1])));}
      if(obj[2] != null) {profit = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[2])));}
      if(obj[3] != null) {profitPct = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[3])));}
    }

    ETFPerformance etfPerformance = new ETFPerformance(ETFPerformance.etfName, investAmt, currentVal, profit, profitPct);

    return etfPerformance;
  }

  public StockPerformance findStockPerformance(String portfolio) {
    Session session = HibernateUtil.getSessionFactory().openSession();

    String sql = "select sum(total_amt) as INVESTAMT, sum(mkt_value) as CURRENTAM, sum(profit_loss) as PROFIT, (sum(mkt_value)-sum(total_amt))/sum(total_amt) * 100 as PROFITPCT " +
      "from pms_unreal_pl r inner join pms_port p on r.port_id = p.id where p.port_name = :portfolio and r.stock_nam not like '%ETF%'";

    SQLQuery sqlQuery = session.createSQLQuery(sql)
      .setParameter("portfolio", portfolio);

    BigDecimal investAmt = new BigDecimal(0);
    BigDecimal currentVal = new BigDecimal(0);
    BigDecimal profit = new BigDecimal(0);
    BigDecimal profitPct = new BigDecimal(0);

    List<Object> result = (List<Object>) sqlQuery.list();
    Iterator itr = result.iterator();
    while(itr.hasNext()){
      Object[] obj = (Object[]) itr.next();
      if(obj[0] != null) {investAmt = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[0])));}
      if(obj[1] != null) {currentVal = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[1])));}
      if(obj[2] != null) {profit = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[2])));}
      if(obj[3] != null) {profitPct = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[3])));}
    }

    StockPerformance stockPerformance = new StockPerformance(StockPerformance.stockName, investAmt, currentVal, profit, profitPct);

    return stockPerformance;
  }
}

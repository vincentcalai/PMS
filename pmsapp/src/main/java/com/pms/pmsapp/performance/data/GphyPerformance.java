package com.pms.pmsapp.performance.data;

import java.math.BigDecimal;

public class GphyPerformance {

  public BigDecimal usAllocation;

  public BigDecimal hkAllocation;

  public BigDecimal sgAllocation;

  public GphyPerformance(BigDecimal usAllocation, BigDecimal hkAllocation, BigDecimal sgAllocation) {
    this.usAllocation = usAllocation;
    this.hkAllocation = hkAllocation;
    this.sgAllocation = sgAllocation;
  }

  public BigDecimal getUsAllocation() {
    return usAllocation;
  }

  public void setUsAllocation(BigDecimal usAllocation) {
    this.usAllocation = usAllocation;
  }

  public BigDecimal getHkAllocation() {
    return hkAllocation;
  }

  public void setHkAllocation(BigDecimal hkAllocation) {
    this.hkAllocation = hkAllocation;
  }

  public BigDecimal getSgAllocation() {
    return sgAllocation;
  }

  public void setSgAllocation(BigDecimal sgAllocation) {
    this.sgAllocation = sgAllocation;
  }
}

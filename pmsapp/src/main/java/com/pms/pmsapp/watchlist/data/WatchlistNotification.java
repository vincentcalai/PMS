package com.pms.pmsapp.watchlist.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WatchlistNotification implements Serializable{
	
	private Long id;
	private Long watchId;
	private String trigger1Ind;
	private BigDecimal trigger1Price;
	private String trigger2Ind;
	private BigDecimal trigger2Price;
	private String trigger3Ind;
	private BigDecimal trigger3Price;
	private String up5PctInd;
	private String down5PctInd;
	private String up10PctInd;
	private String down10PctInd;
	private String customUpInd;
	private BigDecimal customUpPct;
	private String customDownInd;
	private BigDecimal customDownPct;
	private String discPremType;
	private BigDecimal discPremPct;
	private String lastMdfyBy;
	private Date lastMdfyDt;
	
	public WatchlistNotification() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((watchId == null) ? 0 : watchId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WatchlistNotification other = (WatchlistNotification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (watchId == null) {
			if (other.watchId != null)
				return false;
		} else if (!watchId.equals(other.watchId))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWatchId() {
		return watchId;
	}

	public void setWatchId(Long watchId) {
		this.watchId = watchId;
	}

	public String getTrigger1Ind() {
		return trigger1Ind;
	}

	public void setTrigger1Ind(String trigger1Ind) {
		this.trigger1Ind = trigger1Ind;
	}

	public BigDecimal getTrigger1Price() {
		return trigger1Price;
	}

	public void setTrigger1Price(BigDecimal trigger1Price) {
		this.trigger1Price = trigger1Price;
	}

	public String getTrigger2Ind() {
		return trigger2Ind;
	}

	public void setTrigger2Ind(String trigger2Ind) {
		this.trigger2Ind = trigger2Ind;
	}

	public BigDecimal getTrigger2Price() {
		return trigger2Price;
	}

	public void setTrigger2Price(BigDecimal trigger2Price) {
		this.trigger2Price = trigger2Price;
	}

	public String getTrigger3Ind() {
		return trigger3Ind;
	}

	public void setTrigger3Ind(String trigger3Ind) {
		this.trigger3Ind = trigger3Ind;
	}

	public BigDecimal getTrigger3Price() {
		return trigger3Price;
	}

	public void setTrigger3Price(BigDecimal trigger3Price) {
		this.trigger3Price = trigger3Price;
	}

	public String getUp5PctInd() {
		return up5PctInd;
	}

	public void setUp5PctInd(String up5PctInd) {
		this.up5PctInd = up5PctInd;
	}

	public String getDown5PctInd() {
		return down5PctInd;
	}

	public void setDown5PctInd(String down5PctInd) {
		this.down5PctInd = down5PctInd;
	}

	public String getUp10PctInd() {
		return up10PctInd;
	}

	public void setUp10PctInd(String up10PctInd) {
		this.up10PctInd = up10PctInd;
	}

	public String getDown10PctInd() {
		return down10PctInd;
	}

	public void setDown10PctInd(String down10PctInd) {
		this.down10PctInd = down10PctInd;
	}

	public String getCustomUpInd() {
		return customUpInd;
	}

	public void setCustomUpInd(String customUpInd) {
		this.customUpInd = customUpInd;
	}

	public BigDecimal getCustomUpPct() {
		return customUpPct;
	}

	public void setCustomUpPct(BigDecimal customUpPct) {
		this.customUpPct = customUpPct;
	}

	public String getCustomDownInd() {
		return customDownInd;
	}

	public void setCustomDownInd(String customDownInd) {
		this.customDownInd = customDownInd;
	}

	public BigDecimal getCustomDownPct() {
		return customDownPct;
	}

	public void setCustomDownPct(BigDecimal customDownPct) {
		this.customDownPct = customDownPct;
	}
	
	public String getDiscPremType() {
		return discPremType;
	}

	public void setDiscPremType(String discPremType) {
		this.discPremType = discPremType;
	}

	public BigDecimal getDiscPremPct() {
		return discPremPct;
	}

	public void setDiscPremPct(BigDecimal discPremPct) {
		this.discPremPct = discPremPct;
	}

	public String getLastMdfyBy() {
		return lastMdfyBy;
	}

	public void setLastMdfyBy(String lastMdfyBy) {
		this.lastMdfyBy = lastMdfyBy;
	}

	public Date getLastMdfyDt() {
		return lastMdfyDt;
	}

	public void setLastMdfyDt(Date lastMdfyDt) {
		this.lastMdfyDt = lastMdfyDt;
	}
	
}

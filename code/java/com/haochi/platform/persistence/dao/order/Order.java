package com.haochi.platform.persistence.dao.order;

import java.util.Date;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
public class Order extends AbstractOrder implements java.io.Serializable {

	// Constructors

	private static final long serialVersionUID = 1042334153507946051L;
	
	private String tableDisplayText;
	
	private boolean loaded = false;
	
	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Integer orderid, Integer orderuserid, Integer orderdocid,
			Date orderdate, Integer orderstartblock, String ordertreatmentid) {
		super(orderid, orderuserid, orderdocid, orderdate, orderstartblock,
				ordertreatmentid);
	}
	
	public void statusUpdateWhenLoadingFromDB() {
		loaded = true;
		tableDisplayText = super.getOrderuserid() + "";
	}

	public String getTableDisplayText() {
		return tableDisplayText;
	}

	public void setTableDisplayText(String tableDisplayText) {
		this.tableDisplayText = tableDisplayText;
	}

	public boolean getLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	
}

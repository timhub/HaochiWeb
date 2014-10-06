package com.haochi.platform.persistence.dao.order;

import java.util.Date;

/**
 * AbstractOrder entity provides the base persistence definition of the Order
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrder implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 232276209968813976L;
	
	private Integer orderid;
	private Integer orderuserid;
	private Integer orderdocid;
	private Date orderdate;
	private Integer orderstartblock;
	private String ordertreatmentid;
	private String orderinfo;

	// Constructors

	/** default constructor */
	public AbstractOrder() {
	}

	/** full constructor */
	public AbstractOrder(Integer orderid, Integer orderuserid,
			Integer orderdocid, Date orderdate, Integer orderstartblock,
			String ordertreatmentid, String orderinfo) {
		this.orderid = orderid;
		this.orderuserid = orderuserid;
		this.orderdocid = orderdocid;
		this.orderdate = orderdate;
		this.orderstartblock = orderstartblock;
		this.ordertreatmentid = ordertreatmentid;
		this.orderinfo = orderinfo;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getOrderuserid() {
		return this.orderuserid;
	}

	public void setOrderuserid(Integer orderuserid) {
		this.orderuserid = orderuserid;
	}

	public Integer getOrderdocid() {
		return this.orderdocid;
	}

	public void setOrderdocid(Integer orderdocid) {
		this.orderdocid = orderdocid;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Integer getOrderstartblock() {
		return this.orderstartblock;
	}

	public void setOrderstartblock(Integer orderstartblock) {
		this.orderstartblock = orderstartblock;
	}

	public String getOrdertreatmentid() {
		return this.ordertreatmentid;
	}

	public void setOrdertreatmentid(String ordertreatmentid) {
		this.ordertreatmentid = ordertreatmentid;
	}

	public String getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(String orderinfo) {
		this.orderinfo = orderinfo;
	}

}
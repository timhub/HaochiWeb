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
	private Integer orderendblock;
	private String ordertreatmentid;

	// Constructors

	/** default constructor */
	public AbstractOrder() {
	}

	/** full constructor */
	public AbstractOrder(Integer orderid, Integer orderuserid,
			Integer orderdocid, Date orderdate, Integer orderstartblock,
			Integer orderendblock, String ordertreatmentid) {
		this.orderid = orderid;
		this.orderuserid = orderuserid;
		this.orderdocid = orderdocid;
		this.orderdate = orderdate;
		this.orderstartblock = orderstartblock;
		this.orderendblock = orderendblock;
		this.ordertreatmentid = ordertreatmentid;
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

	public Integer getOrderendblock() {
		return this.orderendblock;
	}

	public void setOrderendblock(Integer orderendblock) {
		this.orderendblock = orderendblock;
	}

	public String getOrdertreatmentid() {
		return this.ordertreatmentid;
	}

	public void setOrdertreatmentid(String ordertreatmentid) {
		this.ordertreatmentid = ordertreatmentid;
	}

}
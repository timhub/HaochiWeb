package com.haochi.platform.persistence.dao;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
public class Order extends AbstractOrder implements java.io.Serializable {

	// Constructors

	private static final long serialVersionUID = 1042334153507946051L;

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Integer orderid, Integer orderuserid, Integer orderdocid,
			String orderdate, Integer orderstartblock, Integer orderendblock,
			String ordertreatmentid) {
		super(orderid, orderuserid, orderdocid, orderdate, orderstartblock,
				orderendblock, ordertreatmentid);
	}

}

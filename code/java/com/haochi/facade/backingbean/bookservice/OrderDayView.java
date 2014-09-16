package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;

import com.haochi.platform.persistence.dao.order.Order;

public class OrderDayView implements Serializable{
	
	private static final long serialVersionUID = 2129163233860339374L;
	
	private Order[] dayOrderList = new Order[4];
	private String dateText;
	
	public OrderDayView() {
		
	}
	
	public OrderDayView(Order[] orderList) {
		this.dayOrderList = orderList;
	}

	public Order[] getDayOrderList() {
		return dayOrderList;
	}

	public void setDayOrderList(Order[] dayOrderList) {
		this.dayOrderList = dayOrderList;
		this.dateText = dayOrderList[0].getOrderdate().toString();
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

}

package com.haochi.facade.backingbean.bookservice;

import com.haochi.platform.persistence.dao.order.Order;

public class OrderDayView {
	
	private Order[] dayOrderList = new Order[4];
	
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
	}

}

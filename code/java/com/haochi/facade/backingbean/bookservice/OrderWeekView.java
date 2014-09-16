package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;

/**
 * This class is used for displaying data of book information in both month view and
 * week view to iterate all the required data.
 *
 * @author Tim
 */
public class OrderWeekView implements Serializable{
	
	private static final long serialVersionUID = -1108426969499644818L;
	
	private OrderDayView[] dayOrderList = new OrderDayView[7];
	
	public OrderWeekView() {
		
	}
	
	public OrderWeekView(OrderDayView[] orderDayList) {
		this.dayOrderList = orderDayList;
	}

	public OrderDayView[] getDayOrderList() {
		return dayOrderList;
	}

	public void setDayOrderList(OrderDayView[] weekOrderList) {
		this.dayOrderList = weekOrderList;
	}
	
}

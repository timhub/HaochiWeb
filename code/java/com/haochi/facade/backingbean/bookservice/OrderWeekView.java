package com.haochi.facade.backingbean.bookservice;

/**
 * This class is used for displaying data of book information in both month view and
 * week view to iterate all the required data.
 *
 * @author Tim
 */
public class OrderWeekView {
	
	private OrderDayView[] weekOrderList = new OrderDayView[7];
	
	public OrderWeekView() {
		
	}
	
	public OrderWeekView(OrderDayView[] orderDayList) {
		this.weekOrderList = orderDayList;
	}

	public OrderDayView[] getWeekOrderList() {
		return weekOrderList;
	}

	public void setWeekOrderList(OrderDayView[] weekOrderList) {
		this.weekOrderList = weekOrderList;
	}
	
}

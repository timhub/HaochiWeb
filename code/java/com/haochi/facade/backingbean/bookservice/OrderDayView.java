package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;
import java.text.MessageFormat;

import com.haochi.platform.persistence.dao.order.Order;
import com.haochi.service.utility.PropertyUtils;

public class OrderDayView implements Serializable{
	
	private static final long serialVersionUID = 2129163233860339374L;
	
	private Order[] dayOrderList = new Order[4];
	private String displayText;
	private String weekViewDisplayText;
	private boolean loaded = false;
	private boolean fullLoaded = false;
	private boolean orderable = false;
	
	private static final String BASE_DISPLAY_TEXT = "book_month_view_text";
	private static final String BASE_WEEK_VIEW_DISPLAY_TEXT = "book_table_month_date_text";
	
	/**
	 * Generate the string that book table need to see.
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public void processDisplayText() {
		String baseString = PropertyUtils.getInstance().getProperty(
				BASE_DISPLAY_TEXT);
		int blockNumber = 4;
		for (Order order : dayOrderList) {
			if (order.getOrderdocid() != null) {
				blockNumber--;
			}
		}
		if (blockNumber == 0) {
			setFullLoaded(true);
		}
		Object[] fillString = { dayOrderList[0].getOrderdate().getDate() + "", blockNumber + "" };

		setDisplayText(MessageFormat.format(baseString, fillString)); 
	}
	
	@SuppressWarnings("deprecation")
	private void processWeekDisplayText() {
		String baseString = PropertyUtils.getInstance().getProperty(
				BASE_WEEK_VIEW_DISPLAY_TEXT);
		Object[] fillString = {dayOrderList[0].getOrderdate().getMonth() + 1 + "",
				dayOrderList[0].getOrderdate().getDate() + ""};
		
		setWeekViewDisplayText(MessageFormat.format(baseString, fillString));
	}
	
	public OrderDayView() {
		loaded = false;
	}
	
	public OrderDayView(Order[] orderList) {
		this.dayOrderList = orderList;
	}

	public Order[] getDayOrderList() {
		return dayOrderList;
	}

	public void setDayOrderList(Order[] dayOrderList) {
		this.dayOrderList = dayOrderList;
		processDisplayText();
		processWeekDisplayText();
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public boolean getLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public boolean getFullLoaded() {
		return fullLoaded;
	}

	public void setFullLoaded(boolean fullLoaded) {
		this.fullLoaded = fullLoaded;
	}

	public String getWeekViewDisplayText() {
		return weekViewDisplayText;
	}

	public void setWeekViewDisplayText(String weekViewDisplayText) {
		this.weekViewDisplayText = weekViewDisplayText;
	}

	public boolean getOrderable() {
		return orderable;
	}

	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}

}

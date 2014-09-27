package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;
import java.text.MessageFormat;

import com.haochi.platform.persistence.dao.order.Order;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.PropertyUtils;

public class OrderDayView implements Serializable{
	
	private static final long serialVersionUID = 2129163233860339374L;
	
	private Order[] dayOrderList = new Order[4];
	private String displayText;
	private boolean loaded;
	private boolean fullLoaded = false;
	
	private static final String BASE_DISPLAY_TEXT = "book_month_view_text";
	
	/**
	 * Generate the string that book table need to see.
	 * @return
	 */
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
		String[] fillString = { dayOrderList[0].getOrderdate().getDate() + "", blockNumber + "" };

		setDisplayText(MessageFormat.format(baseString, fillString)); 
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

}

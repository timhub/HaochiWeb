package com.haochi.service.order;

import java.util.Calendar;
import java.util.List;

import com.haochi.platform.persistence.dao.order.Order;
import com.haochi.platform.persistence.dao.order.OrderDAO;
import com.haochi.service.utility.DateUtility;

public class BookService {
	private static OrderDAO orderDao;
	
	private DateUtility dateUtil;
	
	public BookService() {
		orderDao = new OrderDAO();
		dateUtil = new DateUtility();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Order> getOrderInCurrentMonth(int docId, int treatId) {
		List resultList = null;
		
		int month = dateUtil.getCalendar().get(Calendar.MONTH);
		int maxDay = dateUtil.getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH);
		String baseDate = dateUtil.getCalendar().get(Calendar.YEAR) 
				+ "-" + (month > 9 ? month : "0" + month);
		String startDate = baseDate + "-01";
		String endDate = baseDate + "-" + (maxDay + 1);
		resultList = orderDao.findByMonthView(startDate, endDate, docId);
		
		return resultList;
	}
	
	public static void deleteOrderByInfo(int userId, int docId, int startBlock,int treatmentId, String orderDate) {
		
	}
	
	public static void updateOrder(Order instance) {
		orderDao.save(instance);
	}
}

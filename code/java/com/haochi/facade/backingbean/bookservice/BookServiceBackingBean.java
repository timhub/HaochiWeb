package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.context.FacesContext;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.facade.backingbean.selection.SelectFunctionBackingBean;
import com.haochi.platform.persistence.dao.order.Order;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.DateUtility;

/**
 * This class controls the logic for booking services. It loaded all the date cells and display the
 * data on the page.
 *
 * @author Tim
 */
public class BookServiceBackingBean extends BaseBackingBean implements Serializable {

	private static final long serialVersionUID = -1892860394801931271L;
	
	public OrderWeekView[] weekViewList = new OrderWeekView[5];
	private String selectedDate;
	private DateUtility dateUtil;
	
	private Integer selectMonth;
	private Integer monthOffset;
	
	public BookServiceBackingBean() {
		dateUtil = DateUtility.getInstance();
		
		setMonthOffset(0);
		initialDateGrid();
	}
	
	/**
	 * Initialize the date grid with date time data within each cell before loading the
	 * data within each day.
	 */
	public void initialDateGrid() {
		int maxWeekCount = 0;
		int loadedWeek = 0;
		Calendar calendar = null;
		
//		SelectFunctionBackingBean selectBacBean = (SelectFunctionBackingBean) FacesContext.getCurrentInstance().getApplication()
//				.getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), 
//						null, "selectionServiceBackingBean");
		
		
		calendar = dateUtil.getCalendar();
		calendar.setTime(dateUtil.getCurrentDate());
		//Get selected month by offset.
		calendar.add(Calendar.MONTH, monthOffset);
		calendar.set(Calendar.DATE, 1);
		maxWeekCount = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		while(loadedWeek < maxWeekCount) {
			OrderWeekView week;
			if(loadedWeek == 0) {
				week = new OrderWeekView();
				int daysInFirstWeek = dateUtil.getDaysInFirstWeek();
				int startDay = CommonConstants.MAX_DAYS_IN_WEEK - daysInFirstWeek;
				OrderDayView[] dayViewList = new OrderDayView[7];
				for(int emtDay = 0; emtDay < startDay; emtDay ++) {
					dayViewList[emtDay] = null;
				}
				for(int i = startDay; i < CommonConstants.MAX_DAYS_IN_WEEK; i ++) {
					OrderDayView dayView = initialDay();
					dayViewList[i] = dayView;
					calendar.add(Calendar.DAY_OF_MONTH, 1);
				}
				week.setDayOrderList(dayViewList);
				weekViewList[loadedWeek] = week;
				loadedWeek ++;
			} else {
				week = new OrderWeekView();
				OrderDayView[] dayViewList = new OrderDayView[7];
				for(int i = 0; i < CommonConstants.MAX_DAYS_IN_WEEK; i ++) {
					if(calendar.get(Calendar.DAY_OF_MONTH) == 1){
						break;
					} else {
						OrderDayView dayView = initialDay();
						dayViewList[i] = dayView;
						dateUtil.getCalendar().add(Calendar.DAY_OF_MONTH, 1);
					}
				}
				week.setDayOrderList(dayViewList);
				weekViewList[loadedWeek] = week;
				loadedWeek++;
			}
		}
	}
	
	/**
	 * Initialize cells within each day.
	 * @return
	 */
	private OrderDayView initialDay() {
		OrderDayView dayView = new OrderDayView();
		Order[] orderList = new Order[4];
		for(int dayOrderNumber = 0; dayOrderNumber < 4; dayOrderNumber ++) {
			Order newOrder = new Order();
			newOrder.setOrderdate(dateUtil.getCalendar().getTime());
			orderList[dayOrderNumber] = newOrder;
		}
		dayView.setDayOrderList(orderList);
		return dayView;
	}
	
	/**
	 * Checking out all the orders within the <b>current month</b>.
	 * Select the orders by userId, docId, treatId and time period.
	 */
	public void loadAllOrdersFromDB() {
		
	}
	
	/**
	 * User operation to change the view of the grid to see the next month's book.
	 */
	public void checkNextMonth() {
		
	}
	
	public Integer getSelectMonth() {
		return selectMonth;
	}

	public void setSelectMonth(Integer selectMonth) {
		this.selectMonth = selectMonth;
	}

	public String getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}

	public OrderWeekView[] getWeekViewList() {
		return weekViewList;
	}

	public void setWeekViewList(OrderWeekView[] monthlyViewList) {
		this.weekViewList = monthlyViewList;
	}

	public Integer getMonthOffset() {
		return monthOffset;
	}

	public void setMonthOffset(Integer monthOffset) {
		this.monthOffset = monthOffset;
	}

}

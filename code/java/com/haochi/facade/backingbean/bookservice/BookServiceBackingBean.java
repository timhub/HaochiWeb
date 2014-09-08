package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.platform.persistence.dao.doctorinfo.Doctorinfo;
import com.haochi.platform.persistence.dao.order.Order;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.DateUtility;
import com.haochi.service.utility.SelectionHandler;

/**
 * This class controls the logic for booking services. It loaded all the date cells and display the
 * data on the page.
 *
 * @author Tim
 */
public class BookServiceBackingBean extends BaseBackingBean implements Serializable {

	private static final long serialVersionUID = -1892860394801931271L;
	
	private OrderWeekView[] monthlyViewList = {};
	private String selectedDate;
	private DateUtility dateUtil;
	private SelectionHandler selection;
	private boolean selectionAllSet;
	
	private Integer selectMonth;
	private Integer monthOffset;
	
	private Integer doctorId;
	private Integer treatmentId;
	
	private List<Doctorinfo> docList;
	
	public BookServiceBackingBean() {
		dateUtil = DateUtility.getInstance();
		selection = SelectionHandler.getInstance();
		
		doctorId = selection.getDocId();
		treatmentId = selection.getTreatmentId();
		docList = new ArrayList<Doctorinfo>();
		setMonthOffset(0);
		checkSelection();
		initialDateGrid();
	}
	
	/**
	 * Initialize the date grid with date time data within each cell before loading the
	 * data within each day.
	 */
	public void initialDateGrid() {
		int maxDateCount = 0;
		int maxWeekCount = 0;
		int loadedWeek = 0;
		int loadedDay = 0;
		Calendar calendar = null;
		
		if(selectionAllSet) {
			calendar = dateUtil.getCalendar();
			//Get selected month by offset.
			calendar.add(Calendar.MONTH, monthOffset);
			
			maxDateCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			maxWeekCount = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		}
		
		while(loadedWeek < maxWeekCount) {
			OrderWeekView week = new OrderWeekView();
			if(loadedWeek == 0) {
				int daysInFirstWeek = dateUtil.getDaysInFirstWeek();
				int startDay = CommonConstants.MAX_DAYS_IN_WEEK - daysInFirstWeek;
				OrderDayView[] dayViewList = new OrderDayView[7];
				for(int emtDay = 0; emtDay < startDay; emtDay ++) {
					dayViewList[emtDay] = null;
				}
				for(int i = startDay; i < CommonConstants.MAX_DAYS_IN_WEEK; i ++) {
					OrderDayView dayView = initialDay();
					dayViewList[i] = dayView;
					dateUtil.getCalendar().add(Calendar.DAY_OF_MONTH, 1);
					loadedDay ++;
				}
				week.setWeekOrderList(dayViewList);
				loadedWeek ++;
			} else {
				OrderDayView[] dayViewList = new OrderDayView[7];
				for(int i = 0; i < CommonConstants.MAX_DAYS_IN_WEEK; i ++) {
					if(loadedDay > maxDateCount){
						break;
					} else {
						OrderDayView dayView = initialDay();
						dayViewList[i] = dayView;
						dateUtil.getCalendar().add(Calendar.DAY_OF_MONTH, 1);
						loadedDay ++;
					}
				}
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
	 */
	private void loadAllOrdersFromDB() {
		
	}
	
	/**
	 * User operation to change the view of the grid to see the next month's book.
	 */
	public void checkNextMonth() {
		
	}
	
	/**
	 * Check the condition of the page selection, the date table could only be shown when
	 * user finish the doctor and treatment selection.
	 */
	private void checkSelection() {
		if(doctorId != CommonConstants.NON_AVALIABLE_CODE 
				&& treatmentId != CommonConstants.NON_AVALIABLE_CODE ) {
			selectionAllSet = true;
		} else {
			selectionAllSet = false;
		}
	}
	
	
	
	/**
	 * Clean the selection after operations.
	 */
	private void cleanSelection() {
		selection.setDocId(-1);
		selection.setTreatmentId(-1);
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

	public OrderWeekView[] getMonthlyViewList() {
		return monthlyViewList;
	}

	public void setMonthlyViewList(OrderWeekView[] monthlyViewList) {
		this.monthlyViewList = monthlyViewList;
	}

	public Integer getMonthOffset() {
		return monthOffset;
	}

	public void setMonthOffset(Integer monthOffset) {
		this.monthOffset = monthOffset;
	}

}

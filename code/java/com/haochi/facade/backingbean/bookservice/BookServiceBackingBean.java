package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.facade.backingbean.selection.SelectFunctionBackingBean;
import com.haochi.platform.persistence.dao.order.Order;
import com.haochi.platform.persistence.dao.userinfo.Userinfo;
import com.haochi.service.order.BookService;
import com.haochi.service.userinfo.UserInfoService;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.DateUtility;
import com.haochi.service.utility.PropertyUtils;

/**
 * This class controls the logic for booking services. It loaded all the date cells and display the
 * data on the page.
 *
 * @author Tim
 */
public class BookServiceBackingBean extends BaseBackingBean implements Serializable {

	private static final long serialVersionUID = -1892860394801931271L;

	public  OrderWeekView[]   			weekViewList;
	private String 						selectedDate;
	private DateUtility 				dateUtil;

	private Integer 					selectMonth;
	private Integer 					monthOffset;

	static  SelectFunctionBackingBean 	selectBacBean;

	private Userinfo 					currentUser;
	private int 						currentMonth;
	
	private String[] 					headerText;
	
	private static final String			HEADER_STRING_KEY = "book_table_header_list";									
	
	public BookServiceBackingBean() {
		UserInfoService service = new UserInfoService();
		dateUtil = DateUtility.getInstance();
		getCurrentSelectBean();
		headerText = PropertyUtils.getInstance().getProperty(HEADER_STRING_KEY)
				.split(CommonConstants.STRING_SPLIT_SYMBOL);
			
		if(selectBacBean!= null) {
			selectBacBean.setSelectedDocId(-1);
			selectBacBean.setSelectedTreatId(-1);
		}
		//Get current login user.
		HttpSession session  = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session != null) {
			currentUser = service.findUserByName((String)session.getAttribute("username"));
		}
		
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
		
		calendar = dateUtil.getCalendar();
		calendar.setTime(dateUtil.getCurrentDate());
		//Get selected month by offset.
		calendar.add(Calendar.MONTH, monthOffset);
		setCurrentMonth(dateUtil.getCalendar().get(Calendar.MONTH) + 1);
		calendar.set(Calendar.DATE, 1);
		maxWeekCount = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		weekViewList = new OrderWeekView[maxWeekCount];
		
		while(loadedWeek < maxWeekCount) {
			OrderWeekView week;
			if(loadedWeek == 0) {
				week = new OrderWeekView();
				int daysInFirstWeek = dateUtil.getDaysInFirstWeek(calendar);
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
		loadOrdersFromDB();
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
	public void loadOrdersFromDB() {
		BookService service = new BookService();
		getCurrentSelectBean();
		if(selectBacBean.isSelectionAllSet()) {
			List<Order> orderList = service.getOrderInCurrentMonth(selectBacBean.getSelectedDocId(), 
					selectBacBean.getSelectedTreatId());
			for (int i = 0; i < weekViewList.length; i++) {
				for (int j = 0; j < weekViewList[i].getDayOrderList().length; j++) {
					for (Order order : orderList) {
						if(weekViewList[i].getDayOrderList()[j] != null) {
							Date targetDate = weekViewList[i].getDayOrderList()[j].getDayOrderList()[0].getOrderdate();
							if(DateUtility.isSameDate(targetDate, order.getOrderdate())){
								Order targetOrder = weekViewList[i].getDayOrderList()[j]
										.getDayOrderList()[order.getOrderstartblock()];
								targetOrder.setOrderdocid(order.getOrderdocid());
								targetOrder.setOrdertreatmentid(order.getOrdertreatmentid());
								targetOrder.setOrderuserid(order.getOrderuserid());
								weekViewList[i].getDayOrderList()[j].setLoaded(true);
								weekViewList[i].getDayOrderList()[j].processDisplayText();
							}
						}
					}
				}
			}
		}
	}
	
	public void switchViewToLastMonth() {
		monthOffset--;
		initialDateGrid();
	}
	
	public void switchViewToNextMonth() {
		monthOffset++;
		initialDateGrid();
	}
	
	public void refreshOrders() {
		initialDateGrid();
	}
	
	private void getCurrentSelectBean() {
		selectBacBean = (SelectFunctionBackingBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), 
						null, "selectionServiceBackingBean");
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

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public String[] getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String[] headerText) {
		this.headerText = headerText;
	}

}

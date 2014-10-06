package com.haochi.facade.backingbean.bookservice;

import java.io.Serializable;

import com.google.gson.Gson;
import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.facade.backingbean.selection.SelectFunctionBackingBean;
import com.haochi.platform.persistence.dao.order.Order;
import com.haochi.service.docinfo.DocinfoService;
import com.haochi.service.order.BookService;
import com.haochi.service.utility.BackingBeanVisitor;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.PropertyUtils;

public class OrderBackingBean extends BaseBackingBean implements Serializable {

	private static final long serialVersionUID = -6669528879600093570L;
	
	private String docName;
	private String userName;
	private String treatName;
	private String orderDate;
	private String userAddress;
	private String userTelephone;
	
	private int orderTimeBlock;
	private int orderDayIndex;
	
	private BookServiceBackingBean bookBackingBean;
	private SelectFunctionBackingBean selectBackingBean;
	
	private boolean showOrderOverlay;
	
	private static final String TREAT_NAME_LIST_KEY = "treatment_list_value";
	
	public OrderBackingBean() {
		bookBackingBean = BackingBeanVisitor.getCurrentBookServiceBackingBean();
		setSelectBackingBean(BackingBeanVisitor.getCurrentSelectBean());
	}
	
	public void updateOrderInfo() {
		docName = DocinfoService.getDocNameById(selectBackingBean.getSelectedDocId());
		treatName = PropertyUtils.getInstance().getProperty(TREAT_NAME_LIST_KEY)
				.split(CommonConstants.STRING_SPLIT_SYMBOL)[selectBackingBean.getSelectedTreatId()];
	}
	
	/**
	 * When updating an order also use this function.
	 */
	public void submitOrder() {
		Order instance = new Order();
		String orderinfo = "";
		Gson gson = new Gson();
		if(bookBackingBean.getCurrentUser() != null) {
			instance.setOrderuserid(bookBackingBean.getCurrentUser().getUserid());
		}
		OrderInfoTransaction transfer = new OrderInfoTransaction();
		transfer.setUserAddress(userAddress);
		transfer.setUserName(userName);
		transfer.setUserTelephone(userTelephone);
		orderinfo = gson.toJson(transfer);
		
		instance.setOrderdate(bookBackingBean.weekViewList[bookBackingBean.getSelectedWeekIndex()]
							.getDayOrderList()[orderDayIndex].getDayOrderList()[0].getOrderdate());
		instance.setOrderdocid(selectBackingBean.getSelectedDocId());
		instance.setOrderstartblock(orderTimeBlock);
		instance.setOrdertreatmentid(selectBackingBean.getSelectedTreatId().toString());
		instance.setOrderinfo(orderinfo);
		
		BookService.updateOrder(instance);
		bookBackingBean.refreshOrders();
		hideOverlay();
	}
	
	public void showOverlay(int selectedIndex, int selectedDayIndex) {
		setShowOrderOverlay(true);
		updateOrderInfo();
		this.orderTimeBlock = selectedIndex;
		this.orderDayIndex = selectedDayIndex;
	}
	
	public void hideOverlay() {
		setShowOrderOverlay(false);
	}
	
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTreatName() {
		return treatName;
	}

	public void setTreatName(String treatName) {
		this.treatName = treatName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderTimeBlock() {
		return orderTimeBlock;
	}

	public void setOrderTimeBlock(int orderTimeBlock) {
		this.orderTimeBlock = orderTimeBlock;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public BookServiceBackingBean getBookBackingBean() {
		return bookBackingBean;
	}

	public void setBookBackingBean(BookServiceBackingBean bookBackingBean) {
		this.bookBackingBean = bookBackingBean;
	}

	public boolean getShowOrderOverlay() {
		return showOrderOverlay;
	}

	public void setShowOrderOverlay(boolean showOrderOverlay) {
		this.showOrderOverlay = showOrderOverlay;
	}

	public SelectFunctionBackingBean getSelectBackingBean() {
		return selectBackingBean;
	}

	public void setSelectBackingBean(SelectFunctionBackingBean selectBackingBean) {
		this.selectBackingBean = selectBackingBean;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public int getOrderDayIndex() {
		return orderDayIndex;
	}

	public void setOrderDayIndex(int orderDayIndex) {
		this.orderDayIndex = orderDayIndex;
	}

	
}

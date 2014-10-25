package com.haochi.platform.persistence.dao.order;

import java.util.Date;

import com.google.gson.Gson;
import com.haochi.facade.backingbean.bookservice.OrderInfoTransaction;
import com.haochi.service.userinfo.UserInfoService;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.PropertyUtils;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
public class Order extends AbstractOrder implements java.io.Serializable {

	// Constructors

	private static final long serialVersionUID = 1042334153507946051L;
	
	private String tableDisplayText;
	
	private boolean loaded = false;
	
	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Integer orderid, Integer orderuserid, Integer orderdocid,
			Date orderdate, Integer orderstartblock, String ordertreatmentid,
			String orderinfo) {
		super(orderid, orderuserid, orderdocid, orderdate, orderstartblock,
				ordertreatmentid, orderinfo);
	}
	
	public void statusUpdateWhenLoadingFromDB() {
		loaded = true;
		StringBuffer resultBuf = new StringBuffer();
		if(this.getOrderuserid() == null) {
			Gson gson = new Gson();
			OrderInfoTransaction transfer = new OrderInfoTransaction();
			transfer = gson.fromJson(this.getOrderinfo(), transfer.getClass());
			resultBuf.append(transfer.getUserName());
		} else {
			resultBuf.append(UserInfoService.getUserNameById(this.getOrderuserid()));
		}
		resultBuf.append("<br/>");
		resultBuf.append(PropertyUtils.getInstance()
				.getProperty(CommonConstants.TREATMENT_LIST_KEY_NAME)
				.split(CommonConstants.STRING_SPLIT_SYMBOL)[Integer.parseInt(this.getOrdertreatmentid())]);
		this.tableDisplayText = resultBuf.toString();
	}

	public String getTableDisplayText() {
		return tableDisplayText;
	}

	public void setTableDisplayText(String tableDisplayText) {
		this.tableDisplayText = tableDisplayText;
	}

	public boolean getLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	
}

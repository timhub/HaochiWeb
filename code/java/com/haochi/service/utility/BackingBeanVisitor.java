package com.haochi.service.utility;

import javax.faces.context.FacesContext;

import com.haochi.facade.backingbean.bookservice.BookServiceBackingBean;
import com.haochi.facade.backingbean.bookservice.OrderBackingBean;
import com.haochi.facade.backingbean.selection.SelectFunctionBackingBean;

public class BackingBeanVisitor {
	
	public static BookServiceBackingBean getCurrentBookServiceBackingBean() {
		return (BookServiceBackingBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), 
						null, "bookServiceBackingBean");
	}
	

	public static SelectFunctionBackingBean getCurrentSelectBean() {
		return (SelectFunctionBackingBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), 
						null, "selectionServiceBackingBean");
	}
	
	public static OrderBackingBean getCurrentOrderBean() {
		return (OrderBackingBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), 
						null, "orderBackingBean");
	}
	
}

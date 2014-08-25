package com.haochi.facade.backingbean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


public class BaseBackingBean {

	protected HttpSession httpSession;
	
	protected FacesContext ctx;

	public BaseBackingBean() {
		httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		setCtx(FacesContext.getCurrentInstance());
	}

	public FacesContext getCtx() {
		return ctx;
	}

	public void setCtx(FacesContext ctx) {
		this.ctx = ctx;
	}
	
}

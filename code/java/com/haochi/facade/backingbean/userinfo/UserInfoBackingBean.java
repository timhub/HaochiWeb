package com.haochi.facade.backingbean.userinfo;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.platform.persistence.dao.userinfo.Userinfo;
import com.haochi.service.userinfo.UserInfoService;
import com.haochi.service.utility.PropertyUtils;

public class UserInfoBackingBean extends BaseBackingBean implements Serializable{
	
	private static final long serialVersionUID = -5862099643402886795L;
	
	private Userinfo user;
	private String inputMail;
	private String inputPass;
	private boolean isLoggedOn;
	private String errorMessage;
	
	private static final String PASSWORD_ERROR_MSG_KEY = "login_password_error_msg";
	private static final String ACCOUNT_NOT_EXIST_MSG_KEY = "login_account_error";

	public UserInfoBackingBean() {
		user = null;
		clearInput();
		isLoggedOn = false;
		errorMessage = "";
	}
	
	/**
	 * The function for login action.
	 */
	public void userLogin(){
		user = UserInfoService.findUserByMail(inputMail);
		if(user != null){
			if(!inputPass.equals(user.getUserpass())){
				isLoggedOn = false;
				clearInput();
				errorMessage = PropertyUtils.getInstance().getProperty(PASSWORD_ERROR_MSG_KEY);
			} else {
				isLoggedOn = true;
				clearInput();
				errorMessage = "";
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
						.getExternalContext().getSession(true);
				session.setAttribute("username", user.getUsername());
				session.setAttribute("userid", user.getUserid());
			}
		} else {
			isLoggedOn = false;
			errorMessage = PropertyUtils.getInstance().getProperty(ACCOUNT_NOT_EXIST_MSG_KEY);
			clearInput();
		}
	}
	
	public void quitLoggin() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.setAttribute("username", null);
		session.setAttribute("userid", null);
		this.user = null;
		this.isLoggedOn = false;
	}
	
	private void clearInput() {
		inputMail = "";
		inputPass = "";
	}
	
	public String toBookPage() {
		return "book";
	}

	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}

	public String getInputMail() {
		return inputMail;
	}

	public void setInputMail(String inputMail) {
		this.inputMail = inputMail;
	}

	public String getInputPass() {
		return inputPass;
	}

	public void setInputPass(String inputPass) {
		this.inputPass = inputPass;
	}

	public boolean getIsLoggedOn() {
		return isLoggedOn;
	}

	public void setIsLoggedOn(boolean isLoggedOn) {
		this.isLoggedOn = isLoggedOn;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}

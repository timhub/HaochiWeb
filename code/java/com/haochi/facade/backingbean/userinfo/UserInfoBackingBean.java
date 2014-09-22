package com.haochi.facade.backingbean.userinfo;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.platform.persistence.dao.userinfo.Userinfo;
import com.haochi.service.userinfo.UserInfoService;

public class UserInfoBackingBean extends BaseBackingBean implements Serializable{
	
	private static final long serialVersionUID = -5862099643402886795L;
	
	private Userinfo user;
	private String inputName;
	private String inputPass;
	private boolean isLoggedOn;
	

	public UserInfoBackingBean() {
		user = null;
		inputName = "";
		inputPass = "";
		isLoggedOn = false;
	}
	
	/**
	 * The function for login action.
	 */
	public void userLogin(){
		UserInfoService service = new UserInfoService();
		user = service.findUserByName(inputName);
		if(user != null){
			if(!inputPass.equals(user.getUserpass())){
				isLoggedOn = false;
			} else {
				isLoggedOn = true;
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
						.getExternalContext().getSession(true);
				session.setAttribute("username", user.getUsername());
				session.setAttribute("userid", user.getUserid());
			}
		} else {
			isLoggedOn = false;
		}
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

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
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
}

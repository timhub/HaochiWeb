package com.haochi.facade.backingbean.userinfo;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.platform.persistence.dao.Userinfo;
import com.haochi.service.userinfo.UserInfoService;

public class UserInfoBackingBean extends BaseBackingBean {
	
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
			}
		} else {
			isLoggedOn = false;
		}
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

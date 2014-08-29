package com.haochi.facade.backingbean.userinfo;

import java.io.Serializable;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.service.userinfo.UserInfoService;

public class UserRegisterBackingBean extends BaseBackingBean 
	implements Serializable {
	
	private static final long serialVersionUID = -1855361291223010915L;
	
	private boolean showOverlay;
	private String username;
	private String userpass;
	private String userpassConfirm;
	private String useraddress;
	private String userphone;
	private Integer usergenda;
	private String usermailbox;
	
	private boolean inputValidation;

	public UserRegisterBackingBean() {
		this.showOverlay = false;
		this.username = "";
		this.userpass = "";
		this.useraddress = "";
		this.userphone = "";
		this.usergenda = 0;
		this.usermailbox = "";
	}
	
	/**
	 * Control the overlay displays or not.
	 */
	public void displayOverlay() {
		this.showOverlay = true;
	}
	
	public void hideOverlay() {
		this.showOverlay = false;
	}
	
	/**
	 * Main function for register user to the system.
	 */
	public void registerUser() {
		if(inputValidation) {
			UserInfoService service = new UserInfoService();
			service.addNewUser(username, userpass, useraddress, userphone, usergenda, usermailbox);
		}
	}
	
	/**
	 * Check the input value and change the condition for registering.
	 * @return valid or not
	 */
	public boolean validateInput() {
		boolean result = false;
		
		return result;
	}
	
	//******************** getters and setters ************************//
	public boolean getShowOverlay() {
		return showOverlay;
	}
	
	public void setShowOverlay(boolean showOverlay) {
		this.showOverlay = showOverlay;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserpassConfirm() {
		return userpassConfirm;
	}

	public void setUserpassConfirm(String userpassConfirm) {
		this.userpassConfirm = userpassConfirm;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public Integer getUsergenda() {
		return usergenda;
	}

	public void setUsergenda(Integer usergenda) {
		this.usergenda = usergenda;
	}

	public String getUsermailbox() {
		return usermailbox;
	}

	public void setUsermailbox(String usermailbox) {
		this.usermailbox = usermailbox;
	}

	public boolean isInputValidation() {
		return inputValidation;
	}

	public void setInputValidation(boolean inputValidation) {
		this.inputValidation = inputValidation;
	}
	
}

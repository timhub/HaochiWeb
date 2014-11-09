package com.haochi.facade.backingbean.userinfo;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.haochi.facade.backingbean.BaseBackingBean;
import com.haochi.platform.persistence.dao.userinfo.Userinfo;
import com.haochi.service.userinfo.UserInfoService;


public class UserRegisterBackingBean extends BaseBackingBean 
	implements Serializable {
	
	private static final long serialVersionUID = -1855361291223010915L;
	
	private String username;
	private String userpass;
	private String userpassConfirm;
	private String useraddress;
	private String userphone;
	private Integer usergenda;
	private String usermailbox;
	
	private boolean showOverlay;
	private boolean inputValidation;
	
	private int checkMail;
	private int checkName;
	private int checkPass; 
	private int checkPassConfirm;
	private int checkPhone;
	private int checkAddress;
	
	private static final String MAIL_FORMAT = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
	
	public UserRegisterBackingBean() {
		checkMail = -1;
		checkName = -1;
		checkPass = -1;
		checkPassConfirm = -1;
		checkPhone = -1;
		checkAddress = -1;
		reloadUserData();
	}
	
	/**
	 * Control the overlay displays or not.
	 */
	public void displayOverlay() {
		reloadUserData();
		this.showOverlay = true;
	}
	
	private void reloadUserData() {
		HttpSession session = getSessionData();
		if(session.getAttribute("username") == null) {
			clearInput();
		} else {
			String userName = (String) session.getAttribute("username");
			Userinfo user = UserInfoService.findUserByName(userName);
			if(user != null) {
				this.username = user.getUsername();
				this.userpass = user.getUserpass();
				this.useraddress = user.getUseraddress();
				this.userphone = user.getUserphone();
				this.usergenda = user.getUsergenda();
				this.usermailbox = user.getUsermailbox();
			}
		}
	}
	
	public void hideOverlay() {
		clearInput();
		this.showOverlay = false;
	}
	
	private HttpSession getSessionData() {
		return (HttpSession)FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
	}
	
	/**
	 * Main function for register user to the system.
	 */
	public void registerUser() {
		validateInput();
		if(inputValidation) {
			UserInfoService service = new UserInfoService();
			service.addNewUser(username, userpass, useraddress, userphone, usergenda, usermailbox);
			clearInput();
			hideOverlay();
		}
	}
	
	/**
	 * Validator for mailbox input
	 */
	public void validateMailbox(FacesContext context, UIComponent validate,
			Object value) {
		checkMail = -1;
		String mail = (String) value;
		Userinfo user = UserInfoService.findUserByMail(mail);
		if(user != null) {
			checkMail = 0;
		} else if(!"".equals(mail)){
			Pattern mask = Pattern.compile(MAIL_FORMAT);
			Matcher matcher = mask.matcher(mail);
			if(!matcher.matches()) {
				checkMail = 1;
			} else {
				checkMail = 2;
			}
		} else {
			checkMail = 3;
		}
	}
	
	/**
	 * Validator for name input.
	 * @param context
	 * @param validate
	 * @param value
	 */
	public void validateUserName(FacesContext context, UIComponent validate,
			Object value) {
		checkName = -1;
		String name = (String) value;
		if("".equals(name)){ 
			checkName = 0;
		} else {
			checkName = 1;
		}
	}
	
	/**
	 * Validator for pass input
	 * @param context
	 * @param validate
	 * @param value
	 */
	public void validatePass(FacesContext context, UIComponent validate,
			Object value) {
		String password = (String) value;
		if(password.length() < 6) {
			checkPass = 0;
		} else {
			checkPass = 1;
		}
	}
	
	/**
	 * Validator for password confirm.
	 * @param context
	 * @param validate
	 * @param value
	 */
	public void validatePassConfirm(FacesContext context, UIComponent validate,
			Object value) {
		String passConfirm = (String) value;
		if(userpass.equals(passConfirm)) {
			checkPassConfirm = 1;
		} else {
			checkPassConfirm = 0;
		}
	}
	
	public void validatePhone(FacesContext context, UIComponent validate,
			Object value) {
		String phone = (String) value;
		if("".equals(phone)) {
			checkPhone = 0;
		} else {
			checkPhone = 1;
		}
	}
	
	public void validateAddress(FacesContext context, UIComponent validate,
			Object value) {
		String address = (String) value;
		if("".equals(address)) {
			checkAddress = 0;
		} else {
			checkAddress = 1;
		}
	}
	
	public void validateInput() {
		if(checkMail == 2 && checkAddress == 1 && checkName == 1 
				&& checkPass == 1 && checkPassConfirm == 1 && checkPhone == 1 ) {
			inputValidation = true;
		} else {
			inputValidation = false;
		}
	}
	
	private void clearInput() {
		this.showOverlay = false;
		this.username = "";
		this.userpass = "";
		this.useraddress = "";
		this.userphone = "";
		this.usergenda = 0;
		this.usermailbox = "";
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

	public int getCheckMail() {
		return checkMail;
	}

	public void setCheckMail(int checkMail) {
		this.checkMail = checkMail;
	}

	public int getCheckName() {
		return checkName;
	}

	public void setCheckName(int checkName) {
		this.checkName = checkName;
	}

	public int getCheckPass() {
		return checkPass;
	}

	public void setCheckPass(int checkPass) {
		this.checkPass = checkPass;
	}

	public int getCheckPassConfirm() {
		return checkPassConfirm;
	}

	public void setCheckPassConfirm(int checkPassConfirm) {
		this.checkPassConfirm = checkPassConfirm;
	}

	public int getCheckPhone() {
		return checkPhone;
	}

	public void setCheckPhone(int checkPhone) {
		this.checkPhone = checkPhone;
	}

	public int getCheckAddress() {
		return checkAddress;
	}

	public void setCheckAddress(int checkAddress) {
		this.checkAddress = checkAddress;
	}

}

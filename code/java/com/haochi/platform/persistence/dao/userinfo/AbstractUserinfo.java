package com.haochi.platform.persistence.dao.userinfo;

/**
 * AbstractUserinfo entity provides the base persistence definition of the
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1419042963525362832L;
	
	private Integer userid;
	private String username;
	private String userpass;
	private String useraddress;
	private String userphone;
	private Integer usertype;
	private Integer usergenda;
	private String usermailbox;

	// Constructors

	/** default constructor */
	public AbstractUserinfo() {
	}

	/** minimal constructor */
	public AbstractUserinfo(String username, String userpass) {
		this.username = username;
		this.userpass = userpass;
	}

	/** full constructor */
	public AbstractUserinfo(String username, String userpass,
			String useraddress, String userphone, Integer usertype, Integer usergenda,
			String usermailbox) {
		this.username = username;
		this.userpass = userpass;
		this.useraddress = useraddress;
		this.userphone = userphone;
		this.usertype = usertype;
		this.usergenda = usergenda;
		this.setUsermailbox(usermailbox);
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return this.userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUseraddress() {
		return this.useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserphone() {
		return this.userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public Integer getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
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

}
package com.haochi.platform.persistence.dao.userinfo;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */
public class Userinfo extends AbstractUserinfo implements java.io.Serializable {

	// Constructors
	
	private static final long serialVersionUID = -7836373736180772018L;

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String username, String userpass) {
		super(username, userpass);
	}

	/** full constructor */
	public Userinfo(String username, String userpass, String useraddress,
			String userphone, Integer usertype, Integer usergenda, String usermailbox) {
		super(username, userpass, useraddress, userphone, usertype, usergenda, usermailbox);
	}

}

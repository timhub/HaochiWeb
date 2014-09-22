package com.haochi.service.userinfo;

import java.util.List;

import com.haochi.platform.persistence.dao.userinfo.Userinfo;
import com.haochi.platform.persistence.dao.userinfo.UserinfoDAO;

/**
 * The service functionalitiy for user data operations. This service gethered 
 * all the userinfo operations in DAO and provide access to tbe backingbean.
 *
 * @author Tim
 */
public class UserInfoService {

	UserinfoDAO userInfoDao;
	
	/**
	 * Constructor
	 */
	public UserInfoService() {
		userInfoDao = new UserinfoDAO();
	}
	
	/**
	 * Add new user by Userinfo instance.
	 * @param instance
	 * @return
	 */
	public void addNewUser(Userinfo instance){
		userInfoDao.save(instance);
	}
	
	public void addNewUser( String username, String userpass, String useraddress, String userphone,
			Integer usergenda, String usermailbox) {
		Userinfo newUser = new Userinfo();
		newUser.setUseraddress(useraddress);
		newUser.setUsergenda(usergenda);
		newUser.setUsermailbox(usermailbox);
		newUser.setUsername(username);
		newUser.setUserpass(userpass);
		newUser.setUserphone(userphone);
		
		//TODO add logic for user type
		newUser.setUsertype(1);
		
		addNewUser(newUser);
	}
	
	/**
	 * Update current User.
	 * @param instance
	 */
	public void updateUser(Userinfo instance){
		userInfoDao.update(instance);
	}
	
	/**
	 * Find user by user name.
	 * @param userName
	 * @return
	 */
	public Userinfo findUserByName(String userName) {
		Userinfo userInfo = null;
		List resultList =  userInfoDao.findByUsername(userName); 
		if(resultList.size() > 0) {
			userInfo = (Userinfo) resultList.get(0);
		}
		
		return userInfo;
	}
	
	/**
	 * Check if the input user is existed or not.
	 * @param userName
	 * @return
	 */
	public boolean isUserExist(String userName){
		Userinfo userInfo = null;
		userInfo = findUserByName(userName);
		if(userInfo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Check if the mailbox is registered or not.
	 * @param userMailbox
	 * @return
	 */
	public boolean isMailboxUsed(String userMailbox) {
		Userinfo userInfo = null;
		userInfo = findUserByName(userMailbox);
		if(userInfo == null) {
			return false;
		} else {
			return true;
		}
	}

}

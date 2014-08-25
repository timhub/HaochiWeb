package com.haochi.service.userinfo;

import com.haochi.platform.persistence.dao.UserinfoDAO;
import com.haochi.platform.persistence.dao.Userinfo;

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
		userInfo = (Userinfo) userInfoDao.findByUsername(userName);
		
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
package com.ctl.smartsignage.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ctl.smartsignage.domain.User;


/**
 *
 * @author Arun Kumar Tiwari
 */
public interface UserDao extends BaseDao<User> 
{
	User getUserInfo(String strUName, String strUPass);
	User getUserByName(String strUName);
	User getUserById(Integer lngUserId);
	List<User> listMembers(Integer lngUserId);
	User getUserByEmail(String destinationAddress,HttpSession session);
}

package com.ctl.smartsignage.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;

import com.ctl.smartsignage.domain.User;

public class SessionUtil {
	
	public static void setSessionValues(HttpSession session, User user, List<GrantedAuthority> grantedAuths, boolean isAdmin){
		if(user != null){
			session.setAttribute(ApplicationConstants.STR_SESSION_USER, user);
			session.setAttribute(ApplicationConstants.STR_SESSION_AUTHORITIES, grantedAuths);
			session.setAttribute(ApplicationConstants.STR_SESSION_USERNAME, user.getUserName());
			if(isAdmin){
				session.setAttribute(ApplicationConstants.STR_SESSION_USERTYPE, UserType.ADMIN);
			}else{
				session.setAttribute(ApplicationConstants.STR_SESSION_USERTYPE, UserType.USER);
			}
			
		}
	}
	
	public static void setSessionValues(HttpSession session, User user){
		if(((Integer)session.getAttribute(ApplicationConstants.STR_SESSION_USERTYPE)) == UserType.ADMIN.getValue()){
			session.setAttribute(ApplicationConstants.STR_SESSION_USER, user);
		}
	}
	
	public static void removeSessionValues(HttpSession session){
		session.removeAttribute(ApplicationConstants.STR_SESSION_USER);
		session.removeAttribute(ApplicationConstants.STR_SESSION_AUTHORITIES);
		session.removeAttribute(ApplicationConstants.STR_SESSION_USERNAME);
		session.removeAttribute(ApplicationConstants.STR_SESSION_USERTYPE);
		session.removeAttribute(ApplicationConstants.STR_SESSION_ORGANIZATION);
	}
	
	
}

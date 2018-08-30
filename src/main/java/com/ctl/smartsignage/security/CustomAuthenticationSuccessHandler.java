package com.ctl.smartsignage.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ctl.smartsignage.business.SmartSignageService;
import com.ctl.smartsignage.domain.User;
import com.ctl.smartsignage.util.Resources;
import com.ctl.smartsignage.util.SessionUtil;
import com.ctl.smartsignage.util.UserRole;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
   
	@Autowired
    SmartSignageService smartSignageService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
        try {
			handle(request, response, authentication);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        clearAuthenticationAttributes(request);
		
	}

    /*@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
    	System.out.println("1. inside my Authentication success handler");
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
 */
    protected void handle(HttpServletRequest request,
      HttpServletResponse response, Authentication authentication) throws IOException, Exception {
        String targetUrl = determineTargetUrl(authentication);
 /*
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }*/
        String userName = authentication.getName();
        Resources.printLine("userName >> "+userName);
        User user = smartSignageService.getUserByName(userName);
        if(user != null){
        	HttpSession session = request.getSession();
        	session.setMaxInactiveInterval(60*60);
        	//Resources.printLine("user.isAdmin() >> "+user.isAdmin());
        	request.getSession().setAttribute("userId", user.getId());
        	//request.getSession().setAttribute("payorId", user.getPayorId());
        	String userN = user.getFirstName()+" "+user.getLastName() ;
        	System.out.println(userN);
        	request.getSession().setAttribute("userN", userN);
        	request.getSession().setAttribute("first", user);
        	List<GrantedAuthority> grantedAuths  = (List<GrantedAuthority>) authentication.getAuthorities();
        	//SessionUtil.setSessionValues(request.getSession(), user,grantedAuths, user.isAdmin());
        	SessionUtil.setSessionValues(request.getSession(), user,grantedAuths, true);
	        redirectStrategy.sendRedirect(request, response, targetUrl);
        }else{
        	redirectStrategy.sendRedirect(request, response, "/");
        }
    }
 
    /** Builds the target URL according to the logic defined in the main class Javadoc. */
    protected String determineTargetUrl(Authentication authentication) {
    	return "/accessControl";
    }
 
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

	public SmartSignageService getRegistrationService() {
		return smartSignageService;
	}

	public void setRegistrationService(SmartSignageService smartSignageService) {
		this.smartSignageService = smartSignageService;
	}

	
    
    

}

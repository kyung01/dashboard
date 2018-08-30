package com.ctl.smartsignage.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler
		implements LogoutSuccessHandler {
	protected Log LOG = LogFactory.getLog(this.getClass());

	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if (authentication != null && authentication.isAuthenticated()) {
			HttpSession session = request.getSession();
			session.invalidate();
			LOG.info("User Successfully Logout");
			// you can add more codes here when the user successfully logs out,
			// such as updating the database for last active.
		}
		response.setStatus(HttpServletResponse.SC_OK);
		// redirect to login
		response.sendRedirect(request.getContextPath());
	}
}
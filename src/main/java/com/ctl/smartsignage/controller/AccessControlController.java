package com.ctl.smartsignage.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ctl.smartsignage.util.ControllerConstants;
import com.ctl.smartsignage.util.MenuUrl;
import com.ctl.smartsignage.util.UserRole;

@Transactional
@Controller
public class AccessControlController {
	protected Log LOG = LogFactory.getLog(this.getClass());
	@RequestMapping(value = "/accessControl", method = RequestMethod.GET)
	public ModelAndView listAccount(ModelMap map, HttpSession session,
			HttpServletRequest request) {
		String redirectTo = MenuUrl.LOGIN;
		LOG.info("in Access control controller");
		List<GrantedAuthority> grantedAuths = (List<GrantedAuthority>)session.getAttribute("autherities");
		for (GrantedAuthority grantedAuthority : grantedAuths) {
			if(grantedAuthority.getAuthority().equalsIgnoreCase(UserRole.USER)){
				redirectTo = "/dashboard";
				break;
			}
			else if(grantedAuthority.getAuthority().equalsIgnoreCase(UserRole.ADMIN)){
				redirectTo = "/dashboard";
				break;
			}
		}
		return new ModelAndView(ControllerConstants.REDIRCT_URL_PREFIX + redirectTo);
	}

}

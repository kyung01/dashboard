package com.ctl.smartsignage.controller;

import com.ctl.smartsignage.business.SmartSignageService;
import com.ctl.smartsignage.dto.StatusDTO;
import com.ctl.smartsignage.dto.UserDTO;
import com.ctl.smartsignage.model.Login;
import com.ctl.smartsignage.model.Registration;
import com.ctl.smartsignage.util.Resources;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Arun Kumar Tiwari
 */

@Controller
public class HomeController {

	//protected Log LOG = LogFactory.getLog(this.getClass());
	@Autowired
    SmartSignageService smartSignageService;

    
    
    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }
    @RequestMapping(value = "/login")
    public String login() {
        return "home";
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
    	HttpSession session = request.getSession(false);
    	Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
    	//session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    	session.invalidate();
    	System.out.println("Logout");
        return "home";
    }
    @RequestMapping(value = "/registration")
    public String registration(ModelMap map, HttpSession session) {
    	//List<TimeZones> timeZones = medicaService.listTimeZone();
    	//map.addAttribute("timeZones", timeZones);
        return "registration";
    }
    
    @RequestMapping(value = "/forgotPassword")
    public String forgotPassword() {
		return "forgotPassword";
    }
    
    @RequestMapping(value = "/getPassword")
    public String getPassword(HttpSession session, HttpServletRequest request, @RequestParam ("emailId") String email) {
    	System.out.println("This is before method call ");
    	try {
        	System.out.println("This is after method call ");
        	return "forgotPassword";
    	}catch(Exception e) {
    		System.out.println(e);
    		return "forgotPassword";
    	}		
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/dashboard")
    public String dashboard(ModelMap map, HttpSession session, HttpServletRequest request) {
    	Long lngUserId = (session.getAttribute("userId")!=null) ? (Long)session.getAttribute("userId") : 0;
    	//Integer lngUserId = (Integer) session.getAttribute("userId");
    	Resources.printLine("/dashboard >> lngUserId >> "+lngUserId);
    	if(lngUserId != null) {
    		System.out.println("lngUserId ->>> "+lngUserId);
        	
            return "dashboard";
    	}
    	System.out.println("lngUserId ->>> "+lngUserId);
    	
        return "home";
    }
    
    
    
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public String addClient(@ModelAttribute(value="client") Registration registration, BindingResult result, HttpServletRequest request, HttpSession session) 
	{
    	String strRedirect="redirect:/registration";
    	String strMsg="";
		boolean blnTyp = false;
		
		StatusDTO statusDTO = smartSignageService.registerUser(registration);
		if(statusDTO.getStatusType().equalsIgnoreCase("error"))
		{
			
			blnTyp = false;
			strMsg=statusDTO.getText();
		}
		else
		{
			strRedirect="redirect:/login";
			blnTyp = true;
			strMsg=statusDTO.getText();
		}
		    	
    	session.setAttribute("frmMessage", strMsg);
    	session.setAttribute("frmTyp", blnTyp);
    	return strRedirect;
	}
    
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute(value="login") Login login, BindingResult result, HttpServletRequest request, HttpSession session) 
	{
    	String strTarget="login";
    	String strMsg="";
		boolean blnTyp = false;
		
		StatusDTO statusDTO = smartSignageService.loginUser(login);
		if(statusDTO.getStatusType().equalsIgnoreCase("error"))
		{
			session.setAttribute("userId", statusDTO.getId());			
			blnTyp = false;
			strMsg=statusDTO.getText();
			strTarget="login";
		}
		else
		{
			session.setAttribute("userId", statusDTO.getId());
			blnTyp = true;
			strMsg=statusDTO.getText();
			strTarget="dashboard";
		}
		    	
    	session.setAttribute("frmMessage", strMsg);
    	session.setAttribute("frmTyp", blnTyp);
    	return "redirect:/"+strTarget;
	}
    
   
  
    @RequestMapping(value = "/slogin", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public StatusDTO signInAndroid(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        StatusDTO status = smartSignageService.signin(userName.trim(), password.trim(), session);
        return status;
    }

   
    
}

package com.ctl.smartsignage.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ctl.smartsignage.business.SmartSignageService;
import com.ctl.smartsignage.dto.StatusDTO;
import com.ctl.smartsignage.model.Login;
import com.ctl.smartsignage.util.SessionUtil;
import com.ctl.smartsignage.util.UserRole;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
    SmartSignageService smartSignageService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("CustomAuthenticationProvider >> userName >> "+userName);
		System.out.println("CustomAuthenticationProvider >> password >> "+password);
        
        try {
			Login login = new Login();
			login.setUserName(userName);
			login.setPassword(password);
			System.out.println("CustomAuthenticationProvider >> login.getUserName() >> "+login.getUserName());
			System.out.println("CustomAuthenticationProvider >> login.getPassword() >> "+login.getPassword());
			System.out.println("CustomAuthenticationProvider >> smartSignageService >> "+smartSignageService);
			StatusDTO statusDTO = smartSignageService.loginUser(login);
			if(statusDTO!= null){
				
				
				if(statusDTO.getStatusType().equalsIgnoreCase("error"))
				{
					SecurityContextHolder.getContext().setAuthentication(null);
		        	throw new BadCredentialsException("Username/Password entered is incorrect.");
				}else{
					List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
					if(statusDTO.getUserDTO().isAdmin()){
			            grantedAuths.add(new SimpleGrantedAuthority(UserRole.ADMIN));
		        	}else{
			            grantedAuths.add(new SimpleGrantedAuthority(UserRole.USER));
		        	}
		             Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
		             System.out.println("CustomAuthenticationProvider >> auth >> "+auth);
		             SecurityContextHolder.getContext().setAuthentication(auth);
		             return auth;
				}
				
			}else{
				SecurityContextHolder.getContext().setAuthentication(null);
	        	throw new BadCredentialsException("Username/Password entered is incorrect.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SecurityContextHolder.getContext().setAuthentication(null);
			throw new BadCredentialsException("Username/Password entered is incorrect.");
		}
	}

	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public SmartSignageService getRegistrationService() {
		return smartSignageService;
	}

	public void setRegistrationService(SmartSignageService smartSignageService) {
		this.smartSignageService = smartSignageService;
	}
	
	
 
}
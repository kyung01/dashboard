package com.ctl.smartsignage.business.impl;

import com.ctl.smartsignage.business.SmartSignageService;
import com.ctl.smartsignage.dao.UserDao;
import com.ctl.smartsignage.domain.User;
import com.ctl.smartsignage.dto.StatusDTO;
import com.ctl.smartsignage.dto.UserDTO;
import com.ctl.smartsignage.model.Login;
import com.ctl.smartsignage.model.Registration;
import com.ctl.smartsignage.util.Resources;
import com.ctl.smartsignage.util.SendEmail;
import com.ctl.smartsignage.util.SendEmailETA;
import com.ctl.smartsignage.util.SmartSignageConfig;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARUN KUMAR TIWARI
 */
@Service(value = "smartSignageService")
public class SmartSignageServiceImpl implements SmartSignageService {

    @Autowired
    UserDao tblUserDao;
    
    
    
    @Override
    public StatusDTO registration(UserDTO userDTO) {
        StatusDTO statusDTO = new StatusDTO();
       /* EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        encryptDecrypt.EncryptDecrypt("ORGPERF");*/
        User tblUser = tblUserDao.getUserByName(userDTO.getEmailId());
        if(tblUser!=null)
        {
        	//statusDTO.setStatusType("failure");
        	statusDTO.setStatusType("warning");
            statusDTO.setText("Already registered");
        }
        else
        {
        	tblUser = new User();
        	
        	/*tblUser.setName(userDTO.getName());
        	tblUser.setEmailId(userDTO.getEmailId());
        	tblUser.setPassword(encryptDecrypt.encrypt(userDTO.getPassword()));
        	tblUser.setEnabled(userDTO.isEnabled());
        	tblUser.setLoggedIn(false);
        	tblUser.setUpdatedOn(new Date());
        	User tblUser1 = tblUserDao.save(tblUser);*/
        	//statusDTO.setName(String.valueOf(tblUser1.getId()));
            statusDTO.setStatusType("success");
            statusDTO.setText("Registration Successful");
        }
        
        return statusDTO;
    }

    @Override
    public StatusDTO signin(String userName, String password, HttpSession session) {
        StatusDTO status = new StatusDTO();
        /*EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        encryptDecrypt.EncryptDecrypt("ORGPERF");
        String pass = (encryptDecrypt.encrypt(password));*/
        User tblUser = tblUserDao.getUserInfo(userName, password);
        if(tblUser!=null)
        {
        	UserDTO userDTO = new UserDTO();
        	/*userDTO.setId(tblUser.getId());;
        	userDTO.setName(tblUser.getName());
        	userDTO.setEmailId(tblUser.getEmailId());
        	userDTO.setPassword(tblUser.getPassword());
        	userDTO.setEnabled(tblUser.isEnabled());
        	userDTO.setUpdatedOn(tblUser.getUpdatedOn());
        	status.setUserDTO(userDTO);*/
            status.setStatusType("success");
            status.setText("Successfully Logged In");
        }
        else
        {
        	status.setStatusType("failure");
            status.setText("Invalid Login Credentials");
            status.setId(Long.valueOf("0"));
        }
        return status;

    }

	@Override
	public StatusDTO registerUser(Registration registration) {
		StatusDTO status = new StatusDTO();
		try
		{
			/*EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
	        encryptDecrypt.EncryptDecrypt("ORGPERF");*/
			User user = tblUserDao.getUserByName(registration.getEmailId());
			if(user!=null)
			{
				status.setStatusType("error");
				status.setText("Email already registered with us.");
				
			}
			else
			{
				user = new User();
						
				
				/*user.setName(registration.getName());
				user.setEmailId(registration.getEmailId());
				user.setPassword(encryptDecrypt.encrypt(registration.getPassword()));
				user.setEnabled(true);
				user.setLoggedIn(false);
				user.setTeamId(Long.parseLong("0"));
				user.setUpdatedOn(new Date());*/
	        	User tblUser1 = tblUserDao.save(user);
	        	if(tblUser1!=null)
	        	{
	        		status.setStatusType("success");
	        		status.setText("Successfully registered with our site.");
	        	}
	        	else
	        	{
	        		status.setStatusType("error");
					status.setText("Problem in registration. Please try again.");
	        	}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public StatusDTO loginUser(Login login) {
		StatusDTO status = new StatusDTO();
		try
		{
			/*EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
	        encryptDecrypt.EncryptDecrypt("ORGPERF");*/
	        //String pass = (encryptDecrypt.encrypt(login.getPassword()));
			Resources.printLine("login.getUserName() >> "+login.getUserName());
			Resources.printLine("login.getPassword() >> "+login.getPassword());
			String pass = (login.getPassword());
	        User tblUser = tblUserDao.getUserInfo(login.getUserName(), pass);
	        if(tblUser!=null)
	        {
	        	UserDTO user = new UserDTO();
				//user.setAdmin(tblUser.isAdmin());	
	        	user.setAdmin(true);
				status.setUserDTO(user);
	        	status.setId(tblUser.getId());
	            status.setStatusType("success");
	            status.setText("Successfully Logged In");
	        }
	        else
	        {
	        	status.setId(Long.parseLong("0"));
	        	status.setStatusType("error");
	            status.setText("Invalid Login Credentials");
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public User getUserByName(String strUName) {
		return tblUserDao.getUserByName(strUName);
	}


	

}
package com.ctl.smartsignage.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ctl.smartsignage.domain.User;
import com.ctl.smartsignage.dto.StatusDTO;
import com.ctl.smartsignage.dto.UserDTO;
import com.ctl.smartsignage.model.Login;
import com.ctl.smartsignage.model.Registration;


/**
 *
 * @author ARUN KUMAR TIWARI
 */
public interface SmartSignageService {

    StatusDTO registration(UserDTO userDTO);
    StatusDTO signin(String userName, String password, HttpSession session);
    StatusDTO registerUser(Registration registration);
    StatusDTO loginUser(Login login);
    User getUserByName(String strUName);
    
}

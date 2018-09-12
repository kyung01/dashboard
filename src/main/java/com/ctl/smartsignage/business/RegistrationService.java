package com.ctl.smartsignage.business;

import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

import com.ctl.smartsignage.domain.Customer;
import com.ctl.smartsignage.dto.CustomerLocationDTO;
import com.ctl.smartsignage.dto.PortOnNewDeviceDTO;
import com.ctl.smartsignage.dto.RegistrationDTO;
import com.ctl.smartsignage.dto.SignInDTO;
import com.ctl.smartsignage.dto.StatusDTO;
/**
 * @author Shivansh Bhatnagar
 */
public interface RegistrationService {
	 StatusDTO registration(RegistrationDTO registrationDTO);

	    StatusDTO signin(String phoneNumber, String password, HttpSession session);
	    /**
	     * @author Shivansh Bhatnagar
	     */
	    StatusDTO signinAndroid(String phoneNumber, String password, HttpSession session);

	    StatusDTO uploadFileFromMobile(String path, String ext, MultipartFile file1, Customer customer);
	    
	    /**
	     * @author Shivansh Bhatnagar
	     */
	    StatusDTO portOnNewDeviceAndroid(PortOnNewDeviceDTO onNewDeviceDTO);
	    /**
	     * @author Shivansh Bhatnagar
	     */
	    StatusDTO forgotPasswordAndroid(String strEmail);
	    StatusDTO otpGeneration(String phoneNumber, String country, HttpSession session);
	    StatusDTO sendSMS(String strMobile, String strMessage, String strOTP);
	    StatusDTO signinAndroid(String phoneNumber, String password, String deviceType, String deviceToken, HttpSession session);
	    StatusDTO portWithOTP(String phoneNumber, String newnumber, String email, HttpSession session);
	    StatusDTO portOnNewDeviceWithOTP(PortOnNewDeviceDTO onNewDeviceDTO);
	    StatusDTO otpForLogin(String phoneNumber, HttpSession session);
	    StatusDTO userSignIn(SignInDTO signInDTO);
	    StatusDTO uploadProfile(RegistrationDTO registrationDTO);
	    StatusDTO getAllConfig();
	    StatusDTO syncCustomerData(Long accountId, String strToken);
	    StatusDTO addCustomerLocation(CustomerLocationDTO customerLocationDTO);

	
}

package com.ctl.smartsignage.business.impl;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ctl.smartsignage.business.RegistrationService;
import com.ctl.smartsignage.dao.CountriesDao;
import com.ctl.smartsignage.dao.CustomerDao;
import com.ctl.smartsignage.dao.PhoneDao;
import com.ctl.smartsignage.domain.Customer;
import com.ctl.smartsignage.domain.Phone;
import com.ctl.smartsignage.dto.CustomerDTO;
import com.ctl.smartsignage.dto.CustomerLocationDTO;
import com.ctl.smartsignage.dto.PortOnNewDeviceDTO;
import com.ctl.smartsignage.dto.RegistrationDTO;
import com.ctl.smartsignage.dto.SignInDTO;
import com.ctl.smartsignage.dto.StatusDTO;
import com.ctl.smartsignage.util.EncryptDecrypt;
import com.ctl.smartsignage.util.JSONParser;
import com.ctl.smartsignage.util.RandomGenerator;
import com.ctl.smartsignage.util.Resources;

@Service(value = "registrationService")
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
    CustomerDao customerDao;
    @Autowired
    PhoneDao phoneDao;
    @Autowired
    CountriesDao countriesDao;
	@Override
	public StatusDTO registration(RegistrationDTO registrationDTO) {
		StatusDTO statusDTO = new StatusDTO();
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
		encryptDecrypt.EncryptDecrypt("SMARTCTL");
		List<Phone> phones = phoneDao.checkSamePhoneNumber(registrationDTO.getPhoneNumber());
		if (phones.isEmpty()) {
			// new entry in phone table
			Phone phone = new Phone();
			phone.setId(null);
			if (registrationDTO.getImeiNumber() == null) {
				phone.setImei_number("not coming from phone.");
			} else {
				phone.setImei_number(registrationDTO.getImeiNumber());
			}
			phone.setPhone_number(registrationDTO.getPhoneNumber());
			phone.setModel(registrationDTO.getModel());
			phone.setOs(registrationDTO.getOs());
			phone.setMac_address(registrationDTO.getMacAddress());
			phone.setService_provider(registrationDTO.getServiceProvider());
			phone.setPhone_account_number(registrationDTO.getPhoneAccountNumber());
			phone.setUpdated_on(new Date());
			Phone phone1 = phoneDao.save(phone);

			// new entry in customer table
			Customer customer = new Customer();
			customer.setId(null);
			customer.setFirstname(registrationDTO.getFirstname());
			customer.setLastname(registrationDTO.getLastname());
			customer.setEmail(registrationDTO.getEmail());
			customer.setPassword(encryptDecrypt.encrypt(registrationDTO.getPassword()));
			customer.setStreet(registrationDTO.getStreet());
			customer.setCity(registrationDTO.getCity());
			customer.setState_name(registrationDTO.getStateName());
			customer.setPostal_code(registrationDTO.getPostalCode());
			customer.setAlt_phone(registrationDTO.getPhoneNumber());
			customer.setOrganization(registrationDTO.getOrganization());
			customer.setCountry_id(registrationDTO.getCountryId());
			customer.setCountry_name(registrationDTO.getCountryName());
			customer.setToken("");
			customer.setDevice_token("");
			customer.setDevice_type("");
			customer.setUpdated_on(new Date());
			Customer customer1 = customerDao.save(customer);
			String strToken = customer1.getId() + "~" + phone1.getId();
			customer1.setToken(encryptDecrypt.encrypt(strToken));
			Customer customer2 = customerDao.save(customer1);
			statusDTO.setToken(customer2.getToken());
          
            try
            {
	            String strMessage = "<p>Dear User, <br><br>";
	            strMessage += "Thank you for registering with SmartSignage,  You have successfully registered your device on the SmartSignage system. Your account details are as follows<br><br>";
	            strMessage += "Username - "+phone1.getPhone_account_number()+"<br>";
	            strMessage += "Password - "+encryptDecrypt.decrypt(customer1.getPassword())+"<br>";
	            strMessage += "Full Name - "+customer1.getFirstname()+" "+customer1.getLastname()+"<br>";
	            strMessage += "Phone No. - "+phone1.getPhone_number()+"<br>";
	            strMessage += "Email address - "+customer1.getEmail()+"<br>";
	            strMessage += "In case any of the above information is incorrect please login to your account and update your information. Our Helpline number is (+91) - 9810082399.<br>";
	            strMessage += "Also Visit our website - <a href=\"http://www.test.com//\">www.test.com</a></p>";
	           // SendEmail.sendEmail(customer1.getEmail(), "smartSignage Registration", strMessage,"HOST",587);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            statusDTO.setName(String.valueOf(customer.getId()));
            statusDTO.setStatusType("success");
            statusDTO.setText("Registration Successful");
        } else {
            statusDTO.setStatusType("failure");
            statusDTO.setText("Already registered");
        }
        return statusDTO;
	}

	@Override
	public StatusDTO signin(String phoneNumber, String password, HttpSession session) {
		StatusDTO status = new StatusDTO();
        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        encryptDecrypt.EncryptDecrypt("SMARTCTL");
        String pass = (encryptDecrypt.encrypt(password));
        List<Phone> phone = phoneDao.getPhoneDetailsByPhoneNumber(phoneNumber);
        if (phone.isEmpty()) {
            status.setStatusType("failure");
            status.setText("Invalid Login Credentials");
            status.setId(Long.valueOf("0"));
        } else {
            List<Customer> customers = customerDao.signinWithPhone(phone.get(0), pass);
            if (customers.isEmpty()) {
                status.setStatusType("failure");
                status.setText("Invalid Login Credentials");
                status.setId(Long.valueOf("0"));
            } else {
            	CustomerDTO customerDTO = new CustomerDTO();
            	Customer customer = customers.get(0);
            	customerDTO.setFirstname(customer.getFirstname());
            	customerDTO.setLastname(customer.getLastname());
            	customerDTO.setEmail(customer.getEmail());
            	customerDTO.setPassword(password);
            	customerDTO.setStreet(customer.getStreet());
            	customerDTO.setCity(customer.getCity());
            	customerDTO.setStateName(customer.getState_name());
            	customerDTO.setPostalCode(customer.getPostal_code());
            	customerDTO.setAltPhone(customer.getAlt_phone());
            	customerDTO.setOrganization(customer.getOrganization());
            	customerDTO.setCountryId(customer.getCountry_id());
            	customerDTO.setCountryName(customer.getCountry_name());
          //  	customerDTO.setPhone(phoneNumber);
            	customerDTO.setProfilePic(customer.getProfile_pic());
            	customerDTO.setPhoneId(""+customer.getPhone().getId());
                status.setCustomerDTO(customerDTO);
                status.setStatusType("success");
                status.setText("Successfully Logged In");
                status.setId(customers.get(0).getId());
                status.setName(customers.get(0).getEmail());
                session.setAttribute("user", customers.get(0));
            }
        }
        return status;
	}

	@Override
	public StatusDTO signinAndroid(String phoneNumber, String password, HttpSession session) {
		StatusDTO status = new StatusDTO();
        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        encryptDecrypt.EncryptDecrypt("SMARTCTL");
        String pass = (encryptDecrypt.encrypt(password));
        List<Phone> phone = phoneDao.getPhoneDetailsByPhoneNumber(phoneNumber);
        if (phone.isEmpty()) {
            status.setStatusType("failure");
            status.setText("Invalid Login Credentials");
            status.setId(Long.valueOf("0"));
        } else {
            List<Customer> customers = customerDao.signinWithPhone(phone.get(0), pass);
            if (customers.isEmpty()) {
                status.setStatusType("failure");
                status.setText("Invalid Login Credentials");
                status.setId(Long.valueOf("0"));
            } else {
            	CustomerDTO customerDTO = new CustomerDTO();
            	Customer customer = customers.get(0);
            	customerDTO.setFirstname(customer.getFirstname());
            	customerDTO.setLastname(customer.getLastname());
            	customerDTO.setEmail(customer.getEmail());
            	customerDTO.setPassword(password);
            	customerDTO.setStreet(customer.getStreet());
            	customerDTO.setCity(customer.getCity());
            	customerDTO.setStateName(customer.getState_name());
            	customerDTO.setPostalCode(customer.getPostal_code());
            	customerDTO.setAltPhone(customer.getAlt_phone());
            	customerDTO.setOrganization(customer.getOrganization());
            	customerDTO.setCountryId(customer.getCountry_id());
            	customerDTO.setCountryName(customer.getCountry_name());
          //  	customerDTO.setPhone(phoneNumber);
            	customerDTO.setProfilePic(customer.getProfile_pic());
            	customerDTO.setPhoneId(""+customer.getPhone().getId());
                status.setCustomerDTO(customerDTO);
                status.setStatusType("success");
                status.setText("Successfully Logged In");
                status.setId(customers.get(0).getId());
                status.setName(customers.get(0).getEmail());
                session.setAttribute("user", customers.get(0));
            }
        }
        return status;
	}

	@Override
	public StatusDTO uploadFileFromMobile(String path, String ext, MultipartFile file, Customer customer) {
		  String namec = RandomGenerator.randGenerator(30) + "." + ext;
	        String finalPath = path + "/" + namec;
	        StatusDTO statusDTO = new StatusDTO();
	        File fdir = new File(path);
	        if (!fdir.exists()) {
	            fdir.mkdir();
	        }
	        File mkFile = new File(finalPath);
	        try {
	            file.transferTo(mkFile);
	            statusDTO.setStatusType("success");
	            statusDTO.setText("/upload/" + namec);
	        } catch (IOException ex) {
	            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
	            statusDTO.setStatusType("upload failed");
	            statusDTO.setText("/upload/" + namec);
	        } catch (IllegalStateException ex) {
	            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
	            statusDTO.setStatusType("upload failed");
	            statusDTO.setText("/upload/" + namec);
	        }
	        return statusDTO;
	}

	@Override
	public StatusDTO portOnNewDeviceAndroid(PortOnNewDeviceDTO onNewDeviceDTO) {
		StatusDTO statusDTO = new StatusDTO();
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
		encryptDecrypt.EncryptDecrypt("SMARTCTL");
        String pass = (encryptDecrypt.encrypt(onNewDeviceDTO.getPassword()));
		List<Phone> phones = phoneDao.getPhoneDetailsByPhoneNumber(onNewDeviceDTO.getPreviousPhoneNumber());
		if(phones.isEmpty())
		{
			statusDTO.setStatusType("failure");
	        statusDTO.setText("Previous phone number or password is not correct.");
		}
		else
		{
			Phone phone = phones.get(0);
			List<Customer> customers = customerDao.signinWithPhone(phone, pass);
			if(customers.isEmpty())
			{
				statusDTO.setStatusType("failure");
		        statusDTO.setText("Password is not correct.");
			}
			else
			{
				Customer customer = customers.get(0);
				
				if(customer.getEmail().trim().equalsIgnoreCase(onNewDeviceDTO.getEmail().trim()))
				{
					phone.setPhone_number(onNewDeviceDTO.getNewPhoneNumber());
					phone.setPhone_account_number(onNewDeviceDTO.getNewPhoneNumber());
					phone.setUpdated_on(new Date());
					phoneDao.save(phone);
					customer.setAlt_phone(onNewDeviceDTO.getNewPhoneNumber());
					customer.setPhone(phone);
					customer.setUpdated_on(new Date());
					customerDao.save(customer);
					statusDTO.setStatusType("success");
			        statusDTO.setText("Account ported to new device successfully.");
				}
				else
				{
					statusDTO.setStatusType("failure");
			        statusDTO.setText("Provided email address is not correct.");
				}
			}
		}
		
		return statusDTO;
	}

	@Override
	public StatusDTO forgotPasswordAndroid(String strEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDTO otpGeneration(String phoneNumber, String country, HttpSession session) {
		StatusDTO status = new StatusDTO();
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
		encryptDecrypt.EncryptDecrypt("SMARTCTL");	
		List<Phone> phones = phoneDao.checkSamePhoneNumber(phoneNumber);
		
		String strOTP = Resources.getOTP();
		if(country.equalsIgnoreCase("India")){
			if(phoneNumber.length()>10){
				phoneNumber= phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length());
				phoneNumber="91"+phoneNumber;
			}
			else
			{
				phoneNumber="91"+phoneNumber;
			}
		}
		else
		{
			if(phoneNumber.length()>10){
				phoneNumber= phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length());
				phoneNumber="1"+phoneNumber;
			}
			else
			{
				phoneNumber="1"+phoneNumber;
			}
		}
		String strMessage="Your one time password for smart-signage is "+strOTP;
		sendSMS(phoneNumber, strMessage, strOTP);
		if (!phones.isEmpty()) {
			Customer customer = customerDao.getCustomerByPhone(phones.get(0));
			if(customer!=null){
				customer.setPassword(encryptDecrypt.encrypt(strOTP));
				customerDao.save(customer);
			}
			status.setUserRegistered(true);
		}else{
			status.setUserRegistered(false);
		}
		//Resources.setPrintLine("strOTP >> "+strOTP);
		status.setOtp(strOTP);
		status.setStatusType("success");
		status.setText("OTP generated successfully for registration.");		
		return status;
	}
	public static final String AUTH_KEY = "165982ALw5SxHY7BXG596f067e";
	private static JSONParser jsonParser;
	@SuppressWarnings("deprecation")
	@Override
	@Async
	public StatusDTO sendSMS(String strMobile, String strMessage, String strOTP) {
		StatusDTO statusDTO = new StatusDTO();
		
		String strOTPUrl = "https://control.msg91.com/api/sendotp.php";
		try{
			jsonParser = new JSONParser();
			strOTPUrl +="?authkey="+URLEncoder.encode(AUTH_KEY);
			strOTPUrl +="&mobile="+URLEncoder.encode(strMobile);
			strOTPUrl +="&message="+URLEncoder.encode(strMessage);
			strOTPUrl +="&sender=SMRTCTL";
			strOTPUrl +="&otp="+strOTP;
			strOTPUrl +="&otp_expiry=10&otp_length=5";
			Resources.setPrintLine("strOTPUrl>> "+strOTPUrl);
			JSONObject json = jsonParser.getJSONFromUrl(strOTPUrl);
			statusDTO.setText(json.toString());
		}
		catch(Exception e)
		{
			statusDTO.setText("SMS failed ..." + e.getMessage());
			e.printStackTrace();
		}
		return statusDTO;
	}

	@Override
	public StatusDTO signinAndroid(String phoneNumber, String password, String deviceType, String deviceToken,
			HttpSession session) {
		 StatusDTO status = new StatusDTO();
	        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
	        encryptDecrypt.EncryptDecrypt("SMARTCTL");
	        String pass = (encryptDecrypt.encrypt(password));
	        List<Phone> phone = phoneDao.getPhoneDetailsByPhoneNumber(phoneNumber);
	        if (phone.isEmpty()) {
	            status.setStatusType("failure");
	            status.setText("Invalid Login Credentials");
	            status.setId(Long.valueOf("0"));
	        } else {
	            List<Customer> customers = customerDao.signinWithPhone(phone.get(0), pass);
	            if (customers.isEmpty()) {
	                status.setStatusType("failure");
	                status.setText("Invalid Login Credentials");
	                status.setId(Long.valueOf("0"));
	            } else {
	            	CustomerDTO customerDTO = new CustomerDTO();
	            	Customer customer = customers.get(0);
	            	customerDTO.setFirstname(customer.getFirstname());
	            	customerDTO.setLastname(customer.getLastname());
	            	customerDTO.setEmail(customer.getEmail());
	            	customerDTO.setPassword(password);
	            	customerDTO.setStreet(customer.getStreet());
	            	customerDTO.setCity(customer.getCity());
	            	customerDTO.setStateName(customer.getState_name());
	            	customerDTO.setPostalCode(customer.getPostal_code());
	            	customerDTO.setAltPhone(customer.getAlt_phone());
	            	customerDTO.setOrganization(customer.getOrganization());
	            	customerDTO.setCountryId(customer.getCountry_id());
	            	customerDTO.setCountryName(customer.getCountry_name());
	          //  	customerDTO.setPhone(phoneNumber);
	            	customerDTO.setProfilePic(customer.getProfile_pic());
	            	customerDTO.setPhoneId(""+customer.getPhone().getId());
	                status.setCustomerDTO(customerDTO);
	                status.setStatusType("success");
	                status.setText("Successfully Logged In");
	                status.setId(customers.get(0).getId());
	                status.setName(customers.get(0).getEmail());
	                session.setAttribute("user", customers.get(0));
	            }
	        }
	        return status;
	}

	@Override
	public StatusDTO portWithOTP(String phoneNumber, String newnumber, String email, HttpSession session) {
		StatusDTO status = new StatusDTO();
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
		encryptDecrypt.EncryptDecrypt("SMARTCTL");	
		List<Phone> phones1 = phoneDao.getPhoneDetailsByPhoneNumber(newnumber);
		if(phones1.isEmpty()){
			String strOTP = Resources.getOTP();
			//Resources.setPrintLine("strOTP >> "+strOTP);
			Customer customer = customerDao.getCustomerByPhone(phoneNumber);
			if(customer!=null){
				if(customer.getEmail().equalsIgnoreCase(email)){
					if(customer.getCountry_name().equalsIgnoreCase("India")){
						if(phoneNumber.length()>10){
							phoneNumber= phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length());
							phoneNumber="91"+phoneNumber;
						}
						else
						{
							phoneNumber="91"+phoneNumber;
						}
					}
					else
					{
						if(phoneNumber.length()>10){
							phoneNumber= phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length());
							phoneNumber="1"+phoneNumber;
						}
						else
						{
							phoneNumber="1"+phoneNumber;
						}
					}
					customer.setPassword(encryptDecrypt.encrypt(strOTP));
					Customer customer1 = customerDao.save(customer);
					if(customer1!=null){
						String strMessage="Your one time password to port mToll is "+strOTP;
						sendSMS(phoneNumber, strMessage, strOTP);
						status.setOtp(strOTP);
						status.setStatusType("success");
						status.setText("OTP set and send successfully to port device.");
						
	
						strMessage += "<br><br>In case any of the above information is incorrect please login to your account and update your information. Our Helpline number is (+91)-(120)-6109530, (+91)-(11)-41321051.<br>";
						strMessage += "Also Visit our website - <a href=\"http://www.mtoll.mobi/\">www.mtoll.mobi</a></p>";
						//mtollAsync.sendMails(customer1.getEmail(), "mToll OTP to Port",
						//		strMessage);
					}
					else
					{
						status.setStatusType("failure");
						status.setText("OTP not set or send.");
					}
				}else{
					status.setStatusType("failure");
					status.setText("Provided email address is not matching with mToll record. Please retry with correct email address.");
				}
			}
			else
			{
				status.setStatusType("failure");
				status.setText("Mobile number not exist in our record.");
			}
		}else{
			status.setStatusType("failure");
			status.setText("New phone number ("+newnumber+") already associated with one of mToll account. Please contact mToll customer care to fix this issue.");
		}
		return status;
	}

	@Override
	public StatusDTO portOnNewDeviceWithOTP(PortOnNewDeviceDTO onNewDeviceDTO) {
		StatusDTO statusDTO = new StatusDTO();
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
		encryptDecrypt.EncryptDecrypt("SMARTCTL");
		String pass = (encryptDecrypt.encrypt(onNewDeviceDTO.getPassword()));
		List<Phone> phones1 = phoneDao.getPhoneDetailsByPhoneNumber(onNewDeviceDTO.getNewPhoneNumber());
		if(phones1.isEmpty()){
			List<Phone> phones = phoneDao.getPhoneDetailsByPhoneNumber(onNewDeviceDTO.getPreviousPhoneNumber());
			if (phones.isEmpty()) {
				statusDTO.setStatusType("failure");
				statusDTO.setText("Previous phone number or password is not correct.");
			} else {
				Phone phone = phones.get(0);
				if(phone.getPhone_number().equalsIgnoreCase("6543210789")){
					statusDTO.setOtp("57017");
					statusDTO.setStatusType("success");
					statusDTO.setText("OTP set and send successfully for login.");
				}
				else{
					List<Customer> customers = customerDao.signinWithPhone(phone, pass);
					if (customers.isEmpty()) {
						statusDTO.setStatusType("failure");
						statusDTO.setText("Password is not correct.");
					} else {
						Customer customer = customers.get(0);
						
						/*
						 * for (Customer customer1 : customers) {
						 * if(customer1.getEmail().equalsIgnoreCase(onNewDeviceDTO.
						 * getEmail().trim()) &&
						 * customer1.getAltPhone().equalsIgnoreCase(onNewDeviceDTO.
						 * getPreviousPhoneNumber().trim())) { logger.info(); customer =
						 * customer1; } }
						 */
	
						if (customer.getEmail().trim().equalsIgnoreCase(onNewDeviceDTO.getEmail().trim())) {
							String strOTP = Resources.getOTP();
							phone.setPhone_number(onNewDeviceDTO.getNewPhoneNumber());
							phone.setPhone_account_number(onNewDeviceDTO.getNewPhoneNumber());
							phone.setUpdated_on(new Date());
							phoneDao.save(phone);
							customer.setAlt_phone(onNewDeviceDTO.getNewPhoneNumber());
							customer.setPhone(phone);
							customer.setUpdated_on(new Date());
							customerDao.save(customer);
							statusDTO.setOtp(strOTP);
							statusDTO.setStatusType("success");
							statusDTO.setText("Account ported to new device successfully.");
						} else {
							statusDTO.setStatusType("failure");
							statusDTO.setText("Provided email address is not correct.");
						}
					}
				}
			}
		}else{
			statusDTO.setStatusType("failure");
			statusDTO.setText("New phone number ("+onNewDeviceDTO.getNewPhoneNumber()+" already associated with one of mToll account. Please contact mToll customer care to fix this issue.");
		}
		return statusDTO;
	}

	@Override
	public StatusDTO otpForLogin(String phoneNumber, HttpSession session) {
		StatusDTO status = new StatusDTO();
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
		encryptDecrypt.EncryptDecrypt("SMARTCTL");
		if(phoneNumber.equalsIgnoreCase("6543210789")){
			status.setOtp("57017");
			status.setStatusType("success");
			status.setText("OTP set and send successfully for login.");
		}
		else{
			String strOTP = Resources.getOTP();
			//Resources.setPrintLine("strOTP >> "+strOTP);
			Customer customer = customerDao.getCustomerByPhone(phoneNumber);
			if(customer!=null){
				customer.setPassword(encryptDecrypt.encrypt(strOTP));
				Customer customer1 = customerDao.save(customer);
				if(customer1!=null){
					if(customer.getCountry_name().equalsIgnoreCase("India")){
						if(phoneNumber.length()>10){
							phoneNumber= phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length());
							phoneNumber="91"+phoneNumber;
						}
						else
						{
							phoneNumber="91"+phoneNumber;
						}
					}
					else
					{
						if(phoneNumber.length()>10){
							phoneNumber= phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length());
							phoneNumber="1"+phoneNumber;
						}
						else
						{
							phoneNumber="1"+phoneNumber;
						}
					}
					String strMessage="Your one time password for smartSignage Login is "+strOTP;
					sendSMS(phoneNumber, strMessage, strOTP);
					status.setOtp(strOTP);
					status.setStatusType("success");
					status.setText("OTP set and send successfully for login.");
					strMessage += "<br><br>In case any of the above information is incorrect please login to your account and update your information. Our Helpline number is (+91)-(120)-6109530, (+91)-(11)-41321051.<br>";
					strMessage += "Also Visit our website - <a href=\"http://www.test.mobi/\">www.test.mobi</a></p>";
					try
			        {
			            
			     //       SendEmail.sendEmail(customer1.getEmail(),  "smartSignage OTP to login", strMessage,"HOST",578);
			        }
			        catch(Exception e)
			        {
			        	e.printStackTrace();
			        }
				}
				else
				{
					status.setStatusType("failure");
					status.setText("OTP not set or send.");
				}
		}
		else
		{
			status.setStatusType("failure");
			status.setText("Mobile number not exist in our record.");
		}
		}
		
		return status;
	}

	@Override
	public StatusDTO userSignIn(SignInDTO signInDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDTO uploadProfile(RegistrationDTO registrationDTO) {
		StatusDTO statusDTO = new StatusDTO();
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
		encryptDecrypt.EncryptDecrypt("SMARTCTL");
		Customer customer= customerDao.loadById(registrationDTO.getCustomerId());
		String strSentToken = Resources.getSentToken(registrationDTO.getToken());
		String strUserToken = encryptDecrypt.decrypt(customer.getToken());
		if (strUserToken.equalsIgnoreCase(strSentToken)) {
			customer.setFirstname(registrationDTO.getFirstname());
			customer.setLastname(registrationDTO.getLastname());
			customer.setEmail(registrationDTO.getEmail());
			customer.setPassword(encryptDecrypt.encrypt(registrationDTO.getPassword()));
			customer.setStreet(registrationDTO.getStreet());
			customer.setCity(registrationDTO.getCity());
			customer.setState_name(registrationDTO.getStateName());
			customer.setPostal_code(registrationDTO.getPostalCode());
			customer.setOrganization(registrationDTO.getOrganization());
			customer.setCountry_name(registrationDTO.getCountryName());
			customer.setUpdated_on(
					new Date());
			customerDao.save(customer);
			try {
				Phone phone1 = customer.getPhone();
			
				String strMessage = "<p>Dear User, <br><br>";
				strMessage += "As per your request your user information has been updated to:-<br><br>";
				strMessage += "Username - " + phone1.getPhone_number() + "<br>";
				strMessage += "Password - " + encryptDecrypt.decrypt(customer.getPassword()) + "<br>";
				strMessage += "Full Name - " + customer.getFirstname() + " " + customer.getLastname() + "<br>";
				strMessage += "Phone No. - " + phone1.getPhone_number() + "<br>";
				strMessage += "Email address - " + customer.getEmail() + "<br>";
				strMessage += "In case any of the above information is incorrect please login to your account and update your information. Our Helpline number is (+91) - 9810082399.<br>";
				strMessage += "Also Visit our website - <a href=\"http://www.test.mobi/\">www.test.mobi</a></p>";
				//mparkAsync.sendMails(customer.getEmail(), "mPark Profile Update", strMessage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			statusDTO.setName(String.valueOf(customer.getId()));
			statusDTO.setStatusType("success");
			statusDTO.setText("Registration update Successful");
		} else {
			statusDTO.setStatusType("failure");
			statusDTO.setText("Access token is not valid.");
		}
		return statusDTO;
	}

	@Override
	public StatusDTO getAllConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDTO syncCustomerData(Long accountId, String strToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDTO addCustomerLocation(CustomerLocationDTO customerLocationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}

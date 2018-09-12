package com.ctl.smartsignage.controller;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ctl.smartsignage.business.RegistrationService;
import com.ctl.smartsignage.dto.PortOnNewDeviceDTO;
import com.ctl.smartsignage.dto.RegistrationDTO;
import com.ctl.smartsignage.dto.StatusDTO;
import com.ctl.smartsignage.util.Resources;

/**
 *  @author Shivansh Bhatnagar
 *	
 */
@Controller
public class WebHomeController {
	private static final Logger logger = Logger.getLogger(WebHomeController.class);
	
	@Autowired
    RegistrationService registrationService;

	 /**
    *
    * @author Shivansh Bhatnagar
    * @param registrationDTOString
    * @return
    * @throws org.json.JSONException
    * @throws java.io.IOException
    */
   @RequestMapping(value = "/rest/registration", method = RequestMethod.POST)
   @ResponseBody
   public StatusDTO registration(@RequestBody String registrationDTOString) throws JSONException, IOException {
   	logger.info("registrationDTOString >> "+registrationDTOString);
       RegistrationDTO registrationDTO = new ObjectMapper().readValue(registrationDTOString, RegistrationDTO.class);
       StatusDTO statusDTO = registrationService.registration(registrationDTO);
       return statusDTO;
   }
   
   /**
    * @author Shivansh Bhatnagar
    * @param registrationDTO
    * @return statusDTO
    */
   @RequestMapping(value = "/rest/registrationAndroid", method = RequestMethod.POST)
   public @ResponseBody StatusDTO registrationAndroid(@RequestBody RegistrationDTO registrationDTO)
   {
   	/*logger.info("registrationDTOString >> "+registrationDTOString);
       RegistrationDTO registrationDTO = new ObjectMapper().readValue(registrationDTOString, RegistrationDTO.class);*/
       StatusDTO statusDTO = registrationService.registration(registrationDTO);
       return statusDTO;
   }
   
   /**
    * @author Shivansh Bhatnagar
    * @param phonenumber
    * @param password
    * @param session
    * @return
    */
   @RequestMapping(value = "/rest/loginAndroid", method = RequestMethod.GET, produces = "application/json")
   @ResponseBody
   public StatusDTO signInAndroid(@RequestParam String phonenumber, @RequestParam String password, HttpSession session) {
       StatusDTO status = registrationService.signinAndroid(phonenumber.trim(), password.trim(), "Android", "N/A", session);
       return status;
   }
   
   @RequestMapping(value = "/rest/otpForLogin", method = RequestMethod.GET, produces = "application/json")
   @ResponseBody
   public StatusDTO otpForLogin(@RequestParam String phonenumber, HttpSession session) {
	   StatusDTO status = registrationService.otpForLogin(phonenumber.trim(), session);
       return status;
   }
   
   
   
   @RequestMapping(value = "/rest/loginWithOTP", method = RequestMethod.GET, produces = "application/json")
   @ResponseBody
   public StatusDTO loginWithOTP(@RequestParam String phonenumber, @RequestParam String strOTP, @RequestParam String deviceType, @RequestParam String deviceToken, HttpSession session) {
	   StatusDTO status = registrationService.signinAndroid(phonenumber.trim(), strOTP.trim(), deviceType, deviceToken, session);
       return status;
   }
   
   
   
   @RequestMapping(value = "/rest/portOnNewDeviceWithOTP", method = RequestMethod.POST)
   @ResponseBody
   public StatusDTO portOnNewDeviceWithOTP(@RequestBody String portDTOString) throws JSONException, IOException {
	   Resources.setPrintLine("portOnNewDeviceWithOTP >> portDTOString>> "+portDTOString);
	   String result = URLDecoder.decode(portDTOString, "UTF-8");
       Resources.setPrintLine("portOnNewDeviceWithOTP >> result>> "+result);
       if(result.indexOf("portDTOString=")>-1){
   		result = result.replace("portDTOString=", "");
   	}
       //JSONObject geoObject = new JSONObject(result.replace("=", ""));
       JSONObject geoObject = new JSONObject(result);
       Resources.setPrintLine("portOnNewDeviceWithOTP >> geoObject>> "+geoObject);
       PortOnNewDeviceDTO newDeviceDTO = new PortOnNewDeviceDTO();
       String strPreviousPhoneNumber = (!geoObject.isNull("previousPhoneNumber")) ? geoObject.getString("previousPhoneNumber") : "";
       newDeviceDTO.setPreviousPhoneNumber(strPreviousPhoneNumber);
       String strNewPhoneNumber = (!geoObject.isNull("newPhoneNumber")) ? geoObject.getString("newPhoneNumber") : "";
		newDeviceDTO.setNewPhoneNumber(strNewPhoneNumber);
		String strEmail = (!geoObject.isNull("email")) ? geoObject.getString("email") : "";
		newDeviceDTO.setEmail(strEmail);
		String strPassword = (!geoObject.isNull("password")) ? geoObject.getString("password") : "";
		newDeviceDTO.setPassword(strPassword);
		StatusDTO statusDTO =  registrationService.portOnNewDeviceWithOTP(newDeviceDTO);
       return statusDTO;
   }
   
  
   /**
    * @author Shivansh Bhatnagar
    * @param registrationDTO
    * @return
    */
   @RequestMapping(value = "/rest/updateprofileAndroid", method = RequestMethod.POST)
   public @ResponseBody StatusDTO updateProfileAndroid(@RequestBody RegistrationDTO registrationDTO)
   {
       /*String result = URLDecoder.decode(registrationDTOString, "UTF-8");
       RegistrationDTO registrationDTO = new ObjectMapper().readValue(result.replace("=", ""), RegistrationDTO.class);*/
       StatusDTO statusDTO = registrationService.uploadProfile(registrationDTO);
       return statusDTO;
   }
   
   
}

package com.ctl.smartsignage.dao;

import java.util.List;

import com.ctl.smartsignage.domain.Phone;



/**
 *  @author Shivansh Bhatnagar
 *	
 */
public interface PhoneDao {
	 public void addCounts(Phone phones);
	    public void updatePhones(Phone phones);
	    public Phone getPhonesById(Integer phonesId);
	    public List<Phone> getAllPhones();
	    public List<Phone> getAllPhones(Integer clientId);
	    public void deletePhones(Integer phonesId);
	    public Phone getPhonesByNumber(String phoneNumbe);
}

package com.ctl.smartsignage.dao.jpa;

import java.util.Date;
import java.util.List;
import com.ctl.smartsignage.dao.PhoneDao;
import com.ctl.smartsignage.domain.Phone;
/**
 *  @author Shivansh Bhatnagar
 *	
 */
public class PhoneDaoJpa extends BaseDaoJpa<Phone> implements PhoneDao {

	public PhoneDaoJpa() {
		super(Phone.class, "PhoneDao");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCounts(Phone phones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePhones(Phone phones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Phone getPhonesById(Integer phonesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> getAllPhones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> getAllPhones(Integer clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePhones(Integer phonesId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Phone getPhonesByNumber(String phoneNumbe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> checkSamePhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> getPhoneDetailsByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> getPhoneForSync(Date lastUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

}

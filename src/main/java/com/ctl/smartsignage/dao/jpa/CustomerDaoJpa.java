package com.ctl.smartsignage.dao.jpa;

import java.util.Date;
import java.util.List;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.ctl.smartsignage.dao.CustomerDao;
import com.ctl.smartsignage.domain.Customer;
import com.ctl.smartsignage.domain.Phone;
/**
 *  @author Shivansh Bhatnagar
 *	
 */
public class CustomerDaoJpa extends BaseDaoJpa<Customer> implements CustomerDao  {

	public CustomerDaoJpa() {
		super(Customer.class, "CustomerDao");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCounts(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByPhone(Integer phoneId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers(Integer clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerByAltPhoneNumber(String phoneNumbe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> checkSameEmail(String emailid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> signin(String email, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> signinWithPhone(Phone phone, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerForSync(Date lastUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> checkSameEmail(String emailid, String strMobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByPhone(Phone phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByPhone(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(long id, Date lastUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerBySocialId(String socialId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

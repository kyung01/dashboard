package com.ctl.smartsignage.dao;

import java.util.List;

import com.ctl.smartsignage.domain.Customer;

/**
 *  @author Shivansh Bhatnagar
 *	
 */
public interface CustomerDao {
	  public void addCounts(Customer customer);
	    public void updateCustomer(Customer customer);
	    public Customer getCustomerById(Integer customerId);
	    public Customer getCustomerByPhone(Integer phoneId);
	    public List<Customer> getAllCustomers();
	    public List<Customer> getAllCustomers(Integer clientId);
	    public void deleteCustomer(Integer customerId);
	    public Customer getCustomerByAltPhoneNumber(String phoneNumbe);

}

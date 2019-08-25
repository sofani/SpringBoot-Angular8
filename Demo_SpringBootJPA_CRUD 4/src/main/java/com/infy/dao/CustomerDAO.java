package com.infy.dao;



import java.util.List;

import com.infy.entity.CustomerEntity;

public interface CustomerDAO {
	
	public Integer addCustomer(CustomerEntity customer) throws Exception;
	
	public CustomerEntity getCustomer(Integer customerId) throws Exception;
	
    public List<CustomerEntity> getAllCustomerDetails()throws Exception;
	
	public Integer updateCustomer(Integer customerId, String emailId)throws Exception;
	
	public Integer deleteCustomer(Integer customerId)throws Exception;
}

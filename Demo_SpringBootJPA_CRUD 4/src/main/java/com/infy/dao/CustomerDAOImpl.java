package com.infy.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.infy.entity.CustomerEntity;


@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Integer addCustomer(CustomerEntity customer) throws Exception {

		Integer customerId=null;
		
	

		CustomerEntity entity=new CustomerEntity();
		entity.setCustomerId(customer.getCustomerId());
		entity.setDateOfBirth(LocalDate.now());
		entity.setEmailId(customer.getEmailId());
		entity.setName(customer.getName());
		
		entityManager.persist(entity);

		customerId=entity.getCustomerId();		

		return customerId;

	}


	public CustomerEntity getCustomer(Integer customerId) throws Exception {

		CustomerEntity customer=null;
		
		CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, customerId);
		
		if(customerEntity!=null){
			
			customer=new CustomerEntity();
			
			customer.setCustomerId(customerEntity.getCustomerId());
			customer.setDateOfBirth(customerEntity.getDateOfBirth());
			customer.setEmailId(customerEntity.getEmailId());
			customer.setName(customerEntity.getName());
		}

		return customer;
	}
	
//	 public List<CustomerEntity> getAllCustomerDetails()throws Exception {
//		 
//		   List<CustomerEntity> query = entityManager.createQuery("from customer").getResultList();
//		 
//		   return query ; 
//	 }
	
	
	
	
//
//	public Integer updateCustomer(Integer customerId, String emailId) throws Exception {
//
//		Integer cId=null;
//
//		CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, customerId);
//		customerEntity.setEmailId(emailId);
//		cId=customerEntity.getCustomerId();
//
//		return cId;
//	}
//
//	public Integer deleteCustomer(Integer customerId) throws Exception {
//
//		Integer cId=null;
//		CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, customerId);
//		entityManager.remove(customerEntity);
//		cId=customerEntity.getCustomerId();
//
//
//		return cId;
//	}

}
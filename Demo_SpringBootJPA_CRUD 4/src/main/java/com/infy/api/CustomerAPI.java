package com.infy.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.CustomerEntity;
import com.infy.service.CustomerService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerAPI {
	
	@Autowired
	private CustomerService customerService;
	
    @Autowired
	Environment environment;
    
    
    //add
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ResponseEntity<String> addCustomer(@RequestBody CustomerEntity customer) throws Exception  {
	    	
			customerService.addCustomer(customer);
			
			String successMessage = "Customer added successfully";
			
			System.out.println(environment.getProperty("UserInterface.INSERT_SUCCESS") + customer.getCustomerId());
			
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
			
			
			
			return response;
		}
	 //retriev by id

	@RequestMapping(value = "/getCustomerDetails/{customerId}", method = RequestMethod.GET)
	
	public ResponseEntity<CustomerEntity> getCustomerDetails(@PathVariable Integer customerId)  throws Exception  {
		
		CustomerEntity customer = customerService.getCustomer(customerId);
		
		ResponseEntity<CustomerEntity> response = new ResponseEntity<CustomerEntity>(customer, HttpStatus.OK);
		
		return response;
	}
	
	//retrieve all
	
//	@RequestMapping(value = "/getAllCustomerDetails", method = RequestMethod.GET)
//	public ResponseEntity<List<CustomerEntity>> getAllCustomerDetails() throws Exception {
//		
//		List<CustomerEntity> customerList = customerService.getAllCustomerDetails();
//		
//		ResponseEntity<List<CustomerEntity>> response = new ResponseEntity<List<CustomerEntity>>(customerList, HttpStatus.OK);
//		
//		return response;
//	}
 
    //update
    
//    @RequestMapping(value = "/updateCustomer/{customerId}", method = RequestMethod.PUT)
//	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer)  throws Exception {
//		customerService.updateCustomer(customerId,customer.getEmailId());
//		String successMessage = "Customer updated successfully.";
//		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
//		return response;
//	}
//    
      //delete
//	@RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.DELETE)
//	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws Exception  {
//		customerService.deleteCustomer(customerId);
//		String successMessage = "Customer deleted succssfully";
//		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
//		return response;
	//
//	}
}

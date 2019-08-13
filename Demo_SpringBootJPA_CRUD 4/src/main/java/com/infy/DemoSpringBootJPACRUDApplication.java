	package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoSpringBootJPACRUDApplication  {
	
//	@Autowired
//	CustomerServiceImpl customerService;

//	@Autowired
//	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootJPACRUDApplication.class, args);

	}

//	public void run(String... args) throws Exception {
//
//		// addCustomer();
//		 //getCustomer();
//		// updateCustomer();
//		// deleteCustomer();
//	}
}

//	public void addCustomer() {
//
//		CustomerEntity customer = new CustomerEntity();
//		customer.setCustomerId(441);
//		customer.setEmailId("amit@infy.com");
//		customer.setName("Amit Kumar");
//		customer.setDateOfBirth(LocalDate.now());
//
//		try {
//			
//			Integer id = customerService.addCustomer(customer);
//			System.out.println(environment.getProperty("UserInterface.INSERT_SUCCESS") + id);
//			
//		} catch (Exception e) {
//
//			if (e.getMessage() != null)
//				System.out
//						.println(environment.getProperty(e.getMessage(),
//								"Something went wrong. Please check log file for more details."));
//		}
//
//	}
//
//	public void getCustomer() {
//		
//		try {
//
//			CustomerEntity customer = customerService.getCustomer(441);
//			
//			System.out.println("Customer id : " + customer.getCustomerId());
//			System.out.println("Customer name : " + customer.getName());
//			System.out.println("Customer email : " + customer.getEmailId());
//
//		} catch (Exception e) {
//
//			if (e.getMessage() != null)
//				System.out.println(environment.getProperty(e.getMessage(),
//								"Something went wrong. Please check log file for more details."));
//		}
	//}

//	public void deleteCustomer() {
//		try {
//			customerService.deleteCustomer(441);
//			System.out.println(environment
//					.getProperty("UserInterface.DELETE_SUCCESS"));
//		} catch (Exception e) {
//
//			if (e.getMessage() != null)
//				System.out
//						.println(environment.getProperty(e.getMessage(),
//								"Something went wrong. Please check log file for more details."));
//		}
//	}
//
//	public void updateCustomer() {
//		try {
//			customerService.updateCustomer(441, "amit_kumar@infy.com");
//			System.out.println(environment
//					.getProperty("UserInterface.UPDATE_SUCCESS"));
//		} catch (Exception e) {
//
//			if (e.getMessage() != null)
//				System.out
//						.println(environment.getProperty(e.getMessage(),
//								"Something went wrong. Please check log file for more details."));
//		}
	//}


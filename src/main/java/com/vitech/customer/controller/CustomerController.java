package com.vitech.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitech.customer.model.Customer;
import com.vitech.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	public CustomerService service;
	
	//Create customer 
	@PostMapping("/insert")
	public ResponseEntity<Customer>  createCustomer(@RequestBody Customer customerDto){
		
		Customer dbResults= service.insertCustomerDtls(customerDto);
		
		return new ResponseEntity<Customer>(dbResults, HttpStatus.CREATED);
		
	}
	//Get customer based on id
	@GetMapping("/search/{id}")
	 public ResponseEntity<Customer> searchCustomer(@PathVariable String id ){
		
		Customer dbResults =service.searchCutomerDtls(id);
		return new ResponseEntity<Customer>(dbResults, HttpStatus.OK);
		
	}
	//Get customer all
	@GetMapping("/searchAll")
	 public ResponseEntity<List<Customer>> searchAllCustomer(){
		List<Customer> dbResults =service.searchAllCutomerDtls();
		return new ResponseEntity<List<Customer>>(dbResults, HttpStatus.OK);
		
		}	 
	
	//update customer 
	@PutMapping("/update")
	 public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customerDto){
		Customer dbResults= service.updateCustomerDtls(customerDto);
		
		return new ResponseEntity<Customer>(dbResults, HttpStatus.CREATED);
		
		}
	//Delete customer
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteCustomer(@PathVariable String id){
		String dbResults =service.deleteCutomerDtls(id);
		return new ResponseEntity<String>(dbResults, HttpStatus.OK);
		
		}
}

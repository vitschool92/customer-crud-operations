package com.vitech.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vitech.customer.model.Customer;

@Service
public interface CustomerService {

	Customer insertCustomerDtls(Customer customerDto);

	Customer searchCutomerDtls(String id);

	List<Customer> searchAllCutomerDtls();

	Customer updateCustomerDtls(Customer customerDto);

	String deleteCutomerDtls(String id);

}

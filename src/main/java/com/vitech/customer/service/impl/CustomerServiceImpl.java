package com.vitech.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitech.customer.model.Customer;
import com.vitech.customer.repo.CustomerRepo;
import com.vitech.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	public CustomerRepo   repo;
	
	@Override
	public Customer insertCustomerDtls(Customer customerDto) {
		log.info("insertCustomerDtls:: start ");
		Customer dbCustomer=null;
		try {
			 dbCustomer = repo.save(customerDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		log.info("insertCustomerDtls:: Db results saved successfully ");
		return dbCustomer;
	}

	@Override
	public Customer searchCutomerDtls(String id) {
		log.info("searchCutomerDtls:: start ");
		Optional<Customer> findById = repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Customer> searchAllCutomerDtls() {
		log.info("searchAllCutomerDtls:: start ");
		List<Customer> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public Customer updateCustomerDtls(Customer customerDto) {
		log.info("updateCustomerDtls:: start ");
		Optional<Customer> findById = repo.findById(customerDto.getCId());
		if(findById.isPresent()) {
			//if present need to update
			return repo.save(customerDto);
		}
		return null;
	}

	@Override
	public String deleteCutomerDtls(String id) {
		log.info("deleteCutomerDtls:: start ");
		String msg="";
		Optional<Customer> findById = repo.findById(id);
		if(findById.isPresent()) {
			repo.deleteById(id);
			msg = "deleted successfully";
		}else {
			msg = "Record is not present";
		}
		log.info(msg);
		return msg;
	}

}

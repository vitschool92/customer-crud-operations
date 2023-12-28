package com.vitech.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitech.customer.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>{

}

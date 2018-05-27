package com.java.cust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.cust.model.Customer;

@Repository
public interface CustomerCrudRepo extends JpaRepository<Customer, Long> {
	Customer findById(Long id);
}

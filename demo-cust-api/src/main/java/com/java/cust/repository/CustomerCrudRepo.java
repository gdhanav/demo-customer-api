package com.java.cust.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.cust.model.Customer;

@Repository
public interface CustomerCrudRepo extends JpaRepository<Customer, Long> {
	Optional<Customer> findById(Long id);
}

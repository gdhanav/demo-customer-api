package com.java.cust.service;

import java.util.List;

import com.java.cust.model.Customer;

public interface CustomerService {

	Customer save(Customer user);
    List<Customer> findAll();
    void delete(long id);
    Customer findById(long id);
}

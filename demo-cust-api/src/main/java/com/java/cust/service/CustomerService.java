package com.java.cust.service;

import java.util.List;

import com.java.cust.exception.CustomerException;
import com.java.cust.exception.CustomerNotFoundException;
import com.java.cust.model.Customer;

public interface CustomerService {

	Customer save(Customer user)throws CustomerException;
    List<Customer> findAll()throws CustomerException;
    void delete(long id) throws CustomerException;
    Customer findById(long id) throws CustomerNotFoundException;
}

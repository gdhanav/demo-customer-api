/**
 * 
 */
package com.java.cust.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.cust.exception.CustomerException;
import com.java.cust.exception.CustomerNotFoundException;
import com.java.cust.model.Customer;
import com.java.cust.repository.CustomerCrudRepo;
import com.java.cust.service.CustomerService;

/**
 * @author Dhana
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerCrudRepo dao;
	/* (non-Javadoc)
	 * @see com.java.cust.service.CustomerService#save(com.java.cust.model.Customer)
	 */
	@Override
	public Customer save(Customer user) throws CustomerException{
		return dao.save(user);
	}

	/* (non-Javadoc)
	 * @see com.java.cust.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() throws CustomerException{
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.java.cust.service.CustomerService#delete(long)
	 */
	@Override
	public void delete(long id) throws CustomerException{
		dao.delete(id);

	}

	@Override
	public Customer findById(long id) throws CustomerNotFoundException {
		
		Optional<Customer>  customer=dao.findById(id);
		customer.orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
		return customer.get();
	}

}

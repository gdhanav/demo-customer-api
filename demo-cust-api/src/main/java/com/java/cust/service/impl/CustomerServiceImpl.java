/**
 * 
 */
package com.java.cust.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Customer save(Customer user) {
		return dao.save(user);
	}

	/* (non-Javadoc)
	 * @see com.java.cust.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		List<Customer> list = new ArrayList<>();
		dao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.java.cust.service.CustomerService#delete(long)
	 */
	@Override
	public void delete(long id) {
		dao.delete(id);

	}

	@Override
	public Customer findById(long id) {
		return dao.findById(id);
	}

}

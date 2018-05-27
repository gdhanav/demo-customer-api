package com.java.cust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.cust.exception.CustomerException;
import com.java.cust.exception.CustomerNotFoundException;
import com.java.cust.model.Customer;
import com.java.cust.service.CustomerService;

@RestController
@RequestMapping(value = "/cust")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping(value = "/getAll")
	public List<Customer> getCustomers() throws CustomerException {
		return service.findAll();
	}

	@GetMapping(value = "/getById/{id}")
	public Customer getById(@PathVariable("id") long id) throws CustomerNotFoundException {
		return service.findById(id);
	}

	@PostMapping(value = "/add")
	public Customer addCustomer(@RequestBody Customer cust) throws CustomerException {
		return service.save(cust);
	}

	@PutMapping(value = "/update")
	public Customer updateCustomer(@RequestBody Customer cust) throws CustomerException {
		return service.save(cust);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") long id) throws CustomerException {
		service.delete(id);
	}
}

package com.java.cust.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.java.cust.exception.CustomerException;
import com.java.cust.exception.CustomerNotFoundException;
import com.java.cust.model.Customer;
import com.java.cust.repository.CustomerCrudRepo;
import com.java.cust.service.impl.CustomerServiceImpl;

public class CustomerServiceImplTest {
	 @InjectMocks
	    private CustomerServiceImpl customerService;

	    @Mock
	    private CustomerCrudRepo dao;

	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testSave() throws CustomerException, ParseException {
	        Customer customer = createCustomer();
	        when(dao.save(customer)).thenReturn(customer);
	        Customer cust = customerService.save(customer);
	        verify(dao).save(customer);
	        assertThat(cust.getId(), is(new Long(1)));
	    }

	    @Test
	    public void testFindAll() throws ParseException, CustomerException {
	        Customer customer = createCustomer();
	        List<Customer> customerList = Arrays.asList(customer);
	        when(dao.findAll()).thenReturn(customerList);
	        List<Customer> cust = customerService.findAll();
	        verify(dao).findAll();
	        assertThat(cust.size(), is(1));
	    }

	    @Test
	    public void testDelete() throws ParseException, CustomerException {
	        Long id = new Long("1");
	        doNothing().when(dao).delete(isA(Long.class));
	        customerService.delete(isA(Long.class));
	        verify(dao).delete(isA(Long.class));
	    }

	    @Test
	    public void testFindById() throws ParseException, CustomerNotFoundException {
	        Customer customer = createCustomer();
	        Optional<Customer> customerWithOptional = Optional.of(createCustomer());
	        when(dao.findById(customer.getId())).thenReturn(customerWithOptional);
	        Customer cust = customerService.findById(customer.getId());
	        verify(dao).findById(customer.getId());
	        assertThat(cust.getId(), is(new Long(1)));
	    }

	    public Customer createCustomer() throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	        Customer customer = new Customer();
	        customer.setId(1);
	        customer.setFirstName("Customer-1");
	        customer.setLastName("C1");
	        customer.setBirthDate(format.parse("27/05/2018"));
	        return customer;
	    }
	    
	    

}

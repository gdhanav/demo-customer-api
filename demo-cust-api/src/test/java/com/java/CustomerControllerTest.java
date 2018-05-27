package com.java;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.java.cust.controller.CustomerController;
import com.java.cust.model.Customer;
import com.java.cust.service.CustomerService;

public class CustomerControllerTest {
	 @InjectMocks
	    public CustomerController customerController;

	    @Mock
	    private CustomerService customerService;

	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testAddCustomer() throws Exception {
	        Customer customer = createCustomer();
	        when(customerService.save(isA(Customer.class))).thenReturn(customer);
	        Customer cust = customerController.addCustomer(customer);
	        verify(customerService).save(customer);
	        assertThat(cust.getId(), is(new Long(1)));

	    }

	    @Test
	    public void testGetCustomers() throws Exception {
	        Customer customer = createCustomer();
	        List<Customer> custs = new ArrayList<>();
	        custs.add(customer);
	        when(customerService.findAll()).thenReturn(custs);
	        List<Customer> customers = customerController.getCustomers();
	        verify(customerService).findAll();
	        assertThat(customers.toString(), is(custs.toString()));

	    }

	    @Test
	    public void testGetById() throws Exception {
	        Customer customer = createCustomer();
	        when(customerService.findById(isA(Long.class))).thenReturn(customer);
	        Customer cust = customerController.getById(customer.getId());
	        verify(customerService).findById(customer.getId());
	        assertThat(cust.getId(), is(new Long(1)));
	    }

	    @Test
	    public void updateCustomer() throws Exception {
	        Customer customer = createCustomer();
	        when(customerService.save(isA(Customer.class))).thenReturn(customer);
	        Customer cust = customerController.updateCustomer(customer);
	        verify(customerService).save(customer);
	        assertThat(cust.getId(), is(new Long(1)));

	    }

	    @Test
	    public void deleteCustomerById() throws Exception {
	        Customer customer = createCustomer();
	        doNothing().when(customerService).delete(isA(Long.class));
	        customerController.delete(customer.getId());
	        verify(customerService).delete(customer.getId());

	    }
	        /*
	         * @Test(expected=CustomerException.class) public void
	         * deleteCustGenericException() throws CustomerException,
	         * CustomerNotFoundException{ CustomerServiceImpl cust = new
	         * CustomerServiceImpl(); cust.setCustomers(null); cust.deletCustomer(0);
	         *
	         * }
	         *
	         * @Test(expected=CustomerNotFoundException.class) public void
	         * deleteCustNotFoundException() throws CustomerException,
	         * CustomerNotFoundException{ CustomerServiceImpl cust = new
	         * CustomerServiceImpl(); cust.deletCustomer(0);
	         *
	         * }
	         */

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

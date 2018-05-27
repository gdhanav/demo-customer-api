package com.java;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.cust.model.Customer;

@RunWith(SpringRunner.class)
public class TestCustomer {

	SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	
	public Customer createCustomer() throws ParseException {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Customer-1");
		customer.setLastName("C1");
		customer.setBirthDate(format.parse("27/05/2018"));
		return customer;
	} 
//	@Test
	public void testToString() throws ParseException{
		System.out.println("tostring::"+createCustomer());
		String expected ="Customer [id=" + 1 + ", firstName=" + "Customer-1" + ", lastName=" + "C1" + ", birthDate=" + format.parse("27/05/2018")
				+ "]";
		assertEquals(expected, createCustomer().toString());
	}
	
	@Test
	public void testGetters() throws ParseException{
		Customer customer = createCustomer();
		assertThat(customer.getId(),is(new Long(1)));
		assertThat(customer.getFirstName(),is("Customer-1"));
		assertThat(customer.getLastName(),is("C1"));
		assertThat(customer.getBirthDate(),is(format.parse("27/05/2018")));
        
	}
	
}

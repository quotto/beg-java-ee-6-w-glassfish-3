package org.beginningee6.book.chapter08.ex03;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {


	@EJB static CustomerRemoteEJB03 customerEJB;
	public static void main(String[] args) {
        Context ctx;
		try {
			ctx = new InitialContext();
//			CustomerRemoteEJB03 customerEJB = (CustomerRemoteEJB03) ctx.lookup("java:global/chapter08-2.0/CustomerEJB03!org.beginningee6.book.chapter08.ex03.CustomerEJB03");

			Customer03 customer = new Customer03();
			customer.setFirstName("Test");
			customer.setLastName("Taro");
			customer.setEmail("taro@example.com");
			customer = customerEJB.createCustomer(customer);

			customerEJB.findCustomerById(customer.getId());
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}

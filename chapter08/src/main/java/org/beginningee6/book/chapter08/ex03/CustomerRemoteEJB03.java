package org.beginningee6.book.chapter08.ex03;

import javax.ejb.Remote;

@Remote
public interface CustomerRemoteEJB03 {
	Customer03 createCustomer(Customer03 customer);
    Customer03 findCustomerById(Long id);
}

package org.beginningee6.book.chapter05.ex02;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DataValidationListener {

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @PrePersist
    @PreUpdate
    private void validate(Customer02 customer) {
        System.out.println("DataValidationListener validateData()");
        if (customer.getFirstName() == null || "".equals(customer.getFirstName()))
            throw new IllegalArgumentException("Invalid first name");
        if (customer.getLastName() == null || "".equals(customer.getLastName()))
            throw new IllegalArgumentException("Invalid last name");
        // PreUpdateで設定した値は反映されない
        System.out.println("Set Age 100");
        customer.setAge(100);
    }
}
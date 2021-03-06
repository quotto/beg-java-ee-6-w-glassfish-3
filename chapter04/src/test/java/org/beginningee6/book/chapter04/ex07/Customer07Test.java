package org.beginningee6.book.chapter04.ex07;

import org.beginningee6.book.chapter04.AbstractPersistentTest;
import static org.junit.Assert.*;

import org.beginningee6.book.chapter04.ex07.Address07;
import org.beginningee6.book.chapter04.ex07.Customer07;
import org.junit.Test;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer07Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test // Listing 4-9
    public void shouldPersistACustomerWithOneAddressSet() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");
        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");
        customer.setAddress(address);

        // Persist the object
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();

        assertNotNull(customer.getId());
        assertNotNull(address.getId());
    }

    @Test // Listing 4-10
    public void shouldFindACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");
        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");
        customer.setAddress(address);

        // Persist the object
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();

        assertNotNull(customer.getId());
        assertNotNull(address.getId());

        // Clear
        em.clear();

        customer = em.find(Customer07.class, customer.getId());
        assertNotNull(customer);
    }

    @Test // Listing 4-11
    public void shouldGetAReferenceToCustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");
        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");
        customer.setAddress(address);

        // Persist the object
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();

        assertNotNull(customer.getId());
        assertNotNull(address.getId());

        // Clear
        em.clear();

        customer = em.getReference(Customer07.class, customer.getId());
        assertNotNull(customer);
    }

    @Test // Listing 4-12
    public void shouldRemoveACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");
        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");
        customer.setAddress(address);

        // Persist the object
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();

        assertNotNull(customer.getId());
        assertNotNull(address.getId());

        // Removes the object
        tx.begin();
        em.remove(customer);
        em.remove(address);
        tx.commit();

        assertEquals(customer.getFirstName(), "Antony");
        assertEquals(address.getCity(), "London");

        customer = em.find(Customer07.class, customer.getId());
        assertNull(customer);
        address = em.find(Address07.class, address.getId());
        assertNull(address);
    }

    @Test // Listing 4-14
    public void shouldPersistACustomerAndThenRefreshIt() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");
        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");
        customer.setAddress(address);

        // Persist the object
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();

        assertNotNull(customer.getId());
        assertNotNull(address.getId());

        customer = em.find(Customer07.class, customer.getId());
        assertNotNull(customer);
        assertEquals(customer.getFirstName(), "Antony");

        customer.setFirstName("New first name");
        assertEquals(customer.getFirstName(), "New first name");

        em.refresh(customer);
        assertEquals(customer.getFirstName(), "Antony");
    }

    @Test // Listing 4-15
    public void shouldCheckIfItContainsACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();

        assertTrue(em.contains(customer));

        // Removes the object
        tx.begin();
        em.remove(customer);
        tx.commit();

        assertFalse(em.contains(customer));
    }

    @Test // Listing 4-16
    public void shouldDetachACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();

        assertTrue(em.contains(customer));

        // Detaches the object
        em.detach(customer);

        assertFalse(em.contains(customer));
    }

    @Test // Listing 4-17
    public void shouldClearAndThenMergeACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertTrue(em.contains(customer));

        em.clear();
        assertFalse(em.contains(customer));

        customer.setFirstName("William");
        tx.begin();
        em.merge(customer);
        tx.commit();

        em.clear();
        assertFalse(em.contains(customer));

        customer = em.find(Customer07.class, customer.getId());
        assertEquals(customer.getFirstName(), "William");
        assertTrue(em.contains(customer));

    }

    @Test // Listing 4-18
    public void shouldUpdateACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);

        assertNotNull(customer.getId());
        assertEquals(customer.getFirstName(), "Antony");

        customer.setFirstName("Williman");
        assertEquals(customer.getFirstName(), "Williman");

        tx.commit();
    }

    @Test // Listing 4-19
    public void shouldPersistACustomerAndAnAddress() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");
        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");
        customer.setAddress(address);

        // Persist the object
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();

        assertNotNull(customer.getId());
        assertNotNull(address.getId());
    }

    @Test // Listing 4-20
    public void shouldPersistACustomerAndCascadeToTheAddress() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");
        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");
        customer.setAddress(address);

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();

        assertNotNull(customer.getId());
        assertNotNull(address.getId());
    }

    @Test
    public void shouldUpdateACustomerAndThenClearIt() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertTrue(em.contains(customer));

        em.clear();
        assertFalse(em.contains(customer));

        customer = em.find(Customer07.class, customer.getId());
        assertEquals(customer.getFirstName(), "Antony");
        assertTrue(em.contains(customer));

    }

    @Test
    public void shouldClearSetAndThenMergeACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertTrue(em.contains(customer));

        em.clear();
        assertFalse(em.contains(customer));

        tx.begin();
        customer = em.merge(customer);
        customer.setFirstName("William");
        tx.commit();

        em.clear();
        assertFalse(em.contains(customer));

        customer = em.find(Customer07.class, customer.getId());
        assertEquals(customer.getFirstName(), "William");
        assertTrue(em.contains(customer));

    }

    @Test
    public void shouldPersistACustomer() throws Exception {

        Customer07 customer = new Customer07("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();

        assertNotNull(customer.getId());
    }

    @Test
    public void shouldPersistAnAddress() throws Exception {

        Address07 address = new Address07("Ritherdon Rd", "London", "8QE", "UK");

        // Persist the object
        tx.begin();
        em.persist(address);
        tx.commit();

        assertNotNull(address.getId());
    }
}
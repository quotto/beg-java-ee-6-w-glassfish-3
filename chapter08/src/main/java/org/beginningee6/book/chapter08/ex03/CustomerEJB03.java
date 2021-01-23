package org.beginningee6.book.chapter08.ex03;

import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
@Remote(CustomerRemoteEJB03.class)
@LocalBean
@Interceptors(ProfileIterceptor.class)
public class CustomerEJB03 implements CustomerRemoteEJB03 {
    private Logger logger = Logger.getLogger("com.apress.javaee6");


    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter08PU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @Interceptors(LoggingInterceptor03.class)
    public Customer03 createCustomer(Customer03 customer) {
    	System.out.println("create customer");
    	System.out.printf("create customer %s,%s\n", new Object[] {customer.getFirstName(),customer.getLastName()});
        em.persist(customer);
        em.flush();
        return customer;
    }

    public Customer03 findCustomerById(Long id) {
    	System.out.printf("find customer id@%d\n", new Object[] {id});
        return em.find(Customer03.class, id);
    }

    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception {
    	logger.info(String.format("intercept by AroundInvoke @ %s",new Object[] {this.getClass().getName()}));
        long initTime = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            long diffTime = System.currentTimeMillis() - initTime;
            logger.fine(ic.getMethod() + " took " + diffTime + " milliseconds.");
        }
    }
}
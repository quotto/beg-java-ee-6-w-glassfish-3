package org.beginningee6.book.chapter08.ex03;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AuditInterceptor03 {

    private Logger logger = Logger.getLogger("com.apress.javaee6");

    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception {
    	logger.info(String.format("intercept @ %s",new Object[] {this.getClass().getName()}));
        long initTime = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            long diffTime = System.currentTimeMillis() - initTime;
            logger.fine(ic.getMethod() + " took " + diffTime + " milliseconds.");
        }
    }
}

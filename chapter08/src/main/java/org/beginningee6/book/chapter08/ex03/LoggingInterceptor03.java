package org.beginningee6.book.chapter08.ex03;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor03 {

    private Logger logger = Logger.getLogger("com.apress.javaee6");

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
    	logger.info(String.format("intercept by Interceptors @ %s",new Object[] {this.getClass().getName()}));

    	logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
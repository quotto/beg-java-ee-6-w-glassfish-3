package org.beginningee6.book.chapter08.ex03;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;

public class ProfileIterceptor {
    private Logger logger = Logger.getLogger("com.apress.javaee6");
    @PostConstruct
    public Object logPostConstruct(InvocationContext ic) throws Exception {
    	logger.info(String.format("intercept by ProfileItnterceptor(PostConstruct) @ %s",new Object[] {this.getClass().getName()}));
        long initTime = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            long diffTime = System.currentTimeMillis() - initTime;
            logger.fine(ic.getMethod() + " took " + diffTime + " milliseconds.");
        }
    }

    @PreDestroy
    public Object logPreDeproy(InvocationContext ic) throws Exception {
    	logger.info(String.format("intercept by ProfileItnterceptor(PreDeproy) @ %s",new Object[] {this.getClass().getName()}));
        long initTime = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            long diffTime = System.currentTimeMillis() - initTime;
            logger.fine(ic.getMethod() + " took " + diffTime + " milliseconds.");
        }
    }
}

package com.pms.pmsapp.util.async;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;


@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(AsyncExceptionHandler.class);
	
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... args) {
        log.error("Method Name" + method.getName()
        + "---" + Arrays.toString(args) + "----"
        + "error Message: " + ex.getMessage());

    }
}

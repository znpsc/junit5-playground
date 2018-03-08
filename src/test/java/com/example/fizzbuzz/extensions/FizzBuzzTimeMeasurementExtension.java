package com.example.fizzbuzz.extensions;

import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;
import java.util.logging.Logger;


public class FizzBuzzTimeMeasurementExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback, BeforeEachCallback, BeforeAllCallback {
private static final Logger logger = Logger.getLogger(FizzBuzzTimeMeasurementExtension.class.getName());

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

        logger.info("say hello before ALL!");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("say hello before EACH!");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {

    //getStore(context).put("Method1", System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        //Method requiredTestMethod = context.getRequiredTestMethod();

        logger.info("---> " + context.getRequiredTestMethod().getName());
    }


    private ExtensionContext.Store getStore(ExtensionContext context) {
        return null;//context.getStore();
    }
}

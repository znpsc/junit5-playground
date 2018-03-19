package com.example.fizzbuzz.extensions;

import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;


public class FizzBuzzTimeMeasurementExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback, BeforeEachCallback, BeforeAllCallback, AfterAllCallback, AfterEachCallback {

    private static final String ALL = "All";
    private static final String EACH = "Each";
    private static final String TEST = "Test";
    Map<String, Long> timeExe = new ConcurrentHashMap<>();

    @Override
    public void beforeAll(ExtensionContext context) {
        timeExe.put(ALL, System.currentTimeMillis());
        System.out.println("beforeAll " + context.getRequiredTestClass().getName());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception{
        Thread.sleep(500);
        timeExe.put(EACH, System.currentTimeMillis());
        System.out.println("\nbeforeEach " + context.getRequiredTestMethod().getName());
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception{
        Thread.sleep(100);
        timeExe.put(TEST, System.currentTimeMillis());
        System.out.println("beforeTest " + context.getRequiredTestMethod().getName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        long duration = System.currentTimeMillis() - timeExe.get(TEST);
        System.out.println("afterTestExecution " + context.getRequiredTestMethod().getName() + " time: " + duration + "ms");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        long duration = System.currentTimeMillis() - timeExe.get(EACH);
        System.out.println("afterEach " + context.getRequiredTestMethod().getName() + " total time: " + duration + "ms");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        long duration = System.currentTimeMillis() - timeExe.get(ALL);
        System.out.println("\nafterAll " + context.getRequiredTestClass().getName() + " time: " + duration + "ms");
    }
}

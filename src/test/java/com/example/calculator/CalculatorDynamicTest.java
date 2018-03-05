package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("Basic calculus in case of dynamic test")
public class CalculatorDynamicTest {

    Calculator sut;

    @BeforeEach
    void setUp(){
        sut = new Calculator();
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestFromCollection() {

        return Arrays.asList(dynamicTest("sss", () -> assertTrue(true)));
    }


}

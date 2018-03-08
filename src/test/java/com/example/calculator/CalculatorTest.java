/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Basic calculus")
class CalculatorTest {

    Calculator sut;
    static long startTime;

    @BeforeAll
    static void setUpAll() {
        startTime = System.currentTimeMillis();
    }

    @BeforeEach
    void setUp() {
        sut = new Calculator();
    }

    @Test
    @DisplayName("for adding operation")
    //@Disabled
    //@EnabledOnJre(JRE.JAVA_11)
    @DisabledOnOs(OS.WINDOWS)
    void testWhenAdd() {

        assertEquals(2, sut.add(1, 1), "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("for diving by zero and throwing an exception")
    void testWhenDivide() {

        NotDividedByZeroException calculatorException = assertThrows(NotDividedByZeroException.class, () -> sut.divide(2, 0));
        assertEquals(calculatorException.getMessage(), "Can't by zero!");
    }

    @Test
    @DisplayName("subtract and displaying testInfo")
    void testWhenSubtract(TestInfo testInfo) {
        assertEquals("subtract and displaying testInfo", testInfo.getDisplayName());
        assertEquals(10, sut.subtract(40, 30));
    }


    @RepeatedTest(20)
    void testWhenMultiply() {
        sut.multiply(2, 2);
    }

    @Test
    @DisplayName("for checking two primes \uD83D\uDE31 ╯°□°）╯")
    void isPrime() {
        assertFalse(sut.isPrime(10));
        assertTrue(sut.isPrime(13));
    }

    @Tag("Priority1")
    @Test
    void testWhenMultiplyLargeNumber() {
        assertEquals(400_000_000, sut.multiply(10_000, 40_000));
    }


    @Nested
    @DisplayName("for negative numbers")
    @Tag("nested")
    class NegativeNumbersTest {

        @Test
        @DisplayName("for adding")
        void testWhenAddingNegative() {
            assertEquals(-3, sut.add(-1, -2));
        }

        @Test
        @DisplayName("for multiplying")
        void testWhenMultiplyNegative() {
            assertEquals(2, sut.multiply(-1, -2));
        }
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
        long endTime = System.currentTimeMillis();
        System.out.print("Execution time: " + (endTime - startTime) + " ms");
    }
}
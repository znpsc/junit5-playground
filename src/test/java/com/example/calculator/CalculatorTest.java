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
    void testWhenMutliply() {
        sut.multiply(2, 2);
    }


    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 9})
    void whenIsDividedBy5(int a) {
        assertEquals(0, sut.modulo(a, 5));
    }

    @ParameterizedTest
    @CsvSource({"25,5", "9,3", "28, 4", "17, 16"})
    @DisplayName("for checking divisibility")
    void isDivisible(int a, int b) {
        assertEquals(0, sut.modulo(a, b));
    }

    @Test
    @DisplayName("for checking two primes")
    void isPrime() {
        assertFalse(sut.isPrime(10));
        assertTrue(sut.isPrime(13));
    }

    @ParameterizedTest
    @MethodSource("first10PrimesProvider")
    void isPrime(int prime) {

        assertTrue(sut.isPrime(prime));
    }

    static Stream<Integer> first10PrimesProvider() {
        return Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 28);
    }

    //TODO: add to classpath!!!!!!!!!!!!!!!!!!!!!!!
//    @ParameterizedTest
//    @CsvFileSource(resources = "ABsum.csv", numLinesToSkip = 1, delimiter = ';')
//    void testWhenAddingMultipleNumbersFromExternalFile(int a, int b, int sum) {
//        assertEquals(sum, sut.add(a, b));
//    }


    @Tag("Priority1")
    @Test
    void testWhenMultiplyLargeNumber() {
        assertEquals(400_000_000, sut.multiply(10_000, 40_000));
    }


    @Nested
    @DisplayName("for negative numbers")
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

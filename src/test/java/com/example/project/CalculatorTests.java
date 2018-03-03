/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Basic calculus")
class CalculatorTests {

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
    void add() {

        assertEquals(2, sut.add(1, 1), "1 + 1 should equal 2");
    }

    @Test
    void divide() throws NotDividedByZeroException {

        NotDividedByZeroException calculatorException = assertThrows(NotDividedByZeroException.class, () -> sut.divide(2, 0));
        assertEquals(calculatorException.getMessage(), "Can't by zero!");
    }

    @Test
    @DisplayName("subtract me")
        //@Tag("my tag")
    void subtract(TestInfo testInfo) {

        assertEquals("subtract me", testInfo.getDisplayName());
        // assertEquals("my tag", testInfo.getTags().iterator().next());
    }

    // @Test
    @RepeatedTest(20)
    void mutliply() {

        sut.subtract(2, 2);

    }


    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 9})
    void isDividedBy5(int a) {

        assertEquals(0, sut.modulo(a, 5));

    }

    @ParameterizedTest
    @CsvSource({"25,5", "9,3", "28, 4", "17, 17"})
    @DisplayName("Divide")
    void isDivideable(int a, int b, TestInfo testInfo) {

        assertEquals(0, sut.modulo(a, b));


    }

    @ParameterizedTest
    @MethodSource("first10PrimesProvider")
    void isPrime(int prime) {

        assertTrue(sut.isPrime(prime));
    }

    static Stream<Integer> first10PrimesProvider() {
        return Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 28);
    }


    @AfterEach
    void tearDown() {
        sut = null;
    }

    @AfterAll
    static void tearDownAll() {
        long endTime = System.currentTimeMillis();
        System.out.print("Execution time: " + (endTime - startTime) + " ms");
    }


}

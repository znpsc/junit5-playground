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

import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Calculator test  \uD83D\uDE31 ")
class CalculatorTest {

    Calculator sut;

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
        sut = new Calculator();
    }

    @Test
   // @Disabled
    //@EnabledOnJre(JRE.JAVA_11)
    @EnabledOnOs(OS.SOLARIS)
    public void shouldAddTwoNumbers() {
        assertEquals(3, sut.add(1,2));
    }



    @Test
    @Tag("customTag")
    void shouldMultiplyTwoNumbers() {

        assertAll(
                () -> assertEquals(2, sut.multiply(1,2)),
                () -> assertEquals(40, sut.multiply(2,2)),
                () -> assertEquals(30, sut.multiply(15,2)),
                () -> assertEquals(25, sut.multiply(10,2)),
                () -> assertEquals(2, sut.multiply(1,2)),
                () -> assertEquals(17, sut.multiply(17,1))
        );
    }

    @Test
    @DisplayName("Should multiply two numbers with timeout")
    void shouldMultiplyTwoNumbersWithTimeout() {

        assertTimeout(Duration.ofMillis(100), () -> {
            assertEquals(1, sut.multiply(1,1));
            Thread.sleep(2000);
        });

    }




    //@Test
    //@RepeatedTest(20000)
    void shouldSubtractWithAssumption() {

        assumeTrue(System.getProperty("os.name").startsWith("Windows"));

                assertEquals(3, sut.subtract(9,6));

    }

    @Test
    void shouldNotDivide() {
        assertThrows(NotDividedByZeroException.class, () -> sut.divide(1, 0));
    }

    @AfterEach
    void tearUp() {

    }

    @AfterAll
    static void afterAll() {

    }

}
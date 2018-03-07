package com.example.calculator.extensions;


import com.example.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Calculator with custom extension")
class CalculatorExtendWithTest {

    Calculator sut;

    @BeforeEach
    void setUp() {
        sut = new Calculator();
    }

    @Test
    @DisplayName("test multiplication")
    @CalculatorEnvironment(type = CalculatorEnvironment.Type.TEST)
    void testWhenMultiply() {

        assertAll(
                () -> assertEquals(800, sut.multiply(20, 40), "multiply two integers"),
                () -> assertEquals(400, sut.multiply(10, 40), "multiply two integers"),
                () -> assertEquals(100, sut.multiply(25, 4), "multiply two integers"),
                () -> assertEquals(0, sut.multiply(49, 0), "multiply two integers"),
                () -> assertEquals(225, sut.multiply(15, 15), "multiply two integers")
        );
    }

    @Test
    @DisplayName("test when adding")
    @CalculatorEnvironment(type = CalculatorEnvironment.Type.PRODUCTION)
    void testWhenAdding() {

        assertAll(
                () -> assertEquals(60, sut.add(20, 40), "add two integers"),
                () -> assertEquals(54, sut.add(13, 41), "add two integers"),
                () -> assertEquals(0, sut.add(-5, 5), "add two integers"),
                () -> assertEquals(50, sut.add(49, 1), "add two integers"),
                () -> assertEquals(30, sut.add(15, 15), "add two integers")
        );
    }

    @Test
    @DisplayName("test prime numbers")
    @CalculatorEnvironment
    void testPrimeNumbers() {

        assertAll(
                () -> assertTrue(sut.isPrime(3), "determine prime"),
                () -> assertTrue(sut.isPrime(5), "determine prime"),
                () -> assertTrue(sut.isPrime(7), "determine prime"),
                () -> assertTrue(sut.isPrime(11), "determine prime"),
                () -> assertTrue(sut.isPrime(23), "determine prime")

        );
    }
}
package com.example.calculator.parametrized;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorParametrizedTest {

    Calculator sut;

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
        sut = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"1,1,2", "1,2,3", "3,4,7"})
    public void shouldAddTwoNumbers(int a, int b, int expected) {
        assertEquals(expected, sut.add(a,b));
    }

    @ParameterizedTest
    @MethodSource("first10Primes")
    public void shouldBePrime(Integer prime) {
        assertTrue(sut.isPrime(prime));
    }

    static Stream<Integer> first10Primes() {
        return Stream.of(3,5,7,11,13,17,19,23);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ABsum.csv", delimiter = ';', numLinesToSkip = 1)
    public void shouldAddTwoNumbers2(int a, int b, int expected) {
        assertEquals(expected, sut.add(a,b));
    }

}

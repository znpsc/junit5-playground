package com.example.calculator.parametrized;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parametrized tests for basic calculus")
public class CalculatorParametrizedTest {

    Calculator sut;

    @BeforeEach
    void setUp() {
        sut = new Calculator();
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

    @ParameterizedTest
    @MethodSource("first10PrimesProvider")
    void isPrime(int prime) {
        assertTrue(sut.isPrime(prime));
    }

    static Stream<Integer> first10PrimesProvider() {
        return Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 28);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ABsum.csv", numLinesToSkip = 1, delimiter = ';')
    @Tag("csvFileOnly")
    @DisplayName("When adding multiple numbers from external file")
    void testWhenAddingMultipleNumbersFromExternalFile(int a, int b, int sum) {
        assertEquals(sum, sut.add(a, b));
    }


}

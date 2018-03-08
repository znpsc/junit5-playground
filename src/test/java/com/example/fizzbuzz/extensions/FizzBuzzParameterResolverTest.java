package com.example.fizzbuzz.extensions;

import com.example.fizzbuzz.FizzBuzzProblem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FizzBuzzExtension.class)
public class FizzBuzzParameterResolverTest {

    FizzBuzzProblem sut;

    @BeforeEach
    void setUp() {
        sut = new FizzBuzzProblem();
    }

    @ParameterizedTest
    @MethodSource("fizzNumbers")
    void testFizzNumbers(Integer number) {
        assertEquals("Fizz", sut.getFizzBuzzNumber(number));
    }

    @ParameterizedTest
    @MethodSource("buzzNumbers")
    void testBuzzNumbers(Double number) {
        int value = number.intValue();
        assertEquals("Buzz", sut.getFizzBuzzNumber(value));
    }

    static Stream<Number> fizzNumbers() {
        return Stream.of(3, 9, 12, 18);
    }

    static Stream<Number> buzzNumbers() {
        return Stream.of(5.5, 10.2, 25.5);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 12, 18})
    void testFizzNumbersWithValueSource(Integer number) {
        assertEquals("Fizz", sut.getFizzBuzzNumber(number));
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "25", "100"})
    void testBuzzNumbersWithCsvSource(Integer number) {
        assertEquals("Buzz", sut.getFizzBuzzNumber(number));
    }
}
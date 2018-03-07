package com.example.fizzbuzz.extensions;

import com.example.fizzbuzz.FizzBuzzProblem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FizzBuzzExtension.class)
public class FizzBuzzExtendWithTest {

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
    void testBuzzNumbers(int number) {
        assertEquals("Buzz", sut.getFizzBuzzNumber(number));
    }

    static Stream<Number> fizzNumbers() {
        return Stream.of(3, 9, 12, 18);
    }

    static Stream<Number> buzzNumbers() {
        return Stream.of(5, 10, 25);
    }
}
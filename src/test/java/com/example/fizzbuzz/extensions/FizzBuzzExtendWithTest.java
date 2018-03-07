package com.example.fizzbuzz.extensions;

import com.example.fizzbuzz.FizzBuzzProblem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
 //   @ParameterizedTest
    //@MethodSource("invalidIntegers")
    void testFizzNumbers(int number) {

        assertEquals("Fizz", sut.getFizzBuzzNumber(number));
    }

    @Test
 //  @ParameterizedTest
   // @MethodSource("validIntegers")
    void testBuzzNumbers(int number) {

        assertEquals("Buzz", sut.getFizzBuzzNumber(number));
    }

    Stream<Number> invalidIntegers() {
        return Stream.of(3, 9, 0.7, 18);
    }

    Stream<Number> validIntegers() {
        return Stream.of(5, 10, 15);
    }
}

package com.example.fizzbuzz.extensions;

import com.example.fizzbuzz.FizzBuzzProblem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FizzBuzzTimeMeasurementExtension.class)
public class FizzBuzzTimingTest {

    FizzBuzzProblem sut;

    @BeforeEach
    void setUp() throws InterruptedException {
        sut = new FizzBuzzProblem();
        Thread.sleep(1000);
    }

    @Test
    void testFizzNumbers() {
        assertEquals("Fizz", sut.getFizzBuzzNumber(3));
    }

    @Test
    void testBuzzNumbers() {
        assertEquals("Buzz", sut.getFizzBuzzNumber(25));
    }
}

package com.example.fizzbuzz;

import com.example.fizzbuzz.extensions.FizzBuzzTimeMeasurementExtension;
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
        Thread.sleep(1000); //cheating
    }

    @Test
    void testFizzNumbers() throws InterruptedException {
        assertEquals("Fizz", sut.getFizzBuzzNumber(3));
        Thread.sleep(500); //cheating
    }

    @Test
    void testBuzzNumbers() throws InterruptedException {
        assertEquals("Buzz", sut.getFizzBuzzNumber(25));
        Thread.sleep(500); //cheating
    }
}

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
    void setUp() {
    sut = new FizzBuzzProblem();
    }

    @Test
    void shouldReturnFizz() throws InterruptedException {
        assertEquals("Fizz", sut.getFizzBuzzNumber(3));
        Thread.sleep(100);
    }

    @Test
    void shouldReturnBuzz() throws InterruptedException {
        assertEquals("Buzz", sut.getFizzBuzzNumber(5));
        Thread.sleep(100);
    }

    @Test
    void shouldReturnFizzBuzz() throws InterruptedException {
        assertEquals("FizzBuzz", sut.getFizzBuzzNumber(15));
        Thread.sleep(100);
    }
}

package com.example.fizzbuzz;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class FizzBuzzProblemTest {

    FizzBuzzProblem sut;

    @BeforeEach
    void setUp() {
        sut = new FizzBuzzProblem();
    }

    @Test
    @DisplayName("Some nested assertions when divided by 3 written with use of assertAll")
    void testWhenDividedBy3UsingAssertAll() {
        assertAll(
                () -> assertEquals("Fizz", sut.getFizzBuzzNumber(3)),
                () -> assertEquals("Fizz", sut.getFizzBuzzNumber(17)),
                () -> assertEquals("Fizz", sut.getFizzBuzzNumber(99)),
                () -> assertEquals("Fizz", sut.getFizzBuzzNumber(47))
        );
    }

    @Test
    @DisplayName("Some assertions when divided by 3 written in old junit4-way")
    void testWhenDividedBy3InOldWay() {
        assertEquals("Fizz", sut.getFizzBuzzNumber(3));
        assertEquals("Fizz", sut.getFizzBuzzNumber(17));
        assertEquals("Fizz", sut.getFizzBuzzNumber(17));
        assertEquals("Fizz", sut.getFizzBuzzNumber(99));
    }

    @Test
    @DisplayName("Some assertions when divided by 5 with use of timeout")
    void testWhenDividedBy5() {

        assertAll(
                () -> assertTimeout(Duration.ofMillis(100), () -> {
                    assertEquals("Buzz", sut.getFizzBuzzNumber(5));
                }),
                () -> assertTimeout(Duration.ofMillis(100), () -> {
                    Thread.sleep(200);
                    assertEquals("Buzz", sut.getFizzBuzzNumber(175));
                })
        );

    }

    @Test
    void testWhenDivedBy3and5WithUseOfAssume() {

        assumeTrue(System.getProperty("os.name").startsWith("Windows"));

        assertAll(
                () -> assertEquals("FizzBuzz", sut.getFizzBuzzNumber(15)),
                () -> assertEquals("FizzBuzz", sut.getFizzBuzzNumber(30)),
                () -> assertEquals("FizzBuzz", sut.getFizzBuzzNumber(150))
        );
    }

    @Test
    void testWhenDivedBy3and5WithUseOfFailureAssume() {

        Locale currentLocale = Locale.getDefault();
        assumeTrue(currentLocale.equals(Locale.FRENCH));

        assertAll(
                () -> assertEquals("FizzBuzz", sut.getFizzBuzzNumber(15)),
                () -> assertEquals("FizzBuzz", sut.getFizzBuzzNumber(30)),
                () -> assertEquals("FizzBuzz", sut.getFizzBuzzNumber(150))
        );
    }

    @AfterEach
    void tearDown() {
    }

}
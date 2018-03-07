package com.example.calculator.dynamic;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("Dynamic unit testing for basic calculus")
public class CalculatorDynamicTest {

    Calculator sut;

    @BeforeEach
    void setUp() {
        sut = new Calculator();
    }

    @TestFactory
    @DisplayName("Dynamic test for multiplication and returning results as collection")
    Collection<DynamicTest> dynamicTestFromCollection() {

        int multiplier = 10;
        List<DynamicTest> dynamicTestList = new ArrayList<>();
        for (int i = 0; i < multiplier; i++) {
            dynamicTestList.add(generateMultipliersResults(i, multiplier, i * multiplier));
        }
        return dynamicTestList;
    }

    private DynamicTest generateMultipliersResults(int multiplicand, int multiplier, int result) {
        return dynamicTest(
                "Dynamic test case #" + multiplicand,
                () -> assertEquals(result, sut.multiply(multiplicand, multiplier)));
    }

    @TestFactory
    @DisplayName("Dynamic test for multiplication and returning results as stream")
    Stream<DynamicTest> dynamicTestStream() {

        Stream<Integer> multiplicands = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final int multiplier = 10;
        return multiplicands
                .map(e -> dynamicTest("Dynamic test case #" + e, () -> assertEquals(e * multiplier, sut.multiply(e, multiplier))));
    }

    @TestFactory
    @DisplayName("Dynamic test for multiplication and returning results as iterable")
    Iterable<DynamicTest> dynamicTestIterable() {
        Stream<Integer> multiplicands = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final int multiplier = 10;
        return multiplicands
                .map(e -> dynamicTest("Dynamic test case #" + e, () -> assertEquals(e * multiplier, sut.multiply(e, multiplier))))
                .collect(Collectors.toSet());
    }

    @TestFactory
    @DisplayName("Dynamic test for multiplication and returning results as iterator")
    Iterator<DynamicTest> dynamicTestIterator() {
        Stream<Integer> multiplicands = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final int multiplier = 10;
        return multiplicands
                .map(e -> dynamicTest("Dynamic test case #" + e, () -> assertEquals(e * multiplier, sut.multiply(e, multiplier))))
                .iterator();
    }
}
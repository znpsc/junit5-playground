package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("Basic calculus for showing example of dynamic test")
public class CalculatorDynamicTest {

    Calculator sut;

    @BeforeEach
    void setUp() {
        sut = new Calculator();
    }

    @TestFactory
    @DisplayName("for multiplication and returning collection")
    Collection<DynamicTest> dynamicTestFromCollection() {

        int init = 10;
        List<DynamicTest> dynamicTestList = new ArrayList<>();
        for (int i = 0; i < init; i++) {
            dynamicTestList.add(generateXMultiplies(i, init, i * init));
        }
        return dynamicTestList;
    }

    @TestFactory
    @DisplayName("for mutliplication return stream")
    Stream<DynamicTest> dynamicTestStream() {


        int init = 10;
        List<DynamicTest> dynamicTestList = new ArrayList<>();
        for (int i = 0; i < init; i++) {
            dynamicTestList.add(generateXMultiplies(i, init, i * init));
        }


        return Stream.of(dynamicTest("aaa", () -> generateXMultiplies(1, 1, 1)));
    }

    @TestFactory
    @DisplayName("")
    Iterable<DynamicTest> dynamicTestIterable() {
        return null;
    }

    @TestFactory
    @DisplayName("")
    Iterator<DynamicTest> dynamicTestIterator() {
        return null;
    }

    //TODO name of them method should be refactor
    private DynamicTest generateXMultiplies(int input, int multiplicator, int result) {
        return dynamicTest("Case#" + input + ": " + input + "*" + multiplicator + "=" + result, () -> assertEquals(result, input * multiplicator));
    }


}

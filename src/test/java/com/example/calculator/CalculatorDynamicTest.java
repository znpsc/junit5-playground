package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    Stream<DynamicTest> dynamicTestStream(){




    }

    //TODO name of them method should be refactor
    private DynamicTest generateXMultiplies(int input, int multiplicator, int result) {
        return dynamicTest("Case#" + input + ": " + input + "*" + multiplicator + "=" + result, () -> assertEquals(result, input * multiplicator));
    }




}

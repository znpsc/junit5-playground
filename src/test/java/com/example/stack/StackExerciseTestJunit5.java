package com.example.stack;

import com.example.stack.StackExercise;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit tests for Stack in JUnit5")
class StackExerciseTestJunit5 {

    StackExercise sut;

    @BeforeEach
    void setUp() {
        sut = new StackExercise();
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    void pop() {
    }

    @Test
    void push() {
    }

    @Test
    void top() {
    }

    @Test
    void isEmpty() {
    }
}
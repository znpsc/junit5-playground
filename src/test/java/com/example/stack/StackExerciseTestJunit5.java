package com.example.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit tests for Stack in JUnit5")
class StackExerciseTestJunit5 {

    StackExercise sut;

    @BeforeEach
    void setUp() {
        sut = new StackExercise();
    }

}
package com.example.calculator.extensions;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(CalculatorEnvironmentExtension.class)
public @interface CalculatorEnvironment{

    enum Type {
           DEV, TEST, PRODUCTION
    }

    Type type() default Type.DEV;
}

package com.example.calculator.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;

public class CalculatorEnvironmentExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {

        Optional<CalculatorEnvironment.Type> optionalType = extensionContext
                .getTestMethod()
                .filter(m -> m.isAnnotationPresent(CalculatorEnvironment.class))
                .map(m -> m.getAnnotation(CalculatorEnvironment.class))
                .map(e -> e.type())
                .filter(e -> e.equals(CalculatorEnvironment.Type.PRODUCTION));
        if (optionalType.isPresent()) {
            return ConditionEvaluationResult.disabled("production test are disabled");
        }

        return ConditionEvaluationResult.enabled("enabling test");
    }
}

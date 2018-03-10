package com.example.fizzbuzz.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class FizzBuzzParameterResolverExtension implements ParameterResolver{
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        return parameterContext.getParameter().getType().equals(Double.class) || parameterContext.getParameter().getType().equals(double.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        System.out.println("aaaaaaaaaaaaaaaa");
        //????!!!!
        return null;
    }
}

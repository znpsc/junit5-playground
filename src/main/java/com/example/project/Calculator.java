package com.example.project;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) throws NotDividedByZeroException {

		if(b == 0) {
			throw new NotDividedByZeroException("Can't by zero!");
		}

		if(a % b != 0) {
			throw new NotDividedByZeroException("Can't obtain integer result!");
		}

		return a/b;
	}

	public int modulo(int a, int b) {
		return a % b;
	}

	public boolean isPrime(int a) {

		for (int i = 2; i < a; i++) {
			if(modulo(a, i)==0)
				return false;
		}
		return true;
	}
}

package com.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Integer, Integer> previousResult = new HashMap<>();
	public int nFibo(int n) {

		if (n < 0) {
			throw new IllegalArgumentException("Invalid Parameter. Number must be greater or equal zero.");
		}

		if (previousResult.get(n) != null) {
			return previousResult.get(n);
		}

		if (n == 0 || n == 1) {
			return n;
		}
		int result = nFibo(n - 1) + nFibo(n - 2);
		previousResult.put(n, result);
		return result;
	}
}

package com.challenges;

public class HighestProduct {

	// {3,5,7,2,6}
	// { 5, 2, 3, 10, 2, 1, 4, 0}
	public int getHighestProduct(int[] input) {
		int max = input[0];
		int product = 0;
		int indMax = 0;
		for (int i = 0; i < input.length; i++) {
			if (max < input[i]) {
				max = input[i];
				indMax = i;
			}
		}
		input[indMax] = 1;
		product = max;
		max = 0;
		indMax = 0;
		for (int i = 0; i < input.length; i++) {
			if (max < input[i]) {
				max = input[i];
				indMax = i;
			}
		}
		input[indMax] = 1;
		product *= max;
		max = 0;
		for (int i = 0; i < input.length; i++) {
			if (max < input[i]) {
				max = input[i];
			}
		}
		product *= max;

		return product;
	}
}

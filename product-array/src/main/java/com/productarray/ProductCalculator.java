package com.productarray;

public class ProductCalculator {

	//[2, 4, 10] = [40,10,1]
	public int[] getArrayProduct(int[] input) {
		int[] result = new int[input.length];
		int productTmp = 1;

		// It takes the product after each index within array. For example: product after 2 is 40; product after 4 is 10 and so on.
		for (int j = input.length - 1; j >= 0; j--) {
			result[j] = productTmp;
			productTmp *= input[j];
		}
		productTmp = 1;
		for (int i = 0; i < input.length; i++) {
			result[i] = result[i] * productTmp;
			productTmp *= input[i];
		}

		return result;
	}
}

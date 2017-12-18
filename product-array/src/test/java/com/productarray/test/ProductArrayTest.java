package com.productarray.test;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

import com.productarray.ProductCalculator;

public class ProductArrayTest {

	@Test
	public void simpleTest() {
		ProductCalculator calculator = new ProductCalculator();
		int[] result = calculator.getArrayProduct(new int[] { 1, 7, 3, 4 });
		assertArrayEquals(new int[]{84,  12, 28, 21}, result);
	}
}

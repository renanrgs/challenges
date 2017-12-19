package com.challenges.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.challenges.HighestProduct;

public class TestHighestProduct {

	@Test
	public void testHighestProduct() {
		HighestProduct highestProduct = new HighestProduct();
		assertEquals(6, highestProduct.getHighestProduct(new int[] { 1, 2, 3, }));
		assertEquals(210, highestProduct.getHighestProduct(new int[] { 3, 5, 7, 2, 6 }));
		assertEquals(200, highestProduct.getHighestProduct(new int[] { 5, 2, 3, 10, 2, 1, 4, 0}));
		assertEquals(210, highestProduct.getHighestProduct(new int[] { 3, -5, -7, 2, -6 }));
	}
}

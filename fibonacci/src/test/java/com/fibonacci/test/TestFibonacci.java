package com.fibonacci.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fibonacci.Fibonacci;

public class TestFibonacci {

/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testFibonacci() {
		Fibonacci f = new Fibonacci();
		assertEquals(0, f.nFibo(0));
		assertEquals(3, f.nFibo(4));
	}

}

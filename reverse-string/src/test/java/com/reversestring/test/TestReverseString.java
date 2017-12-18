package com.reversestring.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.reversestring.ReverseString;

public class TestReverseString {

	@Test
	public void testReverse() {
		assertEquals("naneR", ReverseString.reverse("Renan"));
		assertEquals("siahT", ReverseString.reverse("Thais"));
	}
}

package com.parser.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.parser.RomanNumeralParser;

public class RomanNumeralsTest {

	RomanNumeralParser parser = new RomanNumeralParser();

	@Test
	public void simpleParseTest() {
		assertEquals(1, parser.parse("I"));
		assertEquals(5, parser.parse("V"));
		assertEquals(10, parser.parse("X"));
		assertEquals(100, parser.parse("C"));
		assertEquals(500, parser.parse("D"));
		assertEquals(1000, parser.parse("M"));
	}

	@Test
	public void complexParseTest() {
		assertEquals(2017, parser.parse("MMXVII"));
		assertEquals(1999, parser.parse("MCMXCIX"));
		assertEquals(599, parser.parse("DXCIX"));
	}

	@Test
	public void testInvalidNumeral() {
		assertEquals(99, parser.parse("IC"));
	}

}

package com.reversestring.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.reversestring.ReverseString;

public class TestReverseString {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void testReverse() {
		assertEquals("naneR", ReverseString.reverse("Renan"));
		assertEquals("siahT", ReverseString.reverse("Thais"));
	}

	@Test
	public void testReverseRule() {
		error.checkThat(ReverseString.reverse("Renan"), equalTo("naneR"));
		error.checkThat(ReverseString.reverse("Thais"), equalTo("siahT"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testReverseException() {
		ReverseString.reverse("");
	}

	@Test
	public void testReverseRobust() {
		try {
			ReverseString.reverse("");
		} catch (RuntimeException e) {
			assertThat(e.getMessage(), equalTo("The input cannot be empty or null."));
			assertThat(e.getMessage(), not(""));
		}
	}

}

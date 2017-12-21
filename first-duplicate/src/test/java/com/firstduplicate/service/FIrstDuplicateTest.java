package com.firstduplicate.service;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class FIrstDuplicateTest {

	@Test
	public void testFirstDuplicate() {
		assertThat(FirstDuplicate.find(new int[] { 1, 3, 4, 6, 1, 4, 3 }), equalTo(1));
		assertThat(FirstDuplicate.find(new int[] { 3, 4, 6, 1, 4, 3 }), equalTo(4));
		assertThat(FirstDuplicate.find(new int[] { 4, 6, 1, 4, 3 }), equalTo(4));
	}

	@Test(expected = RuntimeException.class)
	public void testFail() {
		FirstDuplicate.find(new int[] { 1, 2, 3, 5, 6, 7, 8 });
	}

}

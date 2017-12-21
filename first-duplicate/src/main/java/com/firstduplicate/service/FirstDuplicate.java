package com.firstduplicate.service;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {

	
	public static int find(int[] is) {
		Set<Integer> notDuplicateSet = new HashSet<>();
		for (Integer number : is) {
			if(!notDuplicateSet.add(number)) {
				return number; 
			}
		}
		
		throw new RuntimeException("There is no duplicate numbers!");
	}
	
}

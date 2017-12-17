package com.parser;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralParser {

	public static final Map<String, Integer> mapNumeralsRomans = new HashMap<>();
	static {
		mapNumeralsRomans.put("I", 1);
		mapNumeralsRomans.put("V", 5);
		mapNumeralsRomans.put("X", 10);
		mapNumeralsRomans.put("L", 50);
		mapNumeralsRomans.put("C", 100);
		mapNumeralsRomans.put("D", 500);
		mapNumeralsRomans.put("M", 1000);
		mapNumeralsRomans.put("IV", 4);
		mapNumeralsRomans.put("IX", 9);
		mapNumeralsRomans.put("XL", 40);
		mapNumeralsRomans.put("XC", 90);
		mapNumeralsRomans.put("CD", 400);
		mapNumeralsRomans.put("CM", 900);
	}

//	public int parse(String number) {
//		int total = 0;
//		String[] arrayRoman = number.split("");
//
//		int index = 0;
//		while (index < arrayRoman.length) {
//			if (index > 0) {
//				if (mapNumeralsRomans.get(arrayRoman[index - 1]) < mapNumeralsRomans.get(arrayRoman[index])) {
//					if (mapNumeralsRomans.get(arrayRoman[index - 1].concat(arrayRoman[index])) == null) {
//						throw new IllegalArgumentException("Invalid number");
//					}
//					total += mapNumeralsRomans.get(arrayRoman[index]) - mapNumeralsRomans.get(arrayRoman[index - 1])
//							- mapNumeralsRomans.get(arrayRoman[index - 1]);
//				} else {
//					total += mapNumeralsRomans.get(arrayRoman[index]);
//				}
//			} else {
//				total = mapNumeralsRomans.get(arrayRoman[index]);
//			}
//			index++;
//		}
//		return total;
//	}

	public int parse(String number) {
		String[] numbers = number.split("");
		int total = 0;
		int diff;
		int current;
		int next;
		for (int i = 0; i < numbers.length; i++) {
			diff = 0;
			current = mapNumeralsRomans.get(numbers[i]);
			next = mapNumeralsRomans.get(numbers[i + 1]);
			if (numbers.length - i >= 2 && current < next) {
				diff = next - current;
				total += diff;
				++i;
				continue;
			}
			total += mapNumeralsRomans.get(numbers[i]);
		}
		return total;
	}

}

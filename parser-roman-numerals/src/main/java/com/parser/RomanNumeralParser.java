package com.parser;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralParser {

	private static final Map<String, Integer> mapNumeralsRomans = new HashMap<>();
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

	public int parse(String number) {
		String[] romanNumerals = number.split("");
		int total = 0;
		for (int i = 0; i < romanNumerals.length; i++) {
			if (romanNumerals.length - i >= 2 && mapNumeralsRomans.get(romanNumerals[i]) < mapNumeralsRomans.get(romanNumerals[i + 1])) {
				total += getBase10Number(romanNumerals[i].concat(romanNumerals[i + 1]));
				++i;
				continue;
			}
			total += mapNumeralsRomans.get(romanNumerals[i]);
		}
		return total;
	}

	private Integer getBase10Number(String number) {
		if (mapNumeralsRomans.get(number) == null)
			throw new IllegalArgumentException("Invalid roman numeral.");
		return mapNumeralsRomans.get(number);
	}
}

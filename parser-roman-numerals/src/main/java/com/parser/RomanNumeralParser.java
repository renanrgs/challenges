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
		mapNumeralsRomans.put("XL", 10);
		mapNumeralsRomans.put("XC", 50);
		mapNumeralsRomans.put("CD", 100);
		mapNumeralsRomans.put("CM", 900);
		mapNumeralsRomans.put("M", 1000);
	}

	public int parse(String number) {
		int total = 0;
		String[] arrayRoman = number.split("");

		int index = 0;
		while (index < arrayRoman.length) {
			if (index > 0) {
				if (mapNumeralsRomans.get(arrayRoman[index - 1]) < mapNumeralsRomans.get(arrayRoman[index])) {
					if(mapNumeralsRomans.get(arrayRoman[index - 1].concat(arrayRoman[index])) == null) {
						throw new IllegalArgumentException("Invalid number");
					}
					total += mapNumeralsRomans.get(arrayRoman[index]) - mapNumeralsRomans.get(arrayRoman[index - 1])
							- mapNumeralsRomans.get(arrayRoman[index - 1]);
				} else {
					total += mapNumeralsRomans.get(arrayRoman[index]);
				}
			} else {
				total = mapNumeralsRomans.get(arrayRoman[index]);
			}
			index++;
		}
		return total;
	}

}

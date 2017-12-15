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
	}

	public int parse(String number) {
		int total = 0;
		String[] arrayRoman = number.split("");

		int index = 0;

		while (index < arrayRoman.length) {
			if (index > 0) {
				
				if (mapNumeralsRomans.get(arrayRoman[index - 1]) < mapNumeralsRomans.get(arrayRoman[index])) {
					total += mapNumeralsRomans.get(arrayRoman[index]) - mapNumeralsRomans.get(arrayRoman[index - 1]) - mapNumeralsRomans.get(arrayRoman[index - 1]);
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
//When does a number has the same dozens another one
	// MCMXCIX
	public static int subtract(Integer[] numero) {
		int total = 0;
		Integer prev = numero[0];
		for (int i = 0; i < numero.length; i++) {
			if (numero[i] > prev) {
				total = total + (numero[i] - prev);
			} else {
				total += numero[i];
			}
			prev = numero[i];

		}
		return total;

	}

}

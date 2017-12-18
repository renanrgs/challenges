package com.reversestring;

public class ReverseString {

	// Renan
	public static String reverse(String s) {
		char[] letters = s.toCharArray();
		char aux;
		for (int i = 0, j = letters.length - 1; i < letters.length/2; i++, j--) {
			aux = letters[i];
			letters[i] = letters[j];
			letters[j] = aux;
		}
		return String.valueOf(letters);
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("Thais"));
	}
}

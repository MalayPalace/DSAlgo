package com.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] values = new int[] { 20, -5, 7, -11, -22, 45 };

		int count = 0; // To compare between Shell Sort & Insertion Sort

		// Insertion Sort
		for (int i = 1; i < values.length; i++) {

			int element = values[i];

			int k = (i - 1);
			while (k >= 0 && values[k] > element) {
				values[k + 1] = values[k];
				count++;
				k--;
			}
			values[k + 1] = element;
		}

		System.out.println("Number of passes: " + count);
		// Print
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
}

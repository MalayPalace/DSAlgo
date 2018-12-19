package com.sort;

public class ShellSort {

	public static void main(String[] args) {
		// Modified Insertion Sort
		int[] values = new int[] { 20, -5, 7, -11, -22, 45 };

		int count = 0; // To compare between Shell Sort & Insertion Sort

		// Shell Sort
		int jump = values.length / 2;
		for (int y = jump; y > 0; y = y / 2) {

			for (int i = y; i < values.length; i++) {

				int element = values[i];

				int k = (i - y);
				while (k >= 0 && values[k] > element) {
					values[k + y] = values[k];
					count++;
					k -= y;
				}
				values[k + y] = element;
			}
		}

		System.out.println("Number of passes: " + count);
		// Print
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
}

package com.sort;

public class CountingSort {

	public static void main(String[] args) {
		// Array to be sorted
		int[] values = new int[] { 2, 5, 7, 1, 9, 4, 2 };

		// Assumption to be made
		int min = 1;
		int max = 9;

		int[] countArray = new int[(max - min) + 1];

		// Counting phase
		for (int i = 0; i < values.length; i++) {
			countArray[values[i] - min]++;
		}

		// Writing phase
		int j = 0;
		for (int i = 0; i < countArray.length; i++) {
			while (countArray[i] > 0) {
				values[j++] = i + min;
				countArray[i]--;
			}
		}

		printArray(values);
	}

	private static void printArray(int[] values) {
		System.out.print("[");
		for (int i = 0; i < values.length; i++) {
			System.out.print((i == 0 ? values[i] : ", " + values[i]));
		}
		System.out.println("]");
	}
}

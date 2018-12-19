package com.sort;

public class SelectionSort {

	public static void main(String[] args) {

		int[] values = new int[] { 20, -5, 7, -11, -22, 45 };

		// Selection Sort
		for (int i = values.length - 1; i > 0; i--) {
			int index = i;
			for (int j = 0; j < i; j++) {
				if (values[j] > values[index]) {
					index = j;
				}
			}
			swap(values, i, index);
		}

		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}

	public static void swap(int[] values, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}
}

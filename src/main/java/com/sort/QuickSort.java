package com.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] values = new int[] { 20, -5, 7, -11, -12, 8, 47, -76 };

		quickSort(values, 0, values.length);

		printArray(values);
	}

	public static void quickSort(int[] values, int start, int end) {
		if ((end - start) < 2) {
			return;
		}

		int pivot = merge(values, start, end);
		// Left partition
		quickSort(values, start, pivot);
		// Right Partition
		quickSort(values, pivot + 1, end);
	}

	private static int merge(int[] values, int start, int end) {
		int i = start;
		int j = end;
		int pivot = values[i];

		while (i < j) {
			// Find first small value as compared to pivot from right hand side
			while (i < j && values[--j] >= pivot)
				;
			if (i < j) {
				values[i] = values[j];
			}

			// Find first large value as compared to pivot from left hand side
			while (i < j && values[++i] <= pivot)
				;
			if (i < j) {
				values[j] = values[i];
			}
		}

		values[j] = pivot;
		return j;
	}

	private static void printArray(int[] values) {
		System.out.print("[");
		for (int i = 0; i < values.length; i++) {
			System.out.print((i == 0 ? values[i] : ", " + values[i]));
		}
		System.out.println("]");
	}
}

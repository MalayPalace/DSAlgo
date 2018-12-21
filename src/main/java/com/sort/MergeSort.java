package com.sort;

public class MergeSort {

	public static void main(String[] args) {
		// int[] values = new int[] { 20, -5, 7, -11, -22, 45 };
		int[] values = new int[] { 20, -5, 7, -11, -12, 8, 47, -76 };

		mergeSort(values, 0, values.length);
		printArray(values);
	}

	private static void mergeSort(int[] values, int start, int end) {
		if ((end - start) < 2) {
			return;
		}

		// breaking index
		int index = (end - start) / 2;
		// left side
		mergeSort(values, start, start + index);
		// right side
		mergeSort(values, start + index, end);

		merge(values, start, start + index, end);
	}

	private static void merge(int[] values, int start, int middle, int end) {
		if (values[middle - 1] < values[middle]) {
			return;
		}

		int i = start;
		int j = middle;
		int[] temp = new int[end - start];
		int tempIndex = 0;

		while (i < middle && j < end) {

			while (i < middle && values[i] <= values[j]) {
				temp[tempIndex++] = values[i];
				i++;
			}
			while (j < end && values[j] <= values[i]) {
				temp[tempIndex++] = values[j];
				j++;
			}
		}

		while (i < middle) {
			temp[tempIndex++] = values[i];
			i++;
		}

		System.arraycopy(temp, 0, values, start, tempIndex);
		// printArray(values);
	}

	private static void printArray(int[] values) {
		System.out.print("[");
		for (int i = 0; i < values.length; i++) {
			System.out.print((i == 0 ? values[i] : ", " + values[i]));
		}
		System.out.println("]");
	}
}

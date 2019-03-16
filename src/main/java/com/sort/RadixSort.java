/***********************************
 * DSAlgo Project
 * Filename: RadixSort.java
 * Author : MalayPalace
 * Date : 16-Mar-2019
 * 
 **********************************/
package com.sort;

public class RadixSort {

	public static void main(String[] args) {
		int[] values = new int[] { 2122, 3412, 1122, 6712, 7217 };

		// Assuming radix
		int radix = 10;
		// Assuming width is consistent across all values
		int width = 4;

		// RadixSort
		for (int i = 0; i < width; i++) {
			new RadixSort().radixSort(values, radix, i);
		}

		printArray(values);
	}

	public void radixSort(int[] values, int radix, int position) {
		// Counting Array
		int[] countingArr = new int[radix];
		for (int i = 0; i < values.length; i++) {
			countingArr[getDigit(values[i], radix, position)]++;
		}

		// Incrementing Counting Array
		for (int i = 1; i < radix; i++) {
			countingArr[i] += countingArr[i - 1];
		}

		// Sort based on position into temp array
		int[] temp = new int[values.length];
		for (int i = (values.length - 1); i >= 0; i--) {
			temp[--countingArr[getDigit(values[i], radix, position)]] = values[i];
		}

		// Copy back to original array
		for (int i = 0; i < values.length; i++) {
			values[i] = temp[i];
		}
	}

	private int getDigit(int value, int radix, int position) {
		return (value / ((int) Math.pow(10, position)) % 10);
	}

	private static void printArray(int[] values) {
		System.out.print("[");
		for (int i = 0; i < values.length; i++) {
			System.out.print((i == 0 ? values[i] : ", " + values[i]));
		}
		System.out.println("]");
	}
}

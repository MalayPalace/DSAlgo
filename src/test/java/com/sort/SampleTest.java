/***********************************
 * DSAlgo Project
 * Filename: SampleTest.java
 * Author : MalayPalace
 * Date : 17-Mar-2019
 * 
 **********************************/
package com.sort;

public class SampleTest {

	public static void main(String[] args) {
		int value = 43215678;
		for (int i = 0; i < 8; i++) {
			System.out.println(value / ((int) Math.pow(10, i)) % 10);
		}
	}
}

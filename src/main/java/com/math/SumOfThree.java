/***********************************
 * DSAlgo Project
 * Filename: SumOfThree.java
 * Author : malay
 * Date : 28-Mar-2020
 * 
 **********************************/
package com.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfThree {

	private Set<Value> mapper = new HashSet<>();

	public static void main(String[] args) {
		// Inputs
		//Integer[] array = { 3, 5, 7, 10, 12, 2, 14 };
		//Integer result = 28;
		Integer[] array = { 2, 4, 9, 8, 7, 6 };
		Integer result = 19;

		SumOfThree obj = new SumOfThree();
		List<Integer> output = obj.process(array, result);
		if (output != null) {
			System.out.println("Resultant Numbers:" + output);
		} else {
			System.out.println("No Result");
		}
		System.out.println();
		System.out.println(obj.mapper.size());
	}

	private List<Integer> process(Integer[] array, Integer result) {
		for (Integer i : array) {

			Set<Value> temp = new HashSet<>();
			for (Value value : mapper) {
				Integer newSum = value.getSum() + i;
				Integer newCount = value.getCount() + 1;
				List<Integer> newNos = value.getNumbers();
				newNos.add(i);

				// Check whether we find the result
				if (result.equals(newSum) && newCount == 3) {
					return newNos;
				}

				// Space Optimization remove invalid Entries
				if (newSum > result || newCount == 3) {
					continue;
				}
				temp.add(new Value(newNos, newSum, newCount));
			}

			// Copy over temp to main
			mapper.addAll(temp);

			// Add the new number
			mapper.add(new Value(i));
		}
		return null;
	}
}

class Value {
	private List<Integer> numbers = new ArrayList<Integer>();
	private Integer count;
	private Integer sum;

	public Value(Integer number) {
		numbers.add(number);
		sum = number;
		count = 1;
	}

	public Value(List<Integer> numbers, Integer sum, Integer count) {
		this.numbers = numbers;
		this.sum = sum;
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Integer> getNumbers() {
		return new ArrayList<Integer>(numbers);
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Override
	public int hashCode() {
		return sum + count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Value other = (Value) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (sum == null) {
			if (other.sum != null)
				return false;
		} else if (!sum.equals(other.sum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Value [numbers=" + numbers + ", count=" + count + ", sum=" + sum + "]\n";
	}
}

/***********************************
 * DSAlgo Project
 * Filename: Heap.java
 * Author : malay
 * Date : 01-Aug-2020
 * 
 **********************************/
package com.heap;

/**
 * Max Heap Implementation
 * 
 * @author malay
 *
 */
public class Heap {

	private int[] arr;
	private int size = 0;
	private int capacity;

	public Heap(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
	}

	private boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	private boolean isFull() {
		if (size >= capacity) {
			return true;
		}
		return false;
	}

	public void insert(int value) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Heap is Full");
		}
		if (isEmpty()) {
			arr[size++] = value;
			return;
		}

		arr[size++] = value;
		fixHeapAbove(size - 1, value);
	}

	public int remove(int index) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is Empty");
		}

		int deletedValue = arr[index];
		if (index < size) {
			// For delete replace it with last element
			arr[index] = arr[size - 1];

			// arr[size-1] = null; // incase of object remove the reference
			size--;

			if (index == 0 || arr[index] < arr[getParentIndex(index)]) {
				fixHeapBelow(index, size);
			} else {
				fixHeapAbove(index, arr[index]);
			}
		} else {
			throw new IndexOutOfBoundsException("Heap size is:" + size);
		}
		return deletedValue;
	}

	private void fixHeapAbove(int i, int value) {
		int parent = -1;
		int current = i;
		do {
			parent = getParentIndex(current);
			if (arr[current] > arr[parent]) {
				arr[current] = arr[parent];
				arr[parent] = value;
			} else {
				break;
			}
			current = parent;
		} while (parent > 0);
	}

	private void fixHeapBelow(int i, int lastIndex) {
		while (i < lastIndex) {
			int leftChildIndex = getChildIndex(i, true);
			int rightChildIndex = getChildIndex(i, false);

			int indexToSwap = -1;

			if (leftChildIndex < lastIndex) {
				if (rightChildIndex < lastIndex) {
					indexToSwap = (arr[leftChildIndex] < arr[rightChildIndex] ? rightChildIndex : leftChildIndex);
				} else { // only left - no right child
					indexToSwap = leftChildIndex;
				}
			} else {
				break;
			}

			// Actual swap
			if (indexToSwap != -1 && arr[i] < arr[indexToSwap]) {
				int temp = arr[i];
				arr[i] = arr[indexToSwap];
				arr[indexToSwap] = temp;
			}

			i = indexToSwap;
		}
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private int getChildIndex(int parentIndex, boolean isLeftChild) {
		return 2 * parentIndex + (isLeftChild ? 1 : 2);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			s.append(arr[i]);
			if (i != (size - 1)) {
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}
}

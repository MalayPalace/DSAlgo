package com.list;

import java.util.LinkedList;
import java.util.ListIterator;

public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E> {

	private static final long serialVersionUID = 3L;

	@Override
	public boolean add(E e) {
		if (this.isEmpty()) {
			super.add(e);
			return true;
		}
		ListIterator<E> iterate = this.listIterator();
		E value = null;
		while (iterate.hasNext()) {
			if ((value = iterate.next()) == null || value.compareTo(e) >= 1) {
				iterate.previous();
				iterate.add(e);
				return true;
			}
		}
		return super.add(e);
	}
}

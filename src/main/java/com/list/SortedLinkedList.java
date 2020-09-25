package com.list;

import java.util.LinkedList;
import java.util.ListIterator;

public class SortedLinkedList extends LinkedList<Long> {

	private static final long serialVersionUID = 3L;
	public int iter = 0;

	@Override
	public boolean add(Long e) {
		if (this.isEmpty()) {
			super.add(e);
			return true;
		}
		Long max = this.getLast();
		Long min = this.getFirst();
		long forwardDist = e - min;
		long backwardDist = max - e;
		boolean forwardFlag = (forwardDist <= backwardDist ? true : false);
		Long value = null;
		if (forwardFlag) {
			ListIterator<Long> iterate = this.listIterator();
			while (iterate.hasNext()) {
				iter++;
				if ((value = iterate.next()) == null || value.compareTo(e) >= 1) {
					iterate.previous();
					iterate.add(e);
					return true;
				}
			}
		} else {
			ListIterator<Long> iterate = this.listIterator(this.size());
			while (iterate.hasPrevious()) {
				iter++;
				if ((value = iterate.previous()) == null || value.compareTo(e) < 1) {
					iterate.next();
					iterate.add(e);
					return true;
				}
			}
		}
		return super.add(e);
	}
}

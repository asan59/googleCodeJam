package org.sezavar.datastructure;

public class MaxPriorityQueueBasedOnHeap<T extends Prioritizable & Indexable> {
	private Object[] mem;

	public MaxPriorityQueueBasedOnHeap(int capcity) {
		this.mem = new Object[capcity];
	}

	public void insert(T item) {

	}

	public T getMaximum() {
		return null;
	}

	public T extractMaximum() {
		return null;
	}

	public void increaseKey(T item) {
		int index = item.getIndex();
		
	}
}

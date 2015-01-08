package org.sezavar.datastructure.linklist;

public abstract class LinkedList<T> {
	public abstract void insert(T value);

	public abstract void remove(LinkedListElement<T> element);

	public abstract LinkedListElement<T> search(T value);

	public void remove(T value) {
		this.remove(this.search(value));
	}

}

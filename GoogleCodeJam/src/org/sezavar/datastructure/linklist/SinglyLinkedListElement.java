package org.sezavar.datastructure.linklist;

public interface SinglyLinkedListElement<T> extends LinkedListElement<T>{
	public abstract void setPrev(DoublyLinkedListElement<T> prev);

	public abstract DoublyLinkedListElement<T> getPrev();
}

package org.sezavar.datastructure.linklist;

public interface DoublyLinkedListElement<T> extends SinglyLinkedListElement<T> {

	public abstract void setNext(DoublyLinkedListElement<T> next);

	public abstract DoublyLinkedListElement<T> getNext();

}

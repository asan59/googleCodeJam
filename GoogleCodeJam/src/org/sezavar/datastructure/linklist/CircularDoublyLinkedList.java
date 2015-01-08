package org.sezavar.datastructure.linklist;

public class CircularDoublyLinkedList<T> extends LinkedList<T> {
	private SpaceManagerInterface<DoublyLinkedListElement<T>> spaceManger;
	private DoublyLinkedListElement<T> sentinel;
private 
	
	public CircularDoublyLinkedList(
			SpaceManagerInterface<DoublyLinkedListElement<T>> spaceManger) {
		this.spaceManger = spaceManger;
		this.sentinel.setValue(null);
		this.sentinel.setNext(this.sentinel);
		this.sentinel.setPrev(this.sentinel);
	}

	@Override
	public void insert(T value) {
		DoublyLinkedListElement<T> elementToInsert = new DoublyLinkedListOneArrayImp<>();
		elementToInsert.setNext(this.sentinel.getNext());
		elementToInsert.setPrev(this.sentinel);
		this.sentinel.getNext().setPrev(elementToInsert);
		this.sentinel.setNext(elementToInsert);
	}

	@Override
	public void remove(LinkedListElement<T> element) {
		DoublyLinkedListElement<T> elementToRemove = (DoublyLinkedListElement<T>) element;
		elementToRemove.getPrev().setNext(elementToRemove.getNext());
		elementToRemove.getNext().setPrev(elementToRemove.getPrev());
	}

	@Override
	public LinkedListElement<T> search(T value) {
		DoublyLinkedListElement<T> element = this.sentinel.getNext();
		while (!element.equals(this.sentinel)) {
			if (element.getValue().equals(value)) {
				return element;
			}
			element = element.getNext();
		}
		return null;
	}

}

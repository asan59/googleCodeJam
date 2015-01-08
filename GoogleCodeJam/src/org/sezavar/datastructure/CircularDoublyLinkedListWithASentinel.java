package org.sezavar.datastructure;

import org.sezavar.datastructure.DoublyLinkedList.Element;

public class CircularDoublyLinkedListWithASentinel<T> {
	private Element<T> sentinal = null;

	public CircularDoublyLinkedListWithASentinel() {
		this.sentinal = new Element<>();
		this.sentinal.value = null;
		this.sentinal.next = this.sentinal;
		this.sentinal.prev = this.sentinal;
	}

	public void insert(T value) {
		Element<T> elementToInsert = new Element<>(value);
		elementToInsert.next = this.sentinal.next;
		elementToInsert.prev = this.sentinal;
		this.sentinal.next.prev = elementToInsert;
		this.sentinal.next = elementToInsert;
	}

	public void remove(T value) {
		this.remove(this.search(value));
	}

	public void remove(Element<T> e) {
		if (e != null) {
			e.prev.next = e.next;
			e.next.prev = e.prev;
		}
	}

	public Element<T> search(T value) {
		Element<T> element = sentinal.next;
		while (!element.equals(sentinal)) {
			if (element.value.equals(value)) {
				return element;
			}
			element = element.next;
		}
		return null;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Element<T> element = sentinal.next;
		while (!element.equals(sentinal)) {
			sb.append("[" + element.prev + "|" + element.value + "|"
					+ element.next + "]\n");
			element = element.next;
		}
		return sb.toString();
	}

	public class Element<T> {
		private Element<T> prev = null;
		private Element<T> next = null;
		private T value = null;

		public Element() {

		}

		public Element(T value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		CircularDoublyLinkedListWithASentinel<Integer> list = new CircularDoublyLinkedListWithASentinel<>();
		list.insert(0);
		list.insert(1);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		System.out.println(list);
		System.out.println("-----------");
		list.remove(0);
		list.remove(5);
		System.out.println(list);
		System.out.println("-----------");
		list.insert(5);
		list.remove(3);
		System.out.println(list);
	}
}

package org.sezavar.datastructure;

public class DoublyLinkedList<T> {
	private Element<T> head = null;

	public void insert(T value) {
		Element<T> elementToInsert = new Element<>(value);
		if (this.head != null) {
			this.head.prev = elementToInsert;
		}
		elementToInsert.next = this.head;
		elementToInsert.prev = null;
		this.head = elementToInsert;

	}

	public void remove(Element<T> e) {
		if (e != null) {
			if (e.prev != null)
				e.prev.next = e.next;
			else
				// so important to change head if we are removing head
				this.head = e.next;
			if (e.next != null)
				e.next.prev = e.prev;
		}
	}

	public void remove(T value) {
		this.remove(this.search(value));
	}

	public Element<T> search(T value) {
		Element<T> element = this.head;
		while (element != null) {
			if (element.value.equals(value))
				return element;
			element = element.next;
		}
		return null;
	}

	public class Element<T> {
		private T value = null;
		private Element<T> prev = null;
		private Element<T> next = null;

		public Element(T value) {
			this.value = value;
		}

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Element<T> element = this.head;
		while (element != null) {
			sb.append("[" + element.prev + "|" + element.value + "|"
					+ element.next + "]\n");
			element = element.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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

package org.sezavar.datastructure.linklist;

public class OneArrayBaseForDoublyLinkedList<T> {
	private Object[] base;

	public OneArrayBaseForDoublyLinkedList() {
		this.base = new Object[10];
	}

	public class DoublyLinkedListOneArrayImp<T> implements
			DoublyLinkedListElement<T> {
		private Integer index;

		public DoublyLinkedListOneArrayImp(int index) {
			this.index = index;

		}

		@Override
		public void setPrev(DoublyLinkedListElement<T> prev) {
			int prevIndex = ((DoublyLinkedListOneArrayImp<T>) prev).index;
			base[index - 1] = prevIndex;
		}

		@Override
		public DoublyLinkedListElement<T> getPrev() {
			int prevIndex = (int) base[index - 1];
			if (prevIndex == -1)
				return null;
			return new DoublyLinkedListOneArrayImp<>(prevIndex);
		}

		@Override
		public T getValue() {
			return (T) base[index];
		}

		@Override
		public void setValue(T value) {
			base[index] = value;

		}

		@Override
		public void setNext(DoublyLinkedListElement<T> next) {
			int nextIndex = ((DoublyLinkedListOneArrayImp<T>) next).index;
			base[index + 1] = nextIndex;
		}

		@Override
		public DoublyLinkedListElement<T> getNext() {
			int nextIndex = (int) base[index + 1];
			if (nextIndex == -1)
				return null;
			return new DoublyLinkedListOneArrayImp<>(nextIndex);
		}

	}

}

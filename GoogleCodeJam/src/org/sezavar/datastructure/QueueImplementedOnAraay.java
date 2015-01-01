package org.sezavar.datastructure;

import java.time.temporal.IsoFields;

import org.sezavar.datastructure.exception.OverFlowException;
import org.sezavar.datastructure.exception.UnderFlowException;

public class QueueImplementedOnAraay<T> {
	private Object[] array;
	private int head = 0;
	private int tail = 0;
	private boolean isQueueEmpty = true;
	public final static int DEFAULT_LENGTH = 5;

	public QueueImplementedOnAraay(int length) {
		this.array = new Object[length];
	}

	public QueueImplementedOnAraay() {
		this(DEFAULT_LENGTH);
	}

	public void enqueue(T value) throws OverFlowException {
		if (isFull()) {
			throw new OverFlowException();
		}
		this.array[tail] = value;
		this.tail = (this.tail + 1) % this.array.length;
		this.isQueueEmpty = false;
		System.out.println("enqueue " + value);
	}

	public T dequeue() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}
		T value = (T) this.array[this.head];
		this.head = (this.head + 1) % this.array.length;
		if (this.head == this.tail) {
			this.isQueueEmpty = true;
		}
		System.out.println("dequeue " + value);
		return value;
	}

	private boolean isFull() {
		if (this.head == this.tail && !this.isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isEmpty() {
		return isQueueEmpty;
	}

	public static void main(String[] args) {
		QueueImplementedOnAraay<Integer> queue = new QueueImplementedOnAraay<>();
		for (int i = 0; i < 6; i++) {
			try {
				queue.enqueue(i);
			} catch (OverFlowException e) {
				System.out.println("overflow");
			}
		}
		for (int i = 0; i < 6; i++) {
			try {
				queue.dequeue();
			} catch (UnderFlowException e) {
				System.out.println("underflow");
			}
		}
		for (int i = 0; i < 6; i++) {
			try {
				queue.enqueue(i * 5);
			} catch (OverFlowException e) {
				System.out.println("overflow");
			}
		}
		for (int i = 0; i < 6; i++) {
			try {
				queue.dequeue();
			} catch (UnderFlowException e) {
				System.out.println("underflow");
			}
		}
		for (int i = 0; i < 3; i++) {
			try {
				queue.enqueue(i * 10);
			} catch (OverFlowException e) {
				System.out.println("overflow");
			}
		}
		for (int i = 0; i < 5; i++) {
			try {
				queue.dequeue();
			} catch (UnderFlowException e) {
				System.out.println("underflow");
			}
		}

	}
}

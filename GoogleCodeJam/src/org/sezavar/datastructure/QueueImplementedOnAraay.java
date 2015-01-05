package org.sezavar.datastructure;

import org.sezavar.datastructure.exception.OverFlowException;
import org.sezavar.datastructure.exception.UnderFlowException;

/**
 * @author amir<br>
 *         This is an implementation of queue using array, for array with length
 *         of n, the queue capacity would be n-1<br>
 *         if head==tail => queue is empty<br>
 *         if head==tail+1 => queue is full<br>
 * 
 * 
 * @param <T>
 */
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
		int newTail = (this.tail + 1) % this.array.length;
		if (newTail == this.head) {
			throw new OverFlowException();
		} else {
			System.out.println("enqueue: " + value);
			this.array[tail] = value;
			this.tail = newTail;
		}
	}

	public T dequeue() throws UnderFlowException {
		if (this.head == this.tail) {
			throw new UnderFlowException();
		} else {
			T value = (T) this.array[head];
			this.head = (this.head + 1) % this.array.length;
			System.out.println("dequeue: " + value);
			return value;
		}
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

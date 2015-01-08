package org.sezavar.datastructure;

import java.util.Arrays;

public class Heap {
	private int[] mem;
	private int heapSize;

	public Heap(int[] mem) {
		super();
		this.mem = mem;

	}

	public int getRight(int index) {
		return 2 * index + 1;
	}

	public int getLeft(int index) {
		return 2 * index;
	}

	public int getParent(int index) {
		return index / 2;
	}

	public void heapify(int index) {
		int leftIndex = this.getLeft(index);
		int rightIndex = this.getRight(index);
		int largest = index;
		if (leftIndex < this.heapSize && mem[largest] < mem[leftIndex]) {
			largest = leftIndex;
		}
		if (rightIndex < this.heapSize && mem[largest] < mem[rightIndex]) {
			largest = rightIndex;
		}
		if (largest != index) {
			swap(largest, index);
			heapify(largest);
		}
	}

	private void swap(int iIndex, int jIndex) {
		int temp = mem[iIndex];
		mem[iIndex] = mem[jIndex];
		mem[jIndex] = temp;
	}

	public void buildHeap() {
		this.heapSize = mem.length;
		int indexToStart = (this.mem.length - 1) / 2;
		for (int i = indexToStart; i >= 0; i--) {
			heapify(i);
		}
	}

	public void sort() {
		this.buildHeap();
		for (int i = this.mem.length - 1; i > 0; i--) {
			swap(0, i);
			heapSize--;
			heapify(0);
		}
	}

	public int[] getMem() {
		return mem;
	}

	public static void main(String[] args) {
		int[] arrayToSort = new int[] { 3, 4, 1, 10, 15, 12, 0, -1, 23, 2, 6,
				0, 5, 8, 7 };
		System.out.println(Arrays.toString(arrayToSort));
		Heap heap = new Heap(arrayToSort);
		heap.sort();
		System.out.println(Arrays.toString(heap.getMem()));
	}
}

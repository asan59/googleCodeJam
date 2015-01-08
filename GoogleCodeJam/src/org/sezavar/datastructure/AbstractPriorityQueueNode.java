package org.sezavar.datastructure;

public abstract class AbstractPriorityQueueNode implements Prioritizable,
		Indexable {
	private int index;

	@Override
	public void setIndex(int index) {
		this.index = index;

	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public abstract int getPriority();

}

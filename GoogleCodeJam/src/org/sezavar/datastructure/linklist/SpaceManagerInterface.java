package org.sezavar.datastructure.linklist;

public interface SpaceManagerInterface<K extends LinkedListElement> {
	public K allocate();

	public void mallocate(K element);

	public void init();
}

package com.codr.framework.LinkedList;

/**
 * Interface for LL.
 */
public interface LinkedList<T> {

    /**
     * Reverses a linked list recursively.
     * @param head
     * @return
     */
    T reverse();

    /**
     * Prints the nodes in the linkedList.
     */
    void print();

    /**
     * Returns the middle of linked list.
     * @return
     */
    T middle();

}

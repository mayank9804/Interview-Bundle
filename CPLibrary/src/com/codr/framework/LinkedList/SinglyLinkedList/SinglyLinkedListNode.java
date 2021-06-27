package com.codr.framework.LinkedList.SinglyLinkedList;

/**
 * Represents a node which can be used for Singly Linked List.
 * @param <T>
 */
public class SinglyLinkedListNode<T> {
    public T item;
    public SinglyLinkedListNode<T> next;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public SinglyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }

    public SinglyLinkedListNode(T item, SinglyLinkedListNode<T> next) {
        this.item = item;
        this.next = next;
    }

    public SinglyLinkedListNode(T item) {
        this.item = item;
    }

    public SinglyLinkedListNode(SinglyLinkedListNode<T> next) {
        this.next = next;
    }

    public SinglyLinkedListNode() { }

    public static SinglyLinkedListNode fromInteger(int item) {
        return new SinglyLinkedListNode<>(item, null);
    }
}

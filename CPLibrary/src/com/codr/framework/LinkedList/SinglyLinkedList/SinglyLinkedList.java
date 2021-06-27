package com.codr.framework.LinkedList.SinglyLinkedList;

import com.codr.framework.LinkedList.LinkedList;

import java.util.Objects;

/**
 * Represents Singly Linked List.
 * A singly linked list is the list which can be iterated in only one direction.
 * @param <T>
 */
public class SinglyLinkedList<T> implements LinkedList<SinglyLinkedListNode<T>> {
    public SinglyLinkedListNode<T> head;

    public SinglyLinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(SinglyLinkedListNode<T> head) {
        this.head = head;
    }

    public SinglyLinkedList(SinglyLinkedListNode<T> head) {
        this.head = head;
    }

    public SinglyLinkedList() { }

    /**
     * Reverses the list.
     * {@inheritDoc}
     * @param head
     * @return
     */
    @Override
    public SinglyLinkedListNode<T> reverse() {
        if (Objects.isNull(head)) return null;

        SinglyLinkedListNode<T> temp = this.head;
        SinglyLinkedListNode<T> reversedHead = recursivelyReverse(temp);
        reversedHead.next = null;

        return reversedHead;
    }

    /**
     * Reverses the list recursively.
     * {@inheritDoc}
     * @param head
     * @return
     */
    private SinglyLinkedListNode<T> recursivelyReverse(SinglyLinkedListNode<T> head) {
        if (Objects.isNull(head.next)) {
            this.head = head;
            return head;
        }
        SinglyLinkedListNode<T> nextNode = recursivelyReverse(head.next);
        nextNode.next = head;
        return head;
    }

    /**
     * Pretty prints the linked list.
     */
    @Override
    public void print() {
        SinglyLinkedListNode<T> temp = this.head;
        while (Objects.nonNull(temp)) {
            System.out.print(temp.item);
            if (Objects.nonNull(temp.next)) System.out.print("->"); // Pretty Print
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Returns the middle node.
     * If there are even nodes, then there would be two middle nodes, we need to print the second middle element.
     * @return
     */
    public SinglyLinkedListNode<T> middle() {
        if (Objects.isNull(head)) return null;

        SinglyLinkedListNode<T> slow = head;
        SinglyLinkedListNode<T> fast = head.next;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static SinglyLinkedList<Integer> fromIntegerNode(SinglyLinkedListNode<Integer> head) {
        return new SinglyLinkedList<>(head);
    }
}

package com.codr.leetcodequestions.linkedList.easy.IsPalindrome;

import com.codr.framework.LinkedList.SinglyLinkedList.SinglyLinkedList;
import com.codr.framework.LinkedList.SinglyLinkedList.SinglyLinkedListNode;
import com.codr.framework.Question;
import com.codr.leetcodequestions.linkedList.easy.IsPalindrome.data.IsPalindromeInput;
import com.codr.leetcodequestions.linkedList.easy.IsPalindrome.data.IsPalindromeOutput;

import java.util.Objects;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * Input: head = [1,2,2,1]
 * Output: true
 */
public class IsPalindrome extends Question<IsPalindromeOutput, IsPalindromeInput> {
    @Override
    public IsPalindromeOutput solve(IsPalindromeInput input) {
        SinglyLinkedListNode middle = input.list.middle();
        SinglyLinkedList list = SinglyLinkedList.fromIntegerNode(middle);
        list.reverse();
        SinglyLinkedListNode head1 = input.list.head;
        SinglyLinkedListNode head2 = list.head;
        while (Objects.nonNull(head1) && Objects.nonNull(head2) && head1.item == head2.item) {
            head1 = head1.next;
            head2 = head2.next;
        }
        IsPalindromeOutput output = new IsPalindromeOutput();
        output.isPalindrome = Objects.isNull(head1); // Checking this as for odd size list, the reversed element will have more element.
        return output;
    }

    @Override
    public IsPalindromeInput takeInput() {
        IsPalindromeInput input = new IsPalindromeInput();
        SinglyLinkedListNode node1 = SinglyLinkedListNode.fromInteger(1);
        SinglyLinkedListNode node2 = SinglyLinkedListNode.fromInteger(2);
        SinglyLinkedListNode node3 = SinglyLinkedListNode.fromInteger(2);
        SinglyLinkedListNode node4 = SinglyLinkedListNode.fromInteger(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        input.list = new SinglyLinkedList<Integer>(node1);
        return input;
    }

    @Override
    public void display(IsPalindromeOutput content) {
        System.out.println(content.isPalindrome);
    }
}
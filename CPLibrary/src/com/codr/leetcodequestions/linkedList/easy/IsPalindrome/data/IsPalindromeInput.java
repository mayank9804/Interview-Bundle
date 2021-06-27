package com.codr.leetcodequestions.linkedList.easy.IsPalindrome.data;

import com.codr.framework.LinkedList.SinglyLinkedList.SinglyLinkedList;

/**
 * Input model for {@link com.codr.leetcodequestions.linkedList.easy.IsPalindrome.IsPalindrome}.
 */
public class IsPalindromeInput {
    public SinglyLinkedList<Integer> list;

    public IsPalindromeInput() { }

    public IsPalindromeInput(SinglyLinkedList<Integer> list) {
        this.list = list;
    }
}
package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.TreeNode;

/**
 * Node implementation for Binary Search Tree.
 */
public class BinarySearchTreeNode<T extends Number> implements TreeNode {
    public T item;
    public BinarySearchTreeNode<T> left;
    public BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T item, BinarySearchTreeNode<T> left, BinarySearchTreeNode<T> right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    public BinarySearchTreeNode(T item) {
        this.item = item;
    }

    public BinarySearchTreeNode() { }

    public static BinarySearchTreeNode<Integer> fromIntegerItem(int value) {
        return new BinarySearchTreeNode<>(value, null, null);
    }
}

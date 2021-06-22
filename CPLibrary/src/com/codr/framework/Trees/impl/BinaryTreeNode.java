package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.TreeNode;

/**
 * Definition of Binary Tree Node.
 */
public class BinaryTreeNode<T extends Number> implements TreeNode {
    public T val;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode() {}

    public BinaryTreeNode(T val) {
        this.val = val;
    }

    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
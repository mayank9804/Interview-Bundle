package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.TreeNode;

/**
 * Definition of Binary Tree Node.
 */
public class BinaryTreeNode implements TreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {}

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
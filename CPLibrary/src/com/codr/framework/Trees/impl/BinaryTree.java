package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.Tree;

/**
 * Definition of BinaryTree.
 */
public class BinaryTree implements Tree {
    public BinaryTreeNode root;

    public BinaryTree() {}

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }
}

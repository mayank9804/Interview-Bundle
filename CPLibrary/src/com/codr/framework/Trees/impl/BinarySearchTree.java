package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.Tree;

/**
 * Implementation of Binary Search Trees.
 * @param <T>
 */
public class BinarySearchTree<T> implements Tree {
    public BinarySearchTreeNode<T> root;

    public BinarySearchTree(BinarySearchTreeNode<T> root) {
        this.root = root;
    }

    public BinarySearchTree() { }
}

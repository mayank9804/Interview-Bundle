package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.Tree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of Binary Search Trees.
 * @param <T>
 */
public class BinarySearchTree<T extends Number> implements Tree {
    public BinarySearchTreeNode<T> root;

    public BinarySearchTree(BinarySearchTreeNode<T> root) {
        this.root = root;
    }

    public BinarySearchTree() { }

    public List<T> preorder() {
        List<T> container = new ArrayList<>();
        preOrderHelper(this.root, container);
        return container;
    }

    public void addNode(BinarySearchTreeNode<T> newNode) {
        this.root = addNodeHelper(newNode, this.root);
    }

    private BinarySearchTreeNode<T> addNodeHelper(BinarySearchTreeNode<T> newNode, BinarySearchTreeNode<T> currentNode) {
        if (Objects.isNull(currentNode)) return newNode;
        int cmp = compare(newNode.item, currentNode.item);
        if (cmp == 1) {
            currentNode.right = addNodeHelper(newNode, currentNode.right);
        } else if (cmp == -1) {
            currentNode.left = addNodeHelper(newNode, currentNode.left);
        }
        return currentNode;
    }

    private void preOrderHelper(BinarySearchTreeNode<T> node, List<T> container) {
        if (Objects.isNull(node)) return;
        container.add(node.item);
        preOrderHelper(node.left, container);
        preOrderHelper(node.right, container);
    }

    public int compare(Number a, Number b) {
        return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
    }
}

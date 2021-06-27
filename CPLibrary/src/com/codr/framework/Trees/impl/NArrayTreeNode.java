package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.TreeNode;

import java.util.List;

/**
 * Node for NArrayTree.
 * @param <T>
 */
public class NArrayTreeNode<T> implements TreeNode {

    public T item;
    public List<NArrayTreeNode<T>> children;

    public NArrayTreeNode(T item, List<NArrayTreeNode<T>> children) {
        this.item = item;
        this.children = children;
    }

    public NArrayTreeNode(T item) {
        this.item = item;
    }

    public NArrayTreeNode(List<NArrayTreeNode<T>> children) {
        this.children = children;
    }

    public NArrayTreeNode() { }
}

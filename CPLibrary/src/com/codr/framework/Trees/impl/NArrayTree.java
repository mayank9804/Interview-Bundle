package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for NArrayTree.
 * @param <T>
 */
public class NArrayTree<T> implements Tree {
    public NArrayTreeNode root;

    public NArrayTree(NArrayTreeNode root) {
        this.root = root;
    }

    public NArrayTree() { }

    public List<T> postorder(NArrayTreeNode<T> root) {
        List<T> container = new ArrayList<>();
        getPostOrderTraversal(root, container);
        return container;
    }

    public List<T> preorder(NArrayTreeNode<T> root) {
        List<T> container = new ArrayList<>();
        getPreOrderTraversal(root, container);
        return container;
    }

    private void getPreOrderTraversal(NArrayTreeNode<T> root, List<T> container) {
        if (root == null) return;
        container.add(root.item);
        for (int i = 0; i < root.children.size(); i++ ) {
            getPreOrderTraversal(root.children.get(i), container);
        }
    }

    private void getPostOrderTraversal(NArrayTreeNode<T> root, List<T> container) {
        if (root == null) return;
        for (int i = 0; i < root.children.size(); i++ ) {
            getPostOrderTraversal(root.children.get(i), container);
        }
        container.add(root.item);
    }
}

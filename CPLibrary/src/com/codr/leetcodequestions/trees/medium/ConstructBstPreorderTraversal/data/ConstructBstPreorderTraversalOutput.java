package com.codr.leetcodequestions.trees.medium.ConstructBstPreorderTraversal.data;

import com.codr.framework.Trees.impl.BinarySearchTree;

/**
 * Output model for {@link com.codr.leetcodequestions.trees.medium.ConstructBstPreorderTraversal.ConstructBstPreorderTraversal}.
 */
public class ConstructBstPreorderTraversalOutput {
    public BinarySearchTree<Integer> tree;

    public ConstructBstPreorderTraversalOutput(BinarySearchTree<Integer> tree) {
        this.tree = tree;
    }

    public ConstructBstPreorderTraversalOutput() { }
}
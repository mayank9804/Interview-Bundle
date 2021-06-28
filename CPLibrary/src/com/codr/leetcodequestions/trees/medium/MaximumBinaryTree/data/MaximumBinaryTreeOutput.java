package com.codr.leetcodequestions.trees.medium.MaximumBinaryTree.data;

import com.codr.framework.Trees.impl.BinaryTree;

/**
 * Output model for {@link com.codr.leetcodequestions.trees.medium.MaximumBinaryTree.MaximumBinaryTree}.
 */
public class MaximumBinaryTreeOutput {
    public BinaryTree<Integer> tree;

    public MaximumBinaryTreeOutput(BinaryTree<Integer> tree) {
        this.tree = tree;
    }

    public MaximumBinaryTreeOutput() { }
}
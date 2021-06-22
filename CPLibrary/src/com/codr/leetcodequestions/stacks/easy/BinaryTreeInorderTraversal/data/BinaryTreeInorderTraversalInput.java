package com.codr.leetcodequestions.stacks.easy.BinaryTreeInorderTraversal.data;

import com.codr.framework.Trees.impl.BinaryTree;

/**
 * Input model for {@link com.codr.leetcodequestions.stacks.easy.BinaryTreeInorderTraversal.BinaryTreeInorderTraversal}.
 */
public class BinaryTreeInorderTraversalInput {
    public BinaryTree<Integer> binaryTree;

    public BinaryTreeInorderTraversalInput(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    public BinaryTreeInorderTraversalInput() { }
}
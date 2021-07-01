package com.codr.leetcodequestions.trees.medium.ExpressionTreeFromPostfix.data;

import com.codr.framework.Trees.impl.BinaryTree;

/**
 * Output model for {@link com.codr.leetcodequestions.trees.medium.ExpressionTreeFromPostfix.ExpressionTreeFromPostfix}.
 */
public class ExpressionTreeFromPostfixOutput {
    public BinaryTree<String> tree;
    public Integer result;

    public ExpressionTreeFromPostfixOutput(BinaryTree<String> tree) {
        this.tree = tree;
    }

    public ExpressionTreeFromPostfixOutput() { }
}
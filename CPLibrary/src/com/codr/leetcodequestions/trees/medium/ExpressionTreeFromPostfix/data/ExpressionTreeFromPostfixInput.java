package com.codr.leetcodequestions.trees.medium.ExpressionTreeFromPostfix.data;

import java.util.List;

/**
 * Input model for {@link com.codr.leetcodequestions.trees.medium.ExpressionTreeFromPostfix.ExpressionTreeFromPostfix}.
 */
public class ExpressionTreeFromPostfixInput {
    public List<String> postfix;

    public ExpressionTreeFromPostfixInput(List<String> postfix) {
        this.postfix = postfix;
    }

    public ExpressionTreeFromPostfixInput() { }
}
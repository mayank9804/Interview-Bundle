package com.codr.leetcodequestions.trees.medium.ExpressionTreeFromPostfix;

import com.codr.framework.Question;
import com.codr.framework.Trees.impl.BinaryTree;
import com.codr.framework.Trees.impl.BinaryTreeNode;
import com.codr.leetcodequestions.trees.medium.ExpressionTreeFromPostfix.data.ExpressionTreeFromPostfixInput;
import com.codr.leetcodequestions.trees.medium.ExpressionTreeFromPostfix.data.ExpressionTreeFromPostfixOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.
 *
 *  Postfix notation is a notation for writing arithmetic expressions in which the operands (numbers) appear before their operators.
 *  For example, the postfix tokens of the expression 4*(5-(2+7)) are represented in the array postfix = ["4","5","7","2","+","-","*"].
 *
 *  The class Node is an interface you should use to implement the binary expression tree.
 *  The returned tree will be tested using the evaluate function, which is supposed to evaluate the tree's value.
 *
 *  You should not remove the Node class; however, you can modify it as you wish,
 *  and you can define other classes to implement it if needed.
 *
 *  A binary expression tree is a kind of binary tree used to represent arithmetic expressions.
 *  Each node of a binary expression tree has either zero or two children.
 *  Leaf nodes (nodes with 0 children) correspond to operands (numbers),
 *  and internal nodes (nodes with two children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).
 *
 *  It's guaranteed that no subtree will yield a value that exceeds 109 in absolute value, and all the operations are valid (i.e., no division by zero).
 *
 *  Follow up: Could you design the expression tree such that it is more modular?
 *  For example, is your design able to support additional operators without making changes to your existing evaluate implementation?
 *
 *  Examples -
 *
 *  Example 1:
 *
 *  Input: s = ["3","4","+","2","*","7","/"]
 *  Output: 2
 *  Explanation: this expression evaluates to the above binary tree with expression ((3+4)*2)/7) = 14/7 = 2.
 */
public class ExpressionTreeFromPostfix extends Question<ExpressionTreeFromPostfixOutput, ExpressionTreeFromPostfixInput> {
    @Override
    public ExpressionTreeFromPostfixOutput solve(ExpressionTreeFromPostfixInput input) {
        ExpressionTreeFromPostfixOutput output = new ExpressionTreeFromPostfixOutput(null);
        Stack<BinaryTreeNode<String>> stack = new Stack<>();
        List<BinaryTreeNode<String>> nodes = new ArrayList<>();
        for (int i = 0; i < input.postfix.size(); i++) {
            nodes.add(new BinaryTreeNode<>(input.postfix.get(i)));
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (isDigit(nodes.get(i).val)) {
                stack.push(nodes.get(i));
            } else {
                nodes.get(i).right = stack.pop();
                nodes.get(i).left = stack.pop();
                stack.push(nodes.get(i));
            }
        }
        output.tree = new BinaryTree<>(stack.pop());
        output.result = evaluate(output.tree.root);
        return output;
    }

    @Override
    public ExpressionTreeFromPostfixInput takeInput() {
        ExpressionTreeFromPostfixInput input = new ExpressionTreeFromPostfixInput(new ArrayList<>());
        input.postfix = Arrays.asList("100","200","+","2","/","5","*","7","+");
        return input;
    }

    @Override
    public void display(ExpressionTreeFromPostfixOutput content) {
        List<String> preorder = content.tree.iterativePreorder();
        for (int i = 0; i < preorder.size(); i++) {
            System.out.print(preorder.get(i));
            System.out.println(" ");
        }
        System.out.println(content.result);
    }

    private boolean isDigit(String element) {
        return !isOperator(element);
    }

    private boolean isOperator(String element) {
        switch (element) {
            case "*":
            case "/":
            case "-":
            case "+":
                return true;
            default:
                return false;
        }
    }

    private Integer evaluate(BinaryTreeNode<String> node) {
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) return Integer.valueOf(node.val);
        int computedValue = operate(evaluate(node.left), evaluate(node.right), node.val);
        return computedValue;
    }

    private int operate(int num1, int num2, String op) {
        switch (op) {
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            case "-": return num1 - num2;
            case "+": return num1 + num2;
            default : return 0;
        }
    }
}
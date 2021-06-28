package com.codr.leetcodequestions.trees.medium.ConstructBstPreorderTraversal;

import com.codr.framework.Question;
import com.codr.framework.Trees.impl.BinarySearchTree;
import com.codr.framework.Trees.impl.BinarySearchTreeNode;
import com.codr.leetcodequestions.trees.medium.ConstructBstPreorderTraversal.data.ConstructBstPreorderTraversalInput;
import com.codr.leetcodequestions.trees.medium.ConstructBstPreorderTraversal.data.ConstructBstPreorderTraversalOutput;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree),
 * construct the tree and return its root.
 *
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and
 * any descendant of Node.right has a value strictly greater than Node.val.
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 *
 *
 * Examples:
 *
 * Example 1 -
 * Input: preorder = [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 */
public class ConstructBstPreorderTraversal extends Question<ConstructBstPreorderTraversalOutput, ConstructBstPreorderTraversalInput> {
    @Override
    public ConstructBstPreorderTraversalOutput solve(ConstructBstPreorderTraversalInput input) {
        ConstructBstPreorderTraversalOutput output = new ConstructBstPreorderTraversalOutput();
        output.tree = new BinarySearchTree<>(null);
        for (Integer element: input.preorder) {
            output.tree.addNode(new BinarySearchTreeNode<>(element));
        }
        return output;
    }

    @Override
    public ConstructBstPreorderTraversalInput takeInput() {
        ConstructBstPreorderTraversalInput input = new ConstructBstPreorderTraversalInput();
        input.preorder = Arrays.asList(8, 5, 1, 7, 10, 12);
        return input;
    }

    @Override
    public void display(ConstructBstPreorderTraversalOutput content) {
        List<Integer> list = content.tree.preorder();
        System.out.print("[ ");
        for (Integer item : list) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println("]");
    }
}
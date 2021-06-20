package com.codr.leetcodequestions.stacks.easy.BinaryTreeInorderTraversal;

import com.codr.framework.Question;
import com.codr.framework.Trees.impl.BinaryTree;
import com.codr.framework.Trees.impl.BinaryTreeNode;
import com.codr.leetcodequestions.stacks.easy.BinaryTreeInorderTraversal.data.BinaryTreeInorderTraversalInput;
import com.codr.leetcodequestions.stacks.easy.BinaryTreeInorderTraversal.data.BinaryTreeInorderTraversalOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Examples:
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 */
public class BinaryTreeInorderTraversal extends Question<BinaryTreeInorderTraversalOutput, BinaryTreeInorderTraversalInput> {
    @Override
    public BinaryTreeInorderTraversalOutput solve(BinaryTreeInorderTraversalInput input) {
        BinaryTree binaryTree = input.binaryTree;
        BinaryTreeNode root = binaryTree.root;

        List<Integer> traversalArray = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        Map<BinaryTreeNode, Boolean> visited = new HashMap<>();

        if (root == null) return new BinaryTreeInorderTraversalOutput(traversalArray);

        stack.push(root);
        while(!stack.empty()) {
            BinaryTreeNode peekNode = stack.peek();
            visited.put(peekNode, true);

            // No left child
            if (Objects.isNull(peekNode.left) || visited.getOrDefault(peekNode.left, false)) {
                // Process current node.
                traversalArray.add(peekNode.val);
                stack.pop();
                // Add right child if it exists.
                if (Objects.nonNull(peekNode.right)) {
                    stack.push(peekNode.right);
                }
            } else if (Objects.nonNull(peekNode.left) && !visited.getOrDefault(peekNode.left, false)) { //Unprocessed left child.
                stack.push(peekNode.left);
            }
        }
        return new BinaryTreeInorderTraversalOutput(traversalArray);
    }

    @Override
    public BinaryTreeInorderTraversalInput takeInput() {
        BinaryTreeInorderTraversalInput input = new BinaryTreeInorderTraversalInput();
        input.binaryTree = new BinaryTree();
        input.binaryTree.root = new BinaryTreeNode(1);
        input.binaryTree.root.left = null;
        input.binaryTree.root.right = new BinaryTreeNode(2);
        input.binaryTree.root.right.left = new BinaryTreeNode(3, null, null);
        input.binaryTree.root.right.right = null;
        return input;
    }

    @Override
    public void display(BinaryTreeInorderTraversalOutput content) {
        System.out.println(content.inorderTraversal);
    }
}
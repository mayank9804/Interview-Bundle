package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.Tree;
import com.codr.leetcodequestions.stacks.easy.BinaryTreeInorderTraversal.data.BinaryTreeInorderTraversalOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * Definition of BinaryTree.
 */
public class BinaryTree implements Tree {
    public BinaryTreeNode root;

    public BinaryTree() {}

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * Computes the inorder of a tree using iterative method.
     * @param root
     * @return
     */
    public List<Integer> iterativeInorder(BinaryTreeNode root) {

        List<Integer> traversalArray = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        Map<BinaryTreeNode, Boolean> visited = new HashMap<>();

        if (root == null) return traversalArray;

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
            } else if (Objects.nonNull(peekNode.left) && !visited.getOrDefault(peekNode.left, false)) {
                //Unprocessed left child.
                stack.push(peekNode.left);
            }
        }

        return traversalArray;
    }
}

package com.codr.framework.Trees.impl;

import com.codr.framework.Trees.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * Definition of BinaryTree.
 */
public class BinaryTree<T extends Number> implements Tree {
    public BinaryTreeNode<T> root;

    public BinaryTree() {}

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    /**
     * Computes the inorder of a tree using iterative method.
     * @param root
     * @return
     */
    public List<T> iterativeInorder() {
        BinaryTreeNode<T> rootNode = this.root;
        List<T> traversalArray = new ArrayList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        Map<BinaryTreeNode<T>, Boolean> visited = new HashMap<>();

        if (rootNode == null) return traversalArray;

        stack.push(rootNode);
        while(!stack.empty()) {
            BinaryTreeNode<T> peekNode = stack.peek();
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

    /**
     * Computes the preorder traversal of a tree using iterative method.
     * @param root
     * @return
     */
    public List<T> iterativePreorder() {
        BinaryTreeNode<T> rootNode = this.root;
        List<T> traversalArray = new ArrayList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        Map<BinaryTreeNode<T>, Boolean> visited = new HashMap<>();

        if (rootNode == null) return traversalArray;

        stack.push(rootNode);
        while(!stack.empty()) {
            BinaryTreeNode<T> peekNode = stack.peek();
            if (!visited.getOrDefault(peekNode, false)) traversalArray.add(peekNode.val);

            visited.put(peekNode, true);
            // Leaf Node or a node whose children are already visited.
            if ((Objects.isNull(peekNode.left) || visited.getOrDefault(peekNode.left, false)) &&
                    (Objects.isNull(peekNode.right) || visited.getOrDefault(peekNode.right, false)) && !stack.empty()) {
                stack.pop();
            } else if (Objects.nonNull(peekNode.left) && !visited.getOrDefault(peekNode.left, false)) {
                stack.push(peekNode.left);
            } else if (Objects.nonNull(peekNode.right)) {
                stack.push(peekNode.right);
            }
        }
        return traversalArray;
    }

    /**
     * Computes the postorder traversal of a tree using iterative method.
     * @param root
     * @return
     */
    public List<T> iterativePostorder() {
        BinaryTreeNode<T> rootNode = this.root;
        List<T> traversalArray = new ArrayList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        Map<BinaryTreeNode<T>, Boolean> visited = new HashMap<>();

        if (rootNode == null) return traversalArray;

        stack.push(rootNode);
        while(!stack.empty()) {
            BinaryTreeNode<T> peekNode = stack.peek();
            visited.put(peekNode, true);
            // Leaf Node
            if ((Objects.isNull(peekNode.left) || visited.getOrDefault(peekNode.left, false)) &&
                    (Objects.isNull(peekNode.right) || visited.getOrDefault(peekNode.right, false)) && !stack.empty()) {
                traversalArray.add(peekNode.val);
                stack.pop();
            } else if (Objects.nonNull(peekNode.left) && !visited.getOrDefault(peekNode.left, false)) {
                stack.push(peekNode.left);
            } else if (Objects.nonNull(peekNode.right)) {
                stack.push(peekNode.right);
            }
        }
        return traversalArray;
    }
}

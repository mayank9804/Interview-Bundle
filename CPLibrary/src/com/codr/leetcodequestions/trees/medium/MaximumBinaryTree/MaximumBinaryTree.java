package com.codr.leetcodequestions.trees.medium.MaximumBinaryTree;

import com.codr.framework.Question;
import com.codr.framework.Trees.impl.BinaryTree;
import com.codr.framework.Trees.impl.BinaryTreeNode;
import com.codr.leetcodequestions.trees.medium.MaximumBinaryTree.data.MaximumBinaryTreeInput;
import com.codr.leetcodequestions.trees.medium.MaximumBinaryTree.data.MaximumBinaryTreeOutput;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 *
 * Examples:
 *
 * Example 1 -
 * Input: nums = [3,2,1]
 * Output: [3,null,2,null,1]
 *
 */
public class MaximumBinaryTree extends Question<MaximumBinaryTreeOutput, MaximumBinaryTreeInput> {
    @Override
    public MaximumBinaryTreeOutput solve(MaximumBinaryTreeInput input) {
        MaximumBinaryTreeOutput output = new MaximumBinaryTreeOutput();
        output.tree = new BinaryTree<>(null);
        output.tree.root = constructTree(input.numbers, 0, input.numbers.size(), output.tree.root);
        return output;
    }

    @Override
    public MaximumBinaryTreeInput takeInput() {
        MaximumBinaryTreeInput input = new MaximumBinaryTreeInput();
        input.numbers = Arrays.asList(3, 2, 1, 6, 0, 5);
        return input;
    }

    @Override
    public void display(MaximumBinaryTreeOutput content) {
        List<Integer> preorder = content.tree.iterativePreorder();
        System.out.print("[ ");
        for (Integer element:  preorder) {
            System.out.print(element);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    private BinaryTreeNode<Integer> constructTree(List<Integer> nums, Integer left, Integer right, BinaryTreeNode<Integer> node) {
        if (left >= right) { return null; }
        Pair<Integer, Integer> maxPair = getMax(left, right, nums);
        int leftPrefixStartIndex = left;
        int leftPrefixEndIndex = maxPair.getValue();

        int rightPrefixStartIndex = maxPair.getValue() + 1;
        int rightPrefixEndIndex  = right;
        if (node == null) {
            node = new BinaryTreeNode<>(maxPair.getKey(), null, null);
        }
        node.left = constructTree(nums, leftPrefixStartIndex, leftPrefixEndIndex, node.left);
        node.right = constructTree(nums, rightPrefixStartIndex, rightPrefixEndIndex, node.right);
        return node;
    }

    private Pair<Integer, Integer> getMax(Integer left, Integer right, List<Integer> nums) {
        Pair<Integer, Integer> max_Pair = new Pair<>(-1,-1);
        for (int i = left; i < right; i++) {
            if (nums.get(i) > max_Pair.getKey()) max_Pair = new Pair<>(nums.get(i), i);
        }
        return max_Pair;
    }
}
package com.codr.leetcodequestions.trees.medium.MincostTreesFromLeafValues;

import com.codr.framework.Question;
import com.codr.leetcodequestions.trees.medium.MincostTreesFromLeafValues.data.MincostTreesFromLeafValuesInput;
import com.codr.leetcodequestions.trees.medium.MincostTreesFromLeafValues.data.MincostTreesFromLeafValuesOutput;
import javafx.util.Pair;

import java.util.Arrays;

/**
 * Given an array arr of positive integers, consider all binary trees such that:
 *
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 *
 * Example 1:
 *
 * Input: arr = [6,2,4]
 * Output: 32
 */
public class MincostTreesFromLeafValues extends Question<MincostTreesFromLeafValuesOutput, MincostTreesFromLeafValuesInput> {

    Pair<Integer, Integer>[][] dp;

    @Override
    public MincostTreesFromLeafValuesOutput solve(MincostTreesFromLeafValuesInput input) {
        int arr_size = input.arr.length;
        dp = new Pair[arr_size][arr_size];
        for (int i = 0; i < arr_size; i++) {
            dp[i][i] = new Pair<>(input.arr[i], 0);
        }
        for (int i = arr_size-2; i >= 0; i--) {
            for (int j = i+1; j < arr_size; j++) {
                dp[i][j] = findMin(i, j);
            }
        }
        return new MincostTreesFromLeafValuesOutput(dp[0][arr_size-1].getValue());
    }

    @Override
    public MincostTreesFromLeafValuesInput takeInput() {
        return new MincostTreesFromLeafValuesInput(new int[]{6, 2, 4, 8});
    }

    @Override
    public void display(MincostTreesFromLeafValuesOutput content) {
        System.out.println(content.cost);
    }

    private Pair<Integer, Integer> findMin(int start, int last) {
        Pair<Integer, Integer> ans = new Pair<>(-1, Integer.MAX_VALUE);
        for (int i = start; i < last ; i++) {
            Pair<Integer, Integer> pair1 = dp[start][i];
            Pair<Integer, Integer> pair2 = dp[i+1][last];
            int cost = (pair1.getKey()*pair2.getKey() + pair1.getValue() + pair2.getValue());
            int max_num = Math.max(pair1.getKey(), pair2.getKey());
            if ( cost < ans.getValue()) {
                ans = new Pair<>(max_num, cost);
            }
        }
        return ans;
    }

     private Pair<Integer, Integer> calculateMCTRecursively(int[] arr, int start, int last) {
         if (last == start) return new Pair<>(arr[start], 0); // Using this node alone there can be no new node formation.
         if (dp[start][last].getValue() != -1) return dp[start][last];
         Pair<Integer, Integer> pair0 = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
         for (int i = start; i < last; i++) {

             Pair<Integer, Integer> pair1 = calculateMCTRecursively(arr, start, i); // lies on left
             Pair<Integer, Integer> pair2 = calculateMCTRecursively(arr, i+1, last); // lies on right
             dp[start][i] = pair1;
             dp[i+1][last] = pair2;

             int max_left = pair1.getKey();
             int max_right = pair2.getKey();

             int left_cost = pair1.getValue();
             int right_cost = pair2.getValue();

             Pair<Integer, Integer> pair3 =
                 new Pair<>(Math.max(max_left, max_right), ((max_left*max_right) + (left_cost + right_cost)));

             if (pair3.getValue() < pair0.getValue()) {
                 pair0 = pair3;
                 dp[start][last] = pair0;
             }
         }

         return pair0;
     }

}
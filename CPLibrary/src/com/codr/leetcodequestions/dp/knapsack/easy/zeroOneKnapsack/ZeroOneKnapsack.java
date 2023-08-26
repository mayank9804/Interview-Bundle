package com.codr.leetcodequestions.dp.knapsack.easy.zeroOneKnapsack;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.easy.zeroOneKnapsack.data.ZeroOneKnapsackInput;
import com.codr.leetcodequestions.dp.knapsack.easy.zeroOneKnapsack.data.ZeroOneKnapsackOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Classic 01 Knapsack problem.
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 * in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
 * and weights associated with n items respectively. Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 *
 * Example 1: Input: W = 4, wt[] = [1, 2, 3], val[] = [1500, 3000, 2000]
 *            Output: 4500
 * Example 2: Input: W = 5, wt[] = [1, 2, 3], val[] = [1500, 3000, 2000]
 *            Output: 5000
 */
public class ZeroOneKnapsack extends Question<ZeroOneKnapsackOutput, ZeroOneKnapsackInput> {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public ZeroOneKnapsackOutput solve(ZeroOneKnapsackInput input) {
        int n = input.values.length;
        int capacity = input.capacity;
        int[][] dp = new int[n+1][capacity+1];

        Arrays.fill(dp[0], 0);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (input.weights[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], input.values[i-1] + dp[i-1][j-input.weights[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return new ZeroOneKnapsackOutput(dp[n][capacity]);
    }

    @Override
    public ZeroOneKnapsackInput takeInput() {
        ZeroOneKnapsackInput input = new ZeroOneKnapsackInput();
        System.out.println("Enter the number of items: ");
        int n = scanner.nextInt();
        input.weights = new int[n];
        input.values = new int[n];
        System.out.println("Enter the weights of the items: ");
        for (int i = 0; i < n; i++) {
            input.weights[i] = scanner.nextInt();
        }
        System.out.println("Enter the values of the items: ");
        for (int i = 0; i < n; i++) {
            input.values[i] = scanner.nextInt();
        }
        System.out.println("Enter the capacity of the knapsack: ");
        input.capacity = scanner.nextInt();
        return input;
    }

    @Override
    public void display(ZeroOneKnapsackOutput content) {
        System.out.println("Total max profit: " + content.totalProfit);
    }
}
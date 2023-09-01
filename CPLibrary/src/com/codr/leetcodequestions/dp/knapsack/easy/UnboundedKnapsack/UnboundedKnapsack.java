package com.codr.leetcodequestions.dp.knapsack.easy.UnboundedKnapsack;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.easy.UnboundedKnapsack.data.UnboundedKnapsackInput;
import com.codr.leetcodequestions.dp.knapsack.easy.UnboundedKnapsack.data.UnboundedKnapsackOutput;

import java.util.Arrays;

public class UnboundedKnapsack extends Question<UnboundedKnapsackOutput, UnboundedKnapsackInput> {

    @Override
    public UnboundedKnapsackOutput solve(UnboundedKnapsackInput input) {
        int[] weights = input.weights;
        int[] values = input.values;
        int capacity = input.capacity;
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        Arrays.fill(dp[0], 0);
        for (int i=0; i <=n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i-1] <= j) {
                    dp[i][j] = Math.max(values[i-1] + dp[i][j-weights[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return new UnboundedKnapsackOutput(dp[n][capacity]);
    }

    @Override
    public UnboundedKnapsackInput takeInput() {
        System.out.println("Enter the number of items");
        int n = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        System.out.println("Enter the weights of the items");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        System.out.println("Enter the values of the items");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        System.out.println("Enter the capacity of the knapsack");
        int capacity = scanner.nextInt();
        return new UnboundedKnapsackInput(weights, values, capacity);
    }

    @Override
    public void display(UnboundedKnapsackOutput content) {
        System.out.println("Maximum profit: " + content.maxProfit);
    }
}


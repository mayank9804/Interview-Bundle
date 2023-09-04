package com.codr.leetcodequestions.dp.knapsack.easy.RodCuttingProblem;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.easy.RodCuttingProblem.data.RodCuttingProblemInput;
import com.codr.leetcodequestions.dp.knapsack.easy.RodCuttingProblem.data.RodCuttingProblemOutput;

public class RodCuttingProblem extends Question<RodCuttingProblemOutput, RodCuttingProblemInput> {

    @Override
    public RodCuttingProblemOutput solve(RodCuttingProblemInput input) {
        int length = input.rodLength;
        int[] values = input.values;

        int[][] dp = new int[length + 1][values.length + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= length ; j++) {
                if (values[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i][j-values[j-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return new RodCuttingProblemOutput(dp[length][values.length]);
    }

    @Override
    public RodCuttingProblemInput takeInput() {
        System.out.println("Enter the length of rod");
        int n = scanner.nextInt();
        int[] values = new int[n];
        System.out.println("Enter the profit associated with each length from 1 to n");
        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }
        return new RodCuttingProblemInput(n, values);
    }

    @Override
    public void display(RodCuttingProblemOutput content) {
        System.out.printf("The maximum profit that can be obtained is %s%n", content.maxProfit);
    }
}


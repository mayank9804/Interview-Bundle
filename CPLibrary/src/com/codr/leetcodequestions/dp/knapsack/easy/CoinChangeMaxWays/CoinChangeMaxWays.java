package com.codr.leetcodequestions.dp.knapsack.easy.CoinChangeMaxWays;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.easy.CoinChangeMaxWays.data.CoinChangeMaxWaysInput;
import com.codr.leetcodequestions.dp.knapsack.easy.CoinChangeMaxWays.data.CoinChangeMaxWaysOutput;

public class CoinChangeMaxWays extends Question<CoinChangeMaxWaysOutput, CoinChangeMaxWaysInput> {

    @Override
    public CoinChangeMaxWaysOutput solve(CoinChangeMaxWaysInput input) {
        int amount = input.amount;
        int[] coins = input.coins;
        int n = input.coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return new CoinChangeMaxWaysOutput(dp[n][amount]);
    }

    @Override
    public CoinChangeMaxWaysInput takeInput() {
        System.out.println("Enter the amount");
        int amount = scanner.nextInt();
        System.out.println("Enter the number of coins");
        int n = scanner.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the coins");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        return new CoinChangeMaxWaysInput(amount, coins);
    }

    @Override
    public void display(CoinChangeMaxWaysOutput content) {
        System.out.printf("Maximum number of ways in which this coin can be changed is %s%n", content.maxWays);
    }
}


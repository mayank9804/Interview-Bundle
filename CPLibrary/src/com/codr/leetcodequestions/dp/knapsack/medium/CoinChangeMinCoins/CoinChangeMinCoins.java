package com.codr.leetcodequestions.dp.knapsack.medium.CoinChangeMinCoins;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.medium.CoinChangeMinCoins.data.CoinChangeMinCoinsInput;
import com.codr.leetcodequestions.dp.knapsack.medium.CoinChangeMinCoins.data.CoinChangeMinCoinsOutput;

import java.util.Arrays;

public class CoinChangeMinCoins extends Question<CoinChangeMinCoinsOutput, CoinChangeMinCoinsInput> {

    @Override
    public CoinChangeMinCoinsOutput solve(CoinChangeMinCoinsInput input) {
        int amount = input.amount;
        int[] coins = input.denominations;
        int n = coins.length;

        // DP denoting sub-problem (min number of coins when and amount is d[x])
        int[] dp = new int[amount+1];
        // Temporary data store representing the values when coins available are upto an index x.
        int[] t = new int[amount + 1];
        Arrays.fill(t, Integer.MAX_VALUE - 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] <= j) {
                    dp[j] = 1 + Math.min(t[j], dp[j-coins[i-1]]);
                } else {
                    dp[j] = t[j];
                }
            }
            t = dp;
        }

        return new CoinChangeMinCoinsOutput(dp[amount]);

    }

    @Override
    public CoinChangeMinCoinsInput takeInput() {
        System.out.println("Enter the amount");
        int amount = scanner.nextInt();
        System.out.println("Enter the number of coins");
        int n = scanner.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the coins");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        return new CoinChangeMinCoinsInput(amount, coins);
    }

    @Override
    public void display(CoinChangeMinCoinsOutput content) {
        System.out.println("The minimum number of coins required are " + content.minCoins);
    }

    private void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}


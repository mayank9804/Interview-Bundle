package com.codr.leetcodequestions.dp.knapsack.easy.SubsetSum;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.easy.SubsetSum.data.SubsetSumInput;
import com.codr.leetcodequestions.dp.knapsack.easy.SubsetSum.data.SubsetSumOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Subset Sum Problem: Given a set of non-negative integers, and a value sum, determine if there is a subset of the given
 * set with sum equal to given sum.
 *
 * Examples:
 * Input: set[] = {3, 34, 4, 12, 5, 2}
 *        sum = 9
 *        Output: True  // There is a subset (4, 5) with sum 9.
 *        Input: set[] = {3, 34, 4, 12, 5, 2}
 *        sum = 30
 *        Output: False // There is no subset that add up to 30.
 */
public class SubsetSum extends Question<SubsetSumOutput, SubsetSumInput> {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public SubsetSumOutput solve(SubsetSumInput input) {
        int[] nums = input.nums;
        int sum = input.target;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        Arrays.fill(dp[0], false);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return new SubsetSumOutput(dp[n][sum]);
    }

    @Override
    public SubsetSumInput takeInput() {
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the target: ");
        int target = scanner.nextInt();
        return new SubsetSumInput(nums, target);
    }

    @Override
    public void display(SubsetSumOutput content) {
        System.out.println("Subset sum exists: " + content.exists);
    }
}

package com.codr.leetcodequestions.dp.knapsack.medium.SubsetSumCount;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.medium.SubsetSumCount.data.SubsetSumCountInput;
import com.codr.leetcodequestions.dp.knapsack.medium.SubsetSumCount.data.SubsetSumCountOutput;

import java.util.Scanner;

/**
 * Subset Sum Count: Given a set of non-negative integers, and a value sum, determine if there is a subset of the given
 * set with sum equal to given sum.
 * Examples:
 * Input: set[] = {3, 34, 4, 12, 5, 2}
 *        sum = 9
 *        Output = 2 [(4, 5) and (3, 4, 2)]
 */
public class SubsetSumCount extends Question<SubsetSumCountOutput, SubsetSumCountInput> {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public SubsetSumCountOutput solve(SubsetSumCountInput input) {
        int[] nums = input.nums;
        int target = input.target;
        int n = nums.length;

        int dp[][] = new int[n+1][target+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= target; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return new SubsetSumCountOutput(dp[n][target]);
    }

    @Override
    public SubsetSumCountInput takeInput() {
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the target sum: ");
        int target = scanner.nextInt();

        return new SubsetSumCountInput(nums, target);
    }

    @Override
    public void display(SubsetSumCountOutput content) {
        System.out.println("Number of subsets with sum equal to target sum: " + content.count);
    }
}
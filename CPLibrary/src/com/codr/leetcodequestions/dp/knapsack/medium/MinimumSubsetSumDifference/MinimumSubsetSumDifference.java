package com.codr.leetcodequestions.dp.knapsack.medium.MinimumSubsetSumDifference;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.medium.MinimumSubsetSumDifference.data.MinimumSubsetSumDifferenceInput;
import com.codr.leetcodequestions.dp.knapsack.medium.MinimumSubsetSumDifference.data.MinimumSubsetSumDifferenceOutput;

import java.util.Scanner;

/**
 * Minimum Subset Sum Difference is a partitioning of a set into two subsets with minimum difference between their subset sums.
 * Examples:
 * Input: nums = [1, 2, 3, 9]
 * Output: 3
 * Explanation: We can partition the array into [1, 2, 3] and [9].
 */
public class MinimumSubsetSumDifference extends Question<MinimumSubsetSumDifferenceOutput, MinimumSubsetSumDifferenceInput> {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public MinimumSubsetSumDifferenceOutput solve(MinimumSubsetSumDifferenceInput input) {
        int[] nums = input.nums;
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int range = sum / 2;
        boolean dp[][] = new boolean[n+1][range+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= range; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int minimumSubsetSumDifference = Integer.MAX_VALUE;
        for (int i = 0; i <= range; i++) {
            if (dp[n][i]) {
                minimumSubsetSumDifference = Math.min(minimumSubsetSumDifference, sum - 2 * i);
            }
        }

        return new MinimumSubsetSumDifferenceOutput(minimumSubsetSumDifference);
    }

    @Override
    public MinimumSubsetSumDifferenceInput takeInput() {
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        return new MinimumSubsetSumDifferenceInput(nums);
    }

    @Override
    public void display(MinimumSubsetSumDifferenceOutput content) {
        System.out.println("Minimum subset sum difference: " + content.minimumSubsetSumDifference);
    }
}
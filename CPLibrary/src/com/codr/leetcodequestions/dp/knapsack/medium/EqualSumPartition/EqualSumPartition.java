package com.codr.leetcodequestions.dp.knapsack.medium.EqualSumPartition;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.medium.EqualSumPartition.data.EqualSumPartitionInput;
import com.codr.leetcodequestions.dp.knapsack.medium.EqualSumPartition.data.EqualSumPartitionOutput;

import java.util.Scanner;

/**
 * Equality Sum Partition is a partitioning of a set into two subsets with equal sum.
 * Given a set of integers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 * Examples:
 * Input: {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 */
public class EqualSumPartition extends Question<EqualSumPartitionOutput, EqualSumPartitionInput> {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public EqualSumPartitionOutput solve(EqualSumPartitionInput input) {
        int[] nums = input.nums;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return new EqualSumPartitionOutput(false);
        }
        int n = nums.length;
        int range = sum/2;

        boolean dp[][] = new boolean[n+1][range+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= range; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j= 1; j <= range; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return new EqualSumPartitionOutput(dp[n][range]);
    }

    @Override
    public EqualSumPartitionInput takeInput() {
        System.out.println("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the values of the items: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        return new EqualSumPartitionInput(nums);
    }

    @Override
    public void display(EqualSumPartitionOutput content) {
        System.out.println("Equality Sum Partition exists: " + content.exists);
    }
}
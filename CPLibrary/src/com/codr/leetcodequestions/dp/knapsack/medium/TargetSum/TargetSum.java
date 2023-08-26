package com.codr.leetcodequestions.dp.knapsack.medium.TargetSum;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.knapsack.medium.TargetSum.data.TargetSumInput;
import com.codr.leetcodequestions.dp.knapsack.medium.TargetSum.data.TargetSumOutput;

/**
 * Target Sum: Given an array of integers and a target value, add '+' or  '-' to each element of the array to get the target value.
 * Examples:
 * Input: nums = [1, 2, 3, 4, 5], target = 5
 * Output: true
 * Explanation: There is a subset (1, 4) that sums to 5.
 * Input: nums = [1, 2, 3, 4, 5], target = 10
 * Output: false
 * Explanation: There is no subset that sums to 10.
 * Input: nums = [1, 2, 3, 4, 5], target = 0
 * Output: true
 * Explanation: There is a subset (0) that sums to 0.
 * Input: nums = [1, 2, 3, 4, 5], target = -1
 * Output: false
 * Explanation: There is no subset that sums to -1.
 * Input: nums = [1, 2, 3, 4, 5], target = 6
 * Output: false
 * Explanation: There is no subset that sums to 6.
 * Input: nums = [1, 2, 3, 4, 5], target = 7
 * Output: false
 * Explanation: There is no subset that sums to 7.
 */
public class TargetSum extends Question<TargetSumOutput, TargetSumInput> {

    @Override
    public TargetSumOutput solve(TargetSumInput input) {
        int[] nums = input.nums;
        int target = input.target;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) {
            return new TargetSumOutput(0);
        }
        int updatedTarget = (sum + target)/2;
        int dp[][] = new int[n+1][updatedTarget+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= updatedTarget; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= updatedTarget; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= updatedTarget; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return new TargetSumOutput(dp[n][updatedTarget]);
    }

    @Override
    public TargetSumInput takeInput() {
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the target sum: ");
        int target = scanner.nextInt();
        return new TargetSumInput(nums, target);
    }

    @Override
    public void display(TargetSumOutput content) {
        System.out.println("Target sum count: " + content.count);
    }
}
package com.codr.leetcodequestions.dp.knapsack.medium.SubsetSumCount.data;
public class SubsetSumCountInput {
    public int[] nums;
    public int target;

    public SubsetSumCountInput(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public SubsetSumCountInput() {
        this.nums = new int[0];
        this.target = 0;
    }
}
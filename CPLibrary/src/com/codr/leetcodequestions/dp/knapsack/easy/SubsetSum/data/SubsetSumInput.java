package com.codr.leetcodequestions.dp.knapsack.easy.SubsetSum.data;

public class SubsetSumInput {
    public int[] nums;
    public int target;

    public SubsetSumInput(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public SubsetSumInput() {
        this.nums = new int[0];
        this.target = 0;
    }
}
package com.codr.leetcodequestions.dp.knapsack.easy.zeroOneKnapsack.data;
public class ZeroOneKnapsackInput {
    public int[] weights;
    public int[] values;
    public int capacity;

    public ZeroOneKnapsackInput(int[] weights, int[] values, int capacity) {
        this.weights = weights;
        this.values = values;
        this.capacity = capacity;
    }

    public ZeroOneKnapsackInput() {
        this.weights = new int[]{};
        this.values = new int[]{};
        this.capacity = 0;
    }
}
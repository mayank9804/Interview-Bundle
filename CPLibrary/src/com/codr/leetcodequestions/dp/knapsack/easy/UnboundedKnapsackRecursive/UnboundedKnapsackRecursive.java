package com.codr.leetcodequestions.dp.knapsack.easy.UnboundedKnapsackRecursive;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveTask;

public class UnboundedKnapsackRecursive extends RecursiveTask<Integer> {
    private int capacity;
    private int idx;
    private int[] weights;
    private int[] values;

    public UnboundedKnapsackRecursive(int capacity, int idx, int[] weights, int[] values) {
        this.capacity = capacity;
        this.idx = idx;
        this.weights = weights;
        this.values = values;
    }

    @Override
    protected Integer compute() {
        System.out.printf("Current thread : %s.%n", Thread.currentThread().getName());
        System.out.println(Thread.currentThread() instanceof ForkJoinWorkerThread);
        if (idx == -1) return 0;
        if (weights[idx] <= capacity) {
            ForkJoinTask<Integer> subTask1 = new UnboundedKnapsackRecursive(capacity - weights[idx], idx, weights, values).fork();
            ForkJoinTask<Integer> subTask2 = new UnboundedKnapsackRecursive(capacity, idx - 1, weights, values).fork();
            return Math.max(values[idx] + subTask1.join(), subTask2.join());
        }
        return new UnboundedKnapsackRecursive(capacity, idx - 1, weights, values).compute();
    }
}




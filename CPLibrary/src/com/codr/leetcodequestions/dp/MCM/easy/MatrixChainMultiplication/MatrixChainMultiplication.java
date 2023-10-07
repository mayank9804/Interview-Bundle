package com.codr.leetcodequestions.dp.MCM.easy.MatrixChainMultiplication;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.MCM.easy.MatrixChainMultiplication.data.MatrixChainMultiplicationInput;
import com.codr.leetcodequestions.dp.MCM.easy.MatrixChainMultiplication.data.MatrixChainMultiplicationOutput;

public class MatrixChainMultiplication extends Question<MatrixChainMultiplicationOutput, MatrixChainMultiplicationInput> {

    @Override
    public MatrixChainMultiplicationOutput solve(MatrixChainMultiplicationInput input) {
        int[] arr = input.dimensions;
        int n = arr.length;
        int minCost = recurse(arr, 1, n-1);
        return new MatrixChainMultiplicationOutput(minCost);
    }

    @Override
    public MatrixChainMultiplicationInput takeInput() {
        System.out.println("Enter number of matrices");
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        System.out.println("Enter elements denoting dimensions");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        return new MatrixChainMultiplicationInput(arr);
    }

    @Override
    public void display(MatrixChainMultiplicationOutput content) {
        System.out.println("The minimum cost of multiplying matrics of input dimensions is " + content.minCost);
    }

    private int recurse(int[] arr, int i, int j) {
        if (i >= j) return 0;
        int minCost = Integer.MAX_VALUE;
        for (int idx = i; idx < j; idx++) {
            int cost = recurse(arr, i, idx) + recurse(arr, idx + 1, j);
            cost += arr[i-1] * arr[idx] * arr[j];
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}


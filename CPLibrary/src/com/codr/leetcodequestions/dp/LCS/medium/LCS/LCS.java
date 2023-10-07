package com.codr.leetcodequestions.dp.LCS.medium.LCS;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.LCS.medium.LCS.data.LCSInput;
import com.codr.leetcodequestions.dp.LCS.medium.LCS.data.LCSOutput;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class LCS extends Question<LCSOutput, LCSInput> {

    @Override
    public LCSOutput solve(LCSInput input) {
        String s1 = input.s1;
        String s2 = input.s2;
        int l1 = s1.length() - 1;
        int l2 = s2.length() - 1;
//        return new LCSOutput(new LCSComputation(l1, l2, s1, s2).compute());
        return new LCSOutput(new LCSDP(s1, s2).compute());
    }

    @Override
    public LCSInput takeInput() {
        System.out.println("Enter the first string");
        String s1 = scanner.nextLine();
        System.out.println("Enter the second string");
        String s2 = scanner.nextLine();
        return new LCSInput(s1, s2);
    }

    @Override
    public void display(LCSOutput content) {
        System.out.println("The length of the longest common subsequence is " + content.length);
    }
}

class LCSComputation extends RecursiveTask<Integer> {

    int i, j;
    String s1, s2;
    public LCSComputation(int i, int j, String s1, String s2) {
        this.i = i;
        this.j = j;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    protected Integer compute() {
        if (i < 0 || j < 0) {
            return 0;
        }

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);

        if (c1 == c2) {
            LCSComputation opt1 = new LCSComputation(i-1, j-1, s1, s2);
            return 1 + opt1.compute();
        }

        ForkJoinTask<Integer> choice1 = new LCSComputation(i-1, j, s1, s2).fork();
        ForkJoinTask<Integer> choice2 = new LCSComputation(i, j-1, s1, s2).fork();
        return Math.max(choice1.join(), choice2.join());
    }
}

class LCSDP {

    int[][] dp;
    String s1, s2;
    public LCSDP(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        dp = new int[s1.length() + 1][s2.length() + 1];
    }

    public int compute() {
        setBaseCase();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private void setBaseCase() {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
    }
}

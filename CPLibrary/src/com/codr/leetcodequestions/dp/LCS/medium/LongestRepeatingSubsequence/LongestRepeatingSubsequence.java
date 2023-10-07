package com.codr.leetcodequestions.dp.LCS.medium.LongestRepeatingSubsequence;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.LCS.medium.LongestRepeatingSubsequence.data.LongestRepeatingSubsequenceInput;
import com.codr.leetcodequestions.dp.LCS.medium.LongestRepeatingSubsequence.data.LongestRepeatingSubsequenceOutput;

import java.util.Arrays;

public class LongestRepeatingSubsequence extends Question<LongestRepeatingSubsequenceOutput, LongestRepeatingSubsequenceInput> {

    @Override
    public LongestRepeatingSubsequenceOutput solve(LongestRepeatingSubsequenceInput input) {
        String s = input.s;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        Arrays.fill(dp[0], 0);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return new LongestRepeatingSubsequenceOutput(dp[s.length()][s.length()]);
    }

    @Override
    public LongestRepeatingSubsequenceInput takeInput() {
        System.out.println("Enter the string");
        String s = scanner.nextLine();
        return new LongestRepeatingSubsequenceInput(s);
    }

    @Override
    public void display(LongestRepeatingSubsequenceOutput content) {
        System.out.println("The length of longest repeating subsequence is " + content.length);
    }
}


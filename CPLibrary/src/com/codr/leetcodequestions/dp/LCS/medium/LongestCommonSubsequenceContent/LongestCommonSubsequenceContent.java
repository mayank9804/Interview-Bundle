package com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubsequenceContent;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubsequenceContent.data.LongestCommonSubsequenceContentInput;
import com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubsequenceContent.data.LongestCommonSubsequenceContentOutput;

import java.util.Arrays;

public class LongestCommonSubsequenceContent extends Question<LongestCommonSubsequenceContentOutput, LongestCommonSubsequenceContentInput> {

    @Override
    public LongestCommonSubsequenceContentOutput solve(LongestCommonSubsequenceContentInput input) {
        String s1 = input.s1;
        String s2 = input.s2;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i][0] = 0;
        }
        Arrays.fill(dp[0], 0);

        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = s1.length();
        int j = s2.length();
        StringBuilder reverseLcs = new StringBuilder();
        while(i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                reverseLcs.append(s1.charAt(i-1));
                i--; j--;
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return new LongestCommonSubsequenceContentOutput(reverseLcs.reverse().toString());
    }

    @Override
    public LongestCommonSubsequenceContentInput takeInput() {
        System.out.println("Enter the first string");
        String s1 = scanner.nextLine();
        System.out.println("Enter the second string");
        String s2 = scanner.nextLine();
        return new LongestCommonSubsequenceContentInput(s1, s2);
    }

    @Override
    public void display(LongestCommonSubsequenceContentOutput content) {
        System.out.println("Longest Common Subsequence is " + content.result + "\n");
    }
}


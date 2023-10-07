package com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubstring;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubstring.data.LongestCommonSubstringInput;
import com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubstring.data.LongestCommonSubstringOutput;

import java.util.Arrays;

public class LongestCommonSubstring extends Question<LongestCommonSubstringOutput, LongestCommonSubstringInput> {

    @Override
    public LongestCommonSubstringOutput solve(LongestCommonSubstringInput input) {
        String s1 = input.s1;
        String s2 = input.s2;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < dp.length ; i++) {
            dp[i][0] = 0;
        }
        Arrays.fill(dp[0], 0);
        int lcsLength = 0;
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                lcsLength = Math.max(lcsLength, dp[i][j]);
            }
        }
        return new LongestCommonSubstringOutput(lcsLength);
    }

    @Override
    public LongestCommonSubstringInput takeInput() {
        System.out.println("Enter the first string");
        String s1 = scanner.nextLine();
        System.out.println("Enter the second string");
        String s2 = scanner.nextLine();
        return new LongestCommonSubstringInput(s1, s2);
    }

    @Override
    public void display(LongestCommonSubstringOutput content) {
        System.out.println("The longest common substring is " + content.length);
    }
}


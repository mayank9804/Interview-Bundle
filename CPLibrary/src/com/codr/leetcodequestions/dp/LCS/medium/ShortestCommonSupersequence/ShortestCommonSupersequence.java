package com.codr.leetcodequestions.dp.LCS.medium.ShortestCommonSupersequence;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubsequenceContent.LongestCommonSubsequenceContent;
import com.codr.leetcodequestions.dp.LCS.medium.LongestCommonSubsequenceContent.data.LongestCommonSubsequenceContentInput;
import com.codr.leetcodequestions.dp.LCS.medium.ShortestCommonSupersequence.data.ShortestCommonSupersequenceInput;
import com.codr.leetcodequestions.dp.LCS.medium.ShortestCommonSupersequence.data.ShortestCommonSupersequenceOutput;

public class ShortestCommonSupersequence extends Question<ShortestCommonSupersequenceOutput, ShortestCommonSupersequenceInput> {

    @Override
    public ShortestCommonSupersequenceOutput solve(ShortestCommonSupersequenceInput input) {
        String s1 = input.s1;
        String s2 = input.s2;
        String lcs = getLCS(s1, s2);
        int i = 0, j = 0, k = 0;
        StringBuilder scs = new StringBuilder();
        while (i < s1.length() && j < s2.length() && k < lcs.length()) {
            while (i < s1.length() && s1.charAt(i) != lcs.charAt(k)) {
                scs.append(s1.charAt(i++));
            }
            while (j < s2.length() && s2.charAt(j) != lcs.charAt(k)) {
                scs.append(s2.charAt(j++));
            }
            scs.append(lcs.charAt(k++));
            i++; j++;
        }
        while (i < s1.length()) scs.append(s1.charAt(i++));
        while (j < s2.length()) scs.append(s1.charAt(j++));
        return new ShortestCommonSupersequenceOutput(scs.toString());
    }

    @Override
    public ShortestCommonSupersequenceInput takeInput() {
        System.out.println("Enter the first string");
        String s1 = scanner.nextLine();
        System.out.println("Enter the second string");
        String s2 = scanner.nextLine();
        return new ShortestCommonSupersequenceInput(s1, s2);
    }

    @Override
    public void display(ShortestCommonSupersequenceOutput content) {
        System.out.println("Shortest Common super-sequence is " + content.result);
    }

    private String getLCS(String s1, String s2) {
        return new LongestCommonSubsequenceContent()
                .solve(new LongestCommonSubsequenceContentInput(s1, s2))
                .result;
    }
}


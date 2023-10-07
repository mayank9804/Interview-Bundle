package com.codr.leetcodequestions.dp.MCM.medium.PalindromePartitioning;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.MCM.medium.PalindromePartitioning.data.PalindromePartitioningInput;
import com.codr.leetcodequestions.dp.MCM.medium.PalindromePartitioning.data.PalindromePartitioningOutput;

public class PalindromePartitioning extends Question<PalindromePartitioningOutput, PalindromePartitioningInput> {

    @Override
    public PalindromePartitioningOutput solve(PalindromePartitioningInput input) {
        String s = input.input;
        int n = s.length();
        int minPartition = recurse(s, 0, n-1);
        return new PalindromePartitioningOutput(minPartition);
    }

    @Override
    public PalindromePartitioningInput takeInput() {
        System.out.println("Enter the string");
        String input = scanner.nextLine();
        return new PalindromePartitioningInput(input);
    }

    @Override
    public void display(PalindromePartitioningOutput content) {
        System.out.println("Minimum number of partition needed is " + content.minPartition);
    }

    private int recurse(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        int minPartition = Integer.MAX_VALUE;
        for (int idx = i; idx < j; idx++) {
            int cuts = 1;
            cuts += recurse(s, i, idx);
            cuts += recurse(s, idx + 1, j);
            minPartition = Math.min(minPartition, cuts);
        }
        return minPartition;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i <= j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i > j;
    }
}


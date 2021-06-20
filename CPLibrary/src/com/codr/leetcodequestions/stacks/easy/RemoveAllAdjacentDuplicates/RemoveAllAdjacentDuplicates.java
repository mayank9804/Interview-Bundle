package com.codr.leetcodequestions.stacks.easy.RemoveAllAdjacentDuplicates;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.easy.RemoveAllAdjacentDuplicates.data.RemoveAllAdjacentDuplicatesInput;
import com.codr.leetcodequestions.stacks.easy.RemoveAllAdjacentDuplicates.data.RemoveAllAdjacentDuplicatesOutput;
import com.codr.leetcodequestions.stacks.easy.RemoveOutermostParentheses.data.RemoveOutermostParenthesesInput;
import com.codr.leetcodequestions.stacks.easy.RemoveOutermostParentheses.data.RemoveOutermostParenthesesOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 *
 * Examples -
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 */
public class RemoveAllAdjacentDuplicates extends Question<RemoveAllAdjacentDuplicatesOutput, RemoveAllAdjacentDuplicatesInput> {

    Scanner scanner = new Scanner(System.in);

    @Override
    public RemoveAllAdjacentDuplicatesOutput solve(RemoveAllAdjacentDuplicatesInput input) {

        Stack<Character> stack = new Stack<>();
        RemoveAllAdjacentDuplicatesOutput output = new RemoveAllAdjacentDuplicatesOutput("");
        stack.add(input.testString.charAt(0));
        for (int i = 1; i < input.testString.length(); i++) {
            if (stack.empty()) stack.push(input.testString.charAt(i));
            else if (!stack.empty()) {
                if (!stack.peek().equals(input.testString.charAt(i))) stack.push(input.testString.charAt(i));
                else stack.pop();
            }
        }

        List<Character> modifiedString = new ArrayList<>();
        while (!stack.empty()) {
            modifiedString.add(stack.peek());
            stack.pop();
        }
        Collections.reverse(modifiedString);
        modifiedString.forEach(character -> output.modifiedString = output.modifiedString + character);
        return output;
    }

    @Override
    public RemoveAllAdjacentDuplicatesInput takeInput() {
        return new RemoveAllAdjacentDuplicatesInput(scanner.next());
    }

    @Override
    public void display(RemoveAllAdjacentDuplicatesOutput content) {
        System.out.println(content.modifiedString);
    }
}
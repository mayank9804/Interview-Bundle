package com.codr.leetcodequestions.stacks.easy.RemoveOutermostParentheses;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.easy.RemoveOutermostParentheses.data.RemoveOutermostParenthesesInput;
import com.codr.leetcodequestions.stacks.easy.RemoveOutermostParentheses.data.RemoveOutermostParenthesesOutput;

import java.util.Scanner;
import java.util.Stack;

/**
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
 *
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 *
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 *
 * Examples -
 *
 * Example 1:
 *
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 */
public class RemoveOutermostParentheses extends Question<RemoveOutermostParenthesesOutput, RemoveOutermostParenthesesInput> {

    Scanner scanner = new Scanner(System.in);

    @Override
    public RemoveOutermostParenthesesOutput solve(RemoveOutermostParenthesesInput input) {
        String parenthesesString = input.parentheses;
        StringBuilder modifiedString = new StringBuilder();
        int count = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < parenthesesString.length(); i++) {
            if (parenthesesString.charAt(i) == '(') {
                count += 1;
            } else if (parenthesesString.charAt(i) == ')') {
                count -= 1;
            }
            if (count == 0) {
                modifiedString.append(parenthesesString, start + 1, end);
                start = end + 1;
            }
            end += 1;
        }
        return new RemoveOutermostParenthesesOutput(modifiedString.toString());
    }

    @Override
    public RemoveOutermostParenthesesInput takeInput() {
         return new RemoveOutermostParenthesesInput(scanner.next());
    }

    @Override
    public void display(RemoveOutermostParenthesesOutput content) {
        System.out.println(content.primitiveDecomposedParentheses);
    }
}

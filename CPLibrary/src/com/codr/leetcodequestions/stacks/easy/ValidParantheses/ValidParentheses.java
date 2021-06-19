package com.codr.leetcodequestions.stacks.easy.ValidParantheses;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.easy.ValidParantheses.data.ValidParenthesesInputModel;
import com.codr.leetcodequestions.stacks.easy.ValidParantheses.data.ValidParenthesesOutputModel;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses extends Question<ValidParenthesesOutputModel, ValidParenthesesInputModel> {

    // TODO: Switch to Reader class.
    private Scanner inputScanner = new Scanner(System.in);

    @Override
    public ValidParenthesesOutputModel solve(ValidParenthesesInputModel input) {
        String parenthesesString = input.getParenthesesString();
        Stack<Character> characterStack = new Stack<>();
        characterStack.add(parenthesesString.charAt(0));
        for (int i = 1; i < parenthesesString.length(); i++) {
            if(!characterStack.empty() && anyMatch(characterStack.peek(), parenthesesString.charAt(i))) {
                characterStack.pop();
            } else {
                characterStack.add(parenthesesString.charAt(i));
            }
        }
        return new ValidParenthesesOutputModel(characterStack.empty());
    }

    @Override
    public void display(ValidParenthesesOutputModel outputModel) {
        System.out.println(outputModel.isValid());
    }

    @Override
    public ValidParenthesesInputModel takeInput() {
        ValidParenthesesInputModel input = new ValidParenthesesInputModel();
        String parentheses = inputScanner.nextLine();
        input.setParenthesesString(parentheses);
        return input;
    }

    private boolean anyMatch(Character stackPeek, Character streamPeek) {
        return (stackPeek == '(' && streamPeek == ')' ||
                stackPeek == '{' && streamPeek == '}' ||
                stackPeek == '[' && streamPeek == ']');
    }
}
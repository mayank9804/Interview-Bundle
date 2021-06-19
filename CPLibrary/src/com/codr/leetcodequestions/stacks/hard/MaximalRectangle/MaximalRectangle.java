package com.codr.leetcodequestions.stacks.hard.MaximalRectangle;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.hard.MaximalRectangle.data.MaximalRectangleInput;
import com.codr.leetcodequestions.stacks.hard.MaximalRectangle.data.MaximalRectangleOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MaximalRectangle extends Question<MaximalRectangleOutput, MaximalRectangleInput> {

    Scanner scanner = new Scanner(System.in);

    @Override
    public MaximalRectangleOutput solve(MaximalRectangleInput input) {
        int[][] matrix = input.getMatrix();
        if (matrix.length == 0) return new MaximalRectangleOutput(0);
        int[] prefix = matrix[0];
        int maximalRectangle = findMaximumRectangle(prefix);
        for(int i = 1; i < input.getRows(); i++) {
            for (int j = 0; j < input.getColumn(); j++) {
                if (matrix[i][j] == 0) prefix[j] = 0;
                else prefix[j] = matrix[i][j] + prefix[j];
            }
            maximalRectangle = Math.max(maximalRectangle, findMaximumRectangle(prefix));
        }
        return new MaximalRectangleOutput(maximalRectangle);
    }

    @Override
    public MaximalRectangleInput takeInput() {
        MaximalRectangleInput maximalRectangleInput = new MaximalRectangleInput();
        int rows = scanner.nextInt();
        int column = scanner.nextInt();
        maximalRectangleInput.setRows(rows);
        maximalRectangleInput.setColumn(column);
        maximalRectangleInput.setMatrix(new int[rows][column]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                maximalRectangleInput.getMatrix()[i][j] = scanner.nextInt();
            }
        }
        return maximalRectangleInput;
    }

    @Override
    public void display(MaximalRectangleOutput content) {
        System.out.println(content.getMaximalRectangle());
    }

    private int findMaximumRectangle(int[] prefix) {
        int maxRectangle = -1;
        Map<Integer, Integer> prevNearestSmallerElements = computePrevNearestSmallerElements(prefix);
        Map<Integer, Integer> nextNearestSmallerElements = computeNextNearestSmallerElements(prefix);
        for (int i = 0; i < prefix.length; i++) {
            int prevNearestSmallerElementIndex = prevNearestSmallerElements.getOrDefault(i, 0);
            int nextNearestSmallerElementIndex = nextNearestSmallerElements.getOrDefault(i, prefix.length - 1);
            maxRectangle = Math.max(maxRectangle, (nextNearestSmallerElementIndex - prevNearestSmallerElementIndex + 1) * prefix[i]);
        }
        return maxRectangle;
    }

    private Map<Integer, Integer> computeNextNearestSmallerElements(int[] rectangles) {
        Map<Integer, Integer> nextNearestSmallerElements = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < rectangles.length; i++) {
            while (!stack.empty() && rectangles[stack.peek()] > rectangles[i]) {
                nextNearestSmallerElements.put(stack.peek(), i-1);
                stack.pop();
            }
            stack.push(i);
        }
        return nextNearestSmallerElements;
    }

    private Map<Integer, Integer> computePrevNearestSmallerElements(int[] rectangles) {
        Map<Integer, Integer> prevNearestSmallerElements = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = rectangles.length-1; i >= 0 ; i--) {
            while (!stack.empty() && rectangles[stack.peek()] > rectangles[i]) {
                prevNearestSmallerElements.put(stack.peek(), i+1);
                stack.pop();
            }
            stack.push(i);
        }
        return prevNearestSmallerElements;
    }
}

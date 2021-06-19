package com.codr.leetcodequestions.stacks.hard.LargestRectangleInHistogram;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.hard.LargestRectangleInHistogram.data.LargestRectangleInHistogramInput;
import com.codr.leetcodequestions.stacks.hard.LargestRectangleInHistogram.data.LargestRectangleInHistogramOutput;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 *
 * Examples:
 *
 * Example 1:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class LargestRectangleInHistogram extends Question<LargestRectangleInHistogramOutput, LargestRectangleInHistogramInput> {

    Scanner scanner = new Scanner(System.in);

    @Override
    public LargestRectangleInHistogramOutput solve(LargestRectangleInHistogramInput input) {
        List<Integer> rectangles = input.getRectanglesHeight();
        int totalRectangles = input.getTotalRectangles();

        Map<Integer, Integer> nextNearestSmallerElements = computeNextNearestSmallerElements(rectangles);
        Map<Integer, Integer> prevNearestSmallerElements = computePrevNearestSmallerElements(rectangles);

        int largestRectangleWidth = -1;
        for (int i = 0; i < totalRectangles; i++) {
            int nextNearestSmallerElementIndex = nextNearestSmallerElements.getOrDefault(i, totalRectangles-1);
            int prevNearestSmallerElementIndex = prevNearestSmallerElements.getOrDefault(i, 0);
            largestRectangleWidth = Math.max(largestRectangleWidth, (nextNearestSmallerElementIndex - prevNearestSmallerElementIndex + 1) * rectangles.get(i));
        }
        return new LargestRectangleInHistogramOutput(largestRectangleWidth);
    }

    @Override
    public LargestRectangleInHistogramInput takeInput() {
        int totalBuildings = scanner.nextInt();
        List<Integer> buildingHeights = new ArrayList<>();
        for (int i = 0; i < totalBuildings ; i++) {
            buildingHeights.add(scanner.nextInt());
        }
        return new LargestRectangleInHistogramInput(buildingHeights, totalBuildings);
    }

    @Override
    public void display(LargestRectangleInHistogramOutput content) {
        System.out.println(content.getLargestRectangleWidth());
    }

    private Map<Integer, Integer> computeNextNearestSmallerElements(List<Integer> rectangles) {
        Map<Integer, Integer> nextNearestSmallerElements = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < rectangles.size(); i++) {
            while (!stack.empty() && rectangles.get(stack.peek()) > rectangles.get(i)) {
                nextNearestSmallerElements.put(stack.peek(), i-1);
                stack.pop();
            }
            stack.push(i);
        }
        return nextNearestSmallerElements;
    }

    private Map<Integer, Integer> computePrevNearestSmallerElements(List<Integer> rectangles) {
        Map<Integer, Integer> prevNearestSmallerElements = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = rectangles.size()-1; i >= 0 ; i--) {
            while (!stack.empty() && rectangles.get(stack.peek()) > rectangles.get(i)) {
                prevNearestSmallerElements.put(stack.peek(), i+1);
                stack.pop();
            }
            stack.push(i);
        }
        return prevNearestSmallerElements;
    }
}

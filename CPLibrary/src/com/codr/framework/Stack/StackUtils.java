package com.codr.framework.Stack;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Utility class for common stack usecases.
 * Eg: Next Greater Element etc.
 */
public class StackUtils {
    private StackUtils () { }

    /**
     * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
     * @param input
     * @return
     */
    public static List<Integer> computeNextGreaterElements(final List<Integer> input) {
        if (input.isEmpty()) return input;
        AtomicInteger integer = new AtomicInteger(0);

        List<Pair<Integer, Integer>> indexedInput = new ArrayList<>();
        for (Integer e : input) {
            indexedInput.add(new Pair<>(e, integer.getAndIncrement()));
        }

        Integer[] result = new Integer[input.size()];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(indexedInput.get(0)); //1,0

        for (int i = 1; i < indexedInput.size(); i++) {
            while (!stack.empty() && indexedInput.get(i).getKey() > stack.peek().getKey()) {
                result[stack.peek().getValue()] = indexedInput.get(i).getKey();
                stack.pop();
            }
            stack.push(indexedInput.get(i));
        }

        while (!stack.empty()) {
            result[stack.peek().getValue()] = -1;
            stack.pop();
        }

        return Arrays.asList(result);
    }
}

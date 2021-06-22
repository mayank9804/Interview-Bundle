package com.codr.leetcodequestions.stacks.easy.MinStack;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.easy.MinStack.data.MinStackInput;
import com.codr.leetcodequestions.stacks.easy.MinStack.data.MinStackOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
public class MinStack extends Question<MinStackOutput, MinStackInput> {
    @Override
    public MinStackOutput solve(MinStackInput input) {
        Queue<Integer> queue1 = new LinkedList<>();
        ((LinkedList<Integer>) queue1).pop();
        List<Integer> minimums = new ArrayList<>();
        input.minStack.push(-2);
        input.minStack.push(0);
        input.minStack.push(-3);
        minimums.add((Integer) input.minStack.getMin());
        input.minStack.pop();
        minimums.add((Integer) input.minStack.getMin());
        return new MinStackOutput(minimums);
    }

    @Override
    public MinStackInput takeInput() {
        return new MinStackInput(new com.codr.framework.Stack.MinStack());
    }

    @Override
    public void display(MinStackOutput content) {
        System.out.println(content.minimums);
    }
}
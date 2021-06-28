package com.codr.framework.Stack;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Stack;

/**
 * Stack that supports finding minimum element in O(1) time.
 */
public class MinStack<T extends Number> implements Comparator<Number>, com.codr.framework.Stack.Stack<T> {
    Stack <T> primaryStack;
    Stack <T> auxiliaryStack;

    public MinStack() {
        primaryStack = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    /**
     * Push an element in primary stack.
     * @param val
     */
    @Override
    public void push(T val) {
        primaryStack.push(val);
        if (auxiliaryStack.empty() || compare(val, auxiliaryStack.peek()) == 0 || compare(val, auxiliaryStack.peek()) == -1) auxiliaryStack.push(val);
    }

    /**
     * Pops an element from the primary stack.
     */
    public void pop() {
        T val = primaryStack.peek();
        primaryStack.pop();
        if (!auxiliaryStack.empty() && auxiliaryStack.peek() == val) auxiliaryStack.pop();
    }

    /**
     * Gives the top element of the primary stack.
     * @return
     */
    @Override
    public T top() {
        return primaryStack.peek();
    }

    /**
     * Find the minimum element in a stack at any given time, using auxiliary stack.
     * @return
     */
    public T getMin() {
        return auxiliaryStack.peek();
    }

    @Override
    public int compare(Number a, Number b) {
        return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
    }
}

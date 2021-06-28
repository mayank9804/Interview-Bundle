package com.codr.framework.Stack;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Stack;

/**
 * Stack which tells us Max element in a stream of inputs, in constant time, by taxing other operations.
 * @param <T>
 */
public class MaxStack<T extends Number> implements Comparator<T>, com.codr.framework.Stack.Stack<T> {

    public Stack<T> primaryStack;
    public Stack<T> auxiliaryStack;

    public MaxStack() {
        this.primaryStack = new Stack<>();
        this.auxiliaryStack = new Stack<>();
    }

    @Override
    public void push(T element) {
        primaryStack.add(element);
        if (auxiliaryStack.empty()) {
            auxiliaryStack.add(element);
        } else {
            int cmp = compare(element, auxiliaryStack.peek());
            if (cmp >= 0) auxiliaryStack.add(element);
        }
    }

    public void pop() {
        T poppedElement = primaryStack.pop();
        if (!auxiliaryStack.empty()) {
            if (compare(poppedElement, auxiliaryStack.peek()) == 0) auxiliaryStack.pop();
        }
    }

    @Override
    public T top() {
        return primaryStack.peek();
    }

    /**
     * Tells the max element in stack.
     * Assumes, there exists atleast one element in stack.
     * @return
     */
    public T getMax() {
        return auxiliaryStack.peek();
    }

    @Override
    public int compare(T a, T b) {
        return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
    }
}

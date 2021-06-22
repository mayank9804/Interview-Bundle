package com.codr.framework.Stack;

import java.util.Stack;

/**
 * Implementation of queue, using stacks.
 */
public class QueueUsingStacks<T extends Number> implements Queue {

    Stack<T> stack1;
    Stack<T> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(T x) {
        stack1 = reverse(stack2);
        stack1.add(x);
        stack2 = reverse(stack1);
    }

    /** Removes the element from in front of queue and returns that element. */
    public T pop() {
        return stack2.pop();
    }

    /** Get the front element. */
    public T peek() {
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.empty();
    }

    private Stack<T> reverse(final Stack<T> stack) {
        final Stack<T> src = (Stack<T>) stack.clone();
        Stack<T> aux = new Stack<>();
        while (!src.empty()) {
            aux.add(src.pop());
        }
        return aux;
    }
}

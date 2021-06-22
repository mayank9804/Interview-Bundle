package com.codr.framework.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Stack using two queues.
 */
public class StackUsingQueues<T> implements Stack {
    Queue<T> queue1;
    Queue<T> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     * @param x
     */
    public void push(T x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public T pop() {
        T popElement = null;

        while(!queue1.isEmpty()) {
            if (queue1.size() > 1) queue2.add(queue1.peek());
            popElement = ((LinkedList<T>) queue1).pop();
        }
        move(queue2, queue1);
        return popElement;
    }

    /** Get the top element. */
    public T top() {
        T top = move(queue1, queue2);
        move(queue2, queue1);
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    private T move(Queue<T> from, Queue<T> to) {
        T top = null;
        while(!from.isEmpty()) {
            to.add(from.peek());
            top = ((LinkedList<T>) from).pop();
        }
        return top;
    }
}

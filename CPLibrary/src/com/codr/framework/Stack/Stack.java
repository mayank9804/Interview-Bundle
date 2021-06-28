package com.codr.framework.Stack;

/**
 * Base interface for stacks.
 */
public interface Stack<T extends Number> {

    void push(T element);

    T top();
}

package com.codr.framework;

/**
 * Interface that will be implemented by each solution to format the expected output.
 * @param <T>
 */
public interface Visualizer<T> {
    void display(T content);
}

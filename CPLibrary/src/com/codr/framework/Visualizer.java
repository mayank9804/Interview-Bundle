package com.codr.framework;

/**
 * Abstract class that will be extended by different kind of content displayers.
 * @param <T>
 */
public interface Visualizer<T> {
    void display(T content);
}

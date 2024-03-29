package com.codr.framework;

import java.util.Scanner;

/**
 * Abstract class which will be extended by each Question.
 * @param <T>
 */
public abstract class Question<T, U>  implements Visualizer<T>{

    protected Scanner scanner = new Scanner(System.in);

    public abstract T solve(U input);

    public  void process(int testcase) {
        for (int i = 0; i < testcase; i++) {
            U input = takeInput();
            T output = solve(input);
            display(output);
        }
    }

    public abstract U takeInput();
}

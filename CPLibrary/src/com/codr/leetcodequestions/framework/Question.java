package com.codr.leetcodequestions.framework;

/**
 * Interface which will be modelled by each Question.
 * @param <T>
 */
public abstract class Question<T, U>  implements Visualizer<T>{

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

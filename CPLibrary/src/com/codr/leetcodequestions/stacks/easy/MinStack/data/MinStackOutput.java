package com.codr.leetcodequestions.stacks.easy.MinStack.data;

import java.util.List;

/**
 * Output data model for question {@link com.codr.leetcodequestions.stacks.easy.MinStack.MinStack}
 */
public class MinStackOutput {
    public List<Integer> minimums;

    public MinStackOutput(List<Integer> minimums) {
        this.minimums = minimums;
    }
}
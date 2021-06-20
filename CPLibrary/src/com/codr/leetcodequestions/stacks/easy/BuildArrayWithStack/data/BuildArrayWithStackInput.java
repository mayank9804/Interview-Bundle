package com.codr.leetcodequestions.stacks.easy.BuildArrayWithStack.data;

import java.util.List;

/**
 * Input model for question {@link com.codr.leetcodequestions.stacks.easy.BuildArrayWithStack.BuildArrayWithStack}.
 */
public class BuildArrayWithStackInput {
    public int n;
    public List<Integer> target;

    public BuildArrayWithStackInput(int n, List<Integer> target) {
        this.n = n;
        this.target = target;
    }

    public BuildArrayWithStackInput() {}
}
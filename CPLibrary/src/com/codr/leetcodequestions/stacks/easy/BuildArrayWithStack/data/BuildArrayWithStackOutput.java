package com.codr.leetcodequestions.stacks.easy.BuildArrayWithStack.data;

import java.util.List;

/**
 * Output model for question {@link com.codr.leetcodequestions.stacks.easy.BuildArrayWithStack.BuildArrayWithStack}.
 */
public class BuildArrayWithStackOutput {
    public List<String> stackOperations;

    public BuildArrayWithStackOutput(List<String> stackOperations) {
        this.stackOperations = stackOperations;
    }

    public BuildArrayWithStackOutput() {}

    @Override
    public String toString() {
        String stringRepresentation = "[\"";
        for (int i = 0; i < stackOperations.size(); i++) {
            String operation = stackOperations.get(i);
            stringRepresentation += operation;
            stringRepresentation += "\"";
            if (i == stackOperations.size() - 1) stringRepresentation += "]";
            else stringRepresentation += ",";
        }
        return stringRepresentation;
    }
}
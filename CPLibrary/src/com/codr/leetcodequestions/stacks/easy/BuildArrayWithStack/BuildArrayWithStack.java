package com.codr.leetcodequestions.stacks.easy.BuildArrayWithStack;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.easy.BuildArrayWithStack.data.BuildArrayWithStackInput;
import com.codr.leetcodequestions.stacks.easy.BuildArrayWithStack.data.BuildArrayWithStackOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.
 *
 * Build the target array using the following operations:
 *
 * Push: Read a new element from the beginning list, and push it in the array.
 * Pop: delete the last element of the array.
 * If the target array is already built, stop reading more elements.
 * Return the operations to build the target array. You are guaranteed that the answer is unique.
 *
 * Constraints:
 *
 * 1 <= target.length <= 100
 * 1 <= target[i] <= n
 * 1 <= n <= 100
 * target is strictly increasing.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: target = [1,3], n = 3
 * Output: ["Push","Push","Pop","Push"]
 * Explanation:
 * Read number 1 and automatically push in the array -> [1]
 * Read number 2 and automatically push in the array then Pop it -> [1]
 * Read number 3 and automatically push in the array -> [1,3]
 *
 */
public class BuildArrayWithStack extends Question<BuildArrayWithStackOutput, BuildArrayWithStackInput> {

    Scanner scanner = new Scanner(System.in);

    @Override
    public BuildArrayWithStackOutput solve(BuildArrayWithStackInput input) {
        BuildArrayWithStackOutput output = new BuildArrayWithStackOutput();
        List<String> operations = new ArrayList<>();
        for(int i = 1; i <= input.target.get(input.target.size() - 1); i++) {
            operations.add("PUSH");
            if (!input.target.contains(i)) operations.add("POP");
        }
        output.stackOperations = operations;
        return output ;
    }

    @Override
    public BuildArrayWithStackInput takeInput() {
        BuildArrayWithStackInput input = new BuildArrayWithStackInput();
        input.n = scanner.nextInt();
        int numberOfElements = scanner.nextInt();
        input.target = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            input.target.add(scanner.nextInt());
        }
        return input;
    }

    @Override
    public void display(BuildArrayWithStackOutput content) {
        System.out.println(content.toString());
    }
}
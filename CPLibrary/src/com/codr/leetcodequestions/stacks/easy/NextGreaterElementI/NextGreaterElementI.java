package com.codr.leetcodequestions.stacks.easy.NextGreaterElementI;

import com.codr.framework.Question;
import com.codr.framework.Stack.StackUtils;
import com.codr.leetcodequestions.stacks.easy.NextGreaterElementI.data.NextGreaterElementIInput;
import com.codr.leetcodequestions.stacks.easy.NextGreaterElementI.data.NextGreaterElementIOutput;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 *
 */
public class NextGreaterElementI extends Question<NextGreaterElementIOutput, NextGreaterElementIInput> {

    Scanner scanner = new Scanner(System.in);

    @Override
    public NextGreaterElementIOutput solve(NextGreaterElementIInput input) {
        AtomicInteger integer = new AtomicInteger(0);
        Map<Integer, Integer> indexedInput = new HashMap<>();
        for (Integer e: input.nums2) {
            indexedInput.put(e, integer.getAndIncrement());
        }
        List<Integer> answer = new ArrayList<>();
        List<Integer> ngeS = StackUtils.computeNextGreaterElements(Arrays.asList(input.nums2));
        for (Integer num : input.nums1) {
            int index = indexedInput.get(num);
            int nge = ngeS.get(index);
            answer.add(nge);
        }
        return new NextGreaterElementIOutput(answer);
    }

    @Override
    public NextGreaterElementIInput takeInput() {
        int size1 = scanner.nextInt();
        NextGreaterElementIInput input = new NextGreaterElementIInput();
        input.nums1 = new Integer[size1];
        for (int i = 0; i < size1; i++) {
            input.nums1[i] = scanner.nextInt();
        }
        int size2 = scanner.nextInt();
        input.nums2 = new Integer[size2];
        for (int i = 0; i < size2; i++) {
            input.nums2[i] = scanner.nextInt();
        }
        return input;
    }

    @Override
    public void display(NextGreaterElementIOutput content) {
        System.out.println(content.numsOutput);
    }
}
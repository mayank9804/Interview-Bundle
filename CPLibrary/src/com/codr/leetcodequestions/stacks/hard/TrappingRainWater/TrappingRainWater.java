package com.codr.leetcodequestions.stacks.hard.TrappingRainWater;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.hard.TrappingRainWater.data.TrappingRainWaterInput;
import com.codr.leetcodequestions.stacks.hard.TrappingRainWater.data.TrappingRainWaterOutput;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TrappingRainWater extends Question<TrappingRainWaterOutput, TrappingRainWaterInput> {

    // TODO: Switch to Reader class.
    private Scanner inputScanner = new Scanner(System.in);

    @Override
    public TrappingRainWaterOutput solve(TrappingRainWaterInput input) {
        int unitsOfWaterTrapped = 0;
        int totalBuildings = input.getTotalBuildings();
        if (totalBuildings < 3) return new TrappingRainWaterOutput(unitsOfWaterTrapped);

        List<Integer> buildingHeights = input.getHeightOfBuildings();

        List<Pair<Integer, Integer>> leftMaximums = computeLeftMaxPrefix(totalBuildings, buildingHeights);
        List<Pair<Integer, Integer>> rightMaximums = computeRightMaxPrefix(totalBuildings, buildingHeights);

        for(int i=0; i < totalBuildings; i++) {
            Pair<Integer, Integer> leftMaxHeightBuilding = leftMaximums.get(i);
            Pair<Integer, Integer> rightMaxHeightBuilding = rightMaximums.get(i);
            boolean willCurrentBuildingHoldWater = willCurrentBuildingHoldWater(leftMaxHeightBuilding.getKey(), rightMaxHeightBuilding.getKey(), i);
            // For current building, min height of both sides will control the unit of water trapped;
            if (willCurrentBuildingHoldWater) {
                int controllingHeight = Math.min(leftMaxHeightBuilding.getValue(), rightMaxHeightBuilding.getValue());
                unitsOfWaterTrapped += controllingHeight - buildingHeights.get(i);
            }
        }
        return new TrappingRainWaterOutput(unitsOfWaterTrapped);
    }

    @Override
    public TrappingRainWaterInput takeInput() {
        int totalBuildings = inputScanner.nextInt();
        TrappingRainWaterInput input = new TrappingRainWaterInput(totalBuildings);
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < totalBuildings; i++) {
            int height = inputScanner.nextInt();
            heights.add(height);
        }
        input.setHeightOfBuildings(heights);
        return input;
    }

    @Override
    public void display(TrappingRainWaterOutput content) {
        System.out.println(content.getUnitsOfWaterTrapped());
    }

    private List<Pair<Integer, Integer>> computeLeftMaxPrefix(int totalBuildings, List<Integer> buildingHeights) {
        List<Pair<Integer, Integer>> leftMaxPrefix  = new ArrayList<>();
        leftMaxPrefix.add(new Pair<>(0, buildingHeights.get(0)));
        for (int i = 1; i < totalBuildings; i++) {
            if (buildingHeights.get(i) >= leftMaxPrefix.get(i-1).getValue()) {
                leftMaxPrefix.add(new Pair<>(i, buildingHeights.get(i)));
            } else {
                leftMaxPrefix.add(leftMaxPrefix.get(i-1));
            }
        }
        return leftMaxPrefix;
    }

    private List<Pair<Integer, Integer>> computeRightMaxPrefix(int totalBuildings, List<Integer> buildingHeights) {
        Pair<Integer, Integer>[] rightMaxPrefix  = new Pair[totalBuildings];
        rightMaxPrefix[totalBuildings-1] = new Pair<>(totalBuildings - 1, buildingHeights.get(totalBuildings - 1));
        for (int i = totalBuildings - 2; i >= 0; i--) {
            if (buildingHeights.get(i) >= rightMaxPrefix[i+1].getValue()) {
                rightMaxPrefix[i] = new Pair<>(i, buildingHeights.get(i));
            } else {
                rightMaxPrefix[i] = rightMaxPrefix[i+1];
            }
        }
        return Arrays.asList(rightMaxPrefix);
    }

    private boolean willCurrentBuildingHoldWater(int leftBoundingBuildingIndex, int rightBoundingBuildingIndex, int currentIndex) {
        return (currentIndex != leftBoundingBuildingIndex && currentIndex != rightBoundingBuildingIndex);
    }
}

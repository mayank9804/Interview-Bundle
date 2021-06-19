package com.codr.leetcodequestions.stacks.hard.TrappingRainWater.data;

import java.util.List;

/**
 * Input model for {@link com.codr.leetcodequestions.stacks.hard.TrappingRainWater.TrappingRainWater}.
 */
public class TrappingRainWaterInput {
    /**
     * Denotes the building heights.
     */
    List<Integer> heightOfBuildings;
    /**
     * Denotes the total number of buildings.
     */
    int totalBuildings;

    public List<Integer> getHeightOfBuildings() {
        return heightOfBuildings;
    }

    public void setHeightOfBuildings(List<Integer> heightOfBuildings) {
        this.heightOfBuildings = heightOfBuildings;
    }

    public int getTotalBuildings() {
        return totalBuildings;
    }

    public void setTotalBuildings(int totalBuildings) {
        this.totalBuildings = totalBuildings;
    }

    public TrappingRainWaterInput(List<Integer> heightOfBuildings, int totalBuildings) {
        this.heightOfBuildings = heightOfBuildings;
        this.totalBuildings = totalBuildings;
    }

    public TrappingRainWaterInput(List<Integer> heightOfBuildings) {
        this.heightOfBuildings = heightOfBuildings;
    }

    public TrappingRainWaterInput(int totalBuildings) {
        this.totalBuildings = totalBuildings;
    }
}

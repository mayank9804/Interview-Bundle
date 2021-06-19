package com.codr.leetcodequestions.stacks.hard.LargestRectangleInHistogram.data;

import java.util.List;

/**
 * Input model for {@link com.codr.leetcodequestions.stacks.hard.LargestRectangleInHistogram.LargestRectangleInHistogram}.
 */
public class LargestRectangleInHistogramInput {
    private List<Integer> rectanglesHeight;
    private int totalRectangles;

    public List<Integer> getRectanglesHeight() {
        return rectanglesHeight;
    }

    public void setRectanglesHeight(List<Integer> rectanglesHeight) {
        this.rectanglesHeight = rectanglesHeight;
    }

    public int getTotalRectangles() {
        return totalRectangles;
    }

    public void setTotalRectangles(int totalRectangles) {
        this.totalRectangles = totalRectangles;
    }

    public LargestRectangleInHistogramInput(List<Integer> rectanglesHeight, int totalRectangles) {
        this.rectanglesHeight = rectanglesHeight;
        this.totalRectangles = totalRectangles;
    }
}

package com.codr.leetcodequestions.stacks.hard.MaximalRectangle.data;

/**
 * Input Model for {@link com.codr.leetcodequestions.stacks.hard.MaximalRectangle.MaximalRectangle}.
 */
public class MaximalRectangleInput {
    private int rows;
    private int column;
    private int[][] matrix;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public MaximalRectangleInput(int rows, int column, int[][] matrix) {
        this.rows = rows;
        this.column = column;
        this.matrix = matrix;
    }

    public MaximalRectangleInput() {}
}

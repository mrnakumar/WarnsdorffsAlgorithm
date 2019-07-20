package com.knight.assignment;

/**
 * Defines a knight's move. For example, 2 row down, 1 column right.
 */
public class Move {
    private final int columnDelta;
    private final int rowDelta;


    public Move(final int rowDelta, final int columnDelta) {
        this.rowDelta = rowDelta;
        this.columnDelta = columnDelta;
    }

    public int getColumnDelta() {
        return columnDelta;
    }

    public int getRowDelta() {
        return rowDelta;
    }
}

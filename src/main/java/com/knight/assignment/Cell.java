package com.knight.assignment;

/**
 * Represents a position on board.
 * <p>
 * Row and columns are distances in x and y direction on board relative to top left corner (0,0).
 */
public class Cell {
    private final int row;
    private final int column;

    public Cell(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     * Applies a move to this cell and returns a new cell, without modifying this cell.
     */
    public Cell apply(final Move move) {
        final int targetRow = getRow() + move.getRowDelta();
        final int targetColumn = getColumn() + move.getColumnDelta();
        return new Cell(targetRow, targetColumn);
    }

    @Override
    public String toString() {
        return "Cell[" + row + "," + column + "]";
    }
}

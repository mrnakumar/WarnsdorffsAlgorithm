package com.knight.assignment;

/**
 * Board on which our knight moves.
 * Every moves is recorded in the board by updating corresponding cell with move number.
 */
public class Board {
    private static final String NUMBER_VALIDATION_MSG_TEMPLATE = " %s can not be less than one";
    private static final int SMALLEST_MOVE_NUMBER = 1;
    private final int[][] space;

    public Board(final int numberOfRows, final int numberOfColumns) {
        final int minimumDimension = 1;
        validate(numberOfRows, minimumDimension, "rows");
        validate(numberOfColumns, minimumDimension, "columns");
        space = new int[numberOfRows][numberOfColumns];
    }

    public void recordMove(final Cell cell, final int moveNumber) {
        validateCell(cell);
        validate(moveNumber, SMALLEST_MOVE_NUMBER, "moveNumber");
        space[cell.getRow()][cell.getColumn()] = moveNumber;
    }


    public boolean isVisited(final Cell cell) {
        validateCell(cell);
        return space[cell.getRow()][cell.getColumn()] > 0;
    }

    public boolean isOutside(final Cell cell) {
        final boolean isRowOutOfRange = cell.getRow() < 0 || cell.getRow() >= space.length;
        final boolean isColumnOutOfRange = cell.getColumn() < 0 || cell.getColumn() >= space[0].length;
        return isRowOutOfRange || isColumnOutOfRange;
    }


    private void validate(final int number, final int lowerLimit, final String identifier) {
        if (number < lowerLimit) {
            throw new IllegalArgumentException(String.format(NUMBER_VALIDATION_MSG_TEMPLATE, identifier));
        }
    }

    private void validateCell(final Cell cell) {
        if (isOutside(cell)) {
            throw new IllegalArgumentException("Cell is not valid as it is outside of board.");
        }
    }

    /**
     * Finds all recorded moves and return as path.
     */
    public Path getPath() {
        final Path path = new Path();
        for (int row = 0; row < space.length; row++) {
            for (int column = 0; column < space[0].length; column++) {
                final int moveNumber = space[row][column];
                if (moveNumber >= SMALLEST_MOVE_NUMBER) {
                    path.addStep(moveNumber, new Cell(row, column));
                }
            }
        }
        return path;
    }
}

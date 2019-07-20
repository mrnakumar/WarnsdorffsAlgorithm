package com.knight.assignment;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    @DisplayName("empty board creation should fail")
    public void testCreateEmptyBoard() {
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 0));
    }

    @Test
    public void testIsVisited() {
        final Board board = new Board(10, 10);
        final Cell cell = new Cell(0, 0);
        assertFalse(board.isVisited(cell));
        board.recordMove(cell, 1);
        assertTrue(board.isVisited(cell));
    }

    @Test
    public void testIsOutside() {
        final Board board = new Board(10, 10);
        assertTrue(board.isOutside(new Cell(10, 10)));
        assertFalse(board.isOutside(new Cell(0, 0)));
    }

    @Test
    public void testGetPath() {
        final Board board = new Board(10, 10);
        assertTrue(board.getPath().getPrettyString().isEmpty());
        final Cell firstStep = new Cell(0, 0);
        board.recordMove(firstStep, 1);

        final Cell secondStep = new Cell(2, 2);
        board.recordMove(secondStep, 2);

        final Path expectedPath = new Path();
        expectedPath.addStep(1, firstStep);
        expectedPath.addStep(2, secondStep);

        final Path actualPath = board.getPath();
        assertEquals(actualPath.getPrettyString(), expectedPath.getPrettyString());
    }
}
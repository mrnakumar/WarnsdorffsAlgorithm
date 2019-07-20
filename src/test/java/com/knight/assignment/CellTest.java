package com.knight.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {

    @Test
    public void testApply() {
        final Cell cell = new Cell(0, 0);
        final Cell applied = cell.apply(new Move(1, 6));
        assertEquals(applied.getRow(), 1);
        assertEquals(applied.getColumn(), 6);
    }
}
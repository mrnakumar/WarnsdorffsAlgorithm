package com.knight.assignment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    public void testGetPrettyPrint() {
        final Path path = new Path();
        assertTrue(path.getSteps().isEmpty());
        final Cell firstStep = new Cell(0, 0);
        final Cell secondStep = new Cell(0, 1);
        path.addStep(2, secondStep);
        path.addStep(1, firstStep);
        final List<Cell> steps = path.getSteps();
        assertEquals(steps.get(0), firstStep);
        assertEquals(steps.get(1), secondStep);
    }

}
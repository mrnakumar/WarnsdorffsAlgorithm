package com.knight.assignment;

import com.knight.assignment.utils.BoardUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class KnightTourFinderIT {

    @Test
    public void test() {
        final int numberOfRowsInBoard = 10;
        final Random random = new Random();
        final int startRow = random.nextInt(numberOfRowsInBoard);
        final int startColumn = random.nextInt(numberOfRowsInBoard);
        final KnightTourFinder knightTourFinder = new KnightTourFinder(new Cell(startRow, startColumn), numberOfRowsInBoard);
        final Optional<Path> tour = knightTourFinder.findTour();
        tour.ifPresent(this::assertPathValidity);
    }

    private void assertPathValidity(final Path path) {
        final Move[] moves = BoardUtils.getMoves();
        final List<Cell> steps = path.getSteps();
        Cell previousPosition = steps.remove(0);
        for (final Cell currentPosition : steps) {
            assertTrue(Arrays.stream(moves)//
                    .map(previousPosition::apply)//
                    .anyMatch(cell -> cell.getRow() == currentPosition.getRow() && cell.getColumn() == currentPosition.getColumn()));
            previousPosition = currentPosition;
        }
    }
}
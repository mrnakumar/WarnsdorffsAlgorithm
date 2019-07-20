package com.knight.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A path represents the set of steps taken by Knight in some order.
 */
public class Path {

    private final Map<MoveNumber, Cell> steps;

    public Path() {
        steps = new HashMap<>();
    }

    public void addStep(final int moveNumber, final Cell step) {
        steps.put(new MoveNumber(moveNumber), step);
    }

    public List<Cell> getSteps() {
        return steps.keySet().stream()//
                .sorted()//
                .map(steps::get)//
                .collect(Collectors.toList());
    }

    public String getPrettyString() {
        return getSteps().stream()//
                .map(Cell::toString)//
                .collect(Collectors.joining(" --> "));
    }

    private static class MoveNumber implements Comparable<MoveNumber> {
        private final int moveNumber;

        private MoveNumber(final int moveNumber) {
            this.moveNumber = moveNumber;
        }

        public int getMoveNumber() {
            return moveNumber;
        }

        @Override
        public int hashCode() {
            return moveNumber;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj instanceof MoveNumber) {
                return ((MoveNumber) obj).getMoveNumber() == moveNumber;
            }
            return false;
        }

        @Override
        public int compareTo(final MoveNumber move) {
            return Integer.compare(moveNumber, move.getMoveNumber());
        }
    }
}

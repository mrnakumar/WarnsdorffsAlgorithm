package com.knight.assignment.utils;

import com.knight.assignment.Board;
import com.knight.assignment.Cell;
import com.knight.assignment.Move;

import java.util.Arrays;
import java.util.stream.Stream;

public class BoardUtils {
    private static final Move[] MOVES = {
            new Move(0, -3),
            new Move(2, -2),
            new Move(3, 0),
            new Move(2, 2),
            new Move(0, 3),
            new Move(-2, 2),
            new Move(-3, 0),
            new Move(-2, -2),
    };

    private BoardUtils() {
        //to prevent instantiation of utility class.
    }

    /**
     * Returns the accessibility of the cell passed as parameter.
     * <p>
     * Accessibility is defined as number of cells which are reachable from given cell, given
     * that those cells are unvisited.
     */
    public static long getAccessibility(final Board board, final Cell cell, final Move[] moves) {
        final Stream<Move> moveStream = Arrays.stream(moves);
        return moveStream.map(cell::apply)//
                .filter(targetCell -> !board.isOutside(targetCell))//
                .filter(targetCell -> !board.isVisited(targetCell))//
                .count();
    }

    public static Move[] getMoves() {
        final Move[] copy = new Move[MOVES.length];
        System.arraycopy(MOVES, 0, copy, 0, MOVES.length);
        return copy;
    }
}

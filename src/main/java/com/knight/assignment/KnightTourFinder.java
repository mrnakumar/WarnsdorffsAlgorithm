package com.knight.assignment;

import com.knight.assignment.utils.BoardUtils;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * The tour finder for the Knight.
 * <p>
 * The finder is always created for a given start position which means that the finder will
 * try to visit all cells in board starting from this position.
 */
public class KnightTourFinder {
    private static final int N_DEFAULT = 10; //work with bord of 10 * 10

    private final Board board;
    private final Cell startPosition;
    private final int numberOfRows;

    public KnightTourFinder(final Cell startPosition) {
        this(startPosition, N_DEFAULT);
    }

    public KnightTourFinder(final Cell startPosition, final int numberOfRows) {
        this.board = new Board(numberOfRows, numberOfRows);
        this.startPosition = startPosition;
        this.numberOfRows = numberOfRows;
    }

    /**
     * Try to find tour which covers all cells of board only once.
     * <p>
     * Path may not always exist.
     */
    public Optional<Path> findTour() {
        board.recordMove(startPosition, 1);
        final int totalMoves = numberOfRows * numberOfRows;
        Cell currentPosition = startPosition;
        for (int move = 2; move <= totalMoves; move++) {
            //decide which cell the knight should land on `move'th` move.
            final Optional<Cell> nextPosition = findNextPosition(currentPosition);
            if (!nextPosition.isPresent()) {
                return Optional.empty();
            } else {
                board.recordMove(nextPosition.get(), move);
                currentPosition = nextPosition.get();
            }
        }
        return Optional.of(board.getPath());
    }

    /**
     * Finds the next position reachable from current position,
     * such that the chosen position has minimum accessibility.
     * <p>
     * In case of multiple positions with same accessibility, one is chosen randomly with equal probability.
     */
    private Optional<Cell> findNextPosition(final Cell currentPosition) {
        final Move[] moves = BoardUtils.getMoves();
        final Map<Long, List<Tuple>> nextMoves = Arrays.stream(moves)//
                .map(currentPosition::apply)//
                .filter(targetPosition -> !board.isOutside(targetPosition))//
                .filter(targetPosition -> !board.isVisited(targetPosition))//
                .map(targetPosition -> new Tuple(targetPosition, BoardUtils.getAccessibility(board, targetPosition, moves)))
                .collect(Collectors.groupingBy(Tuple::getAccessibility));
        if (nextMoves.isEmpty()) {
            return Optional.empty();
        }
        final long smallestAccessibility = nextMoves.keySet().stream().sorted().findFirst().get();
        final List<Tuple> movesWithSmallestAccessibility = nextMoves.get(smallestAccessibility);

        //tie break
        return Optional.of(movesWithSmallestAccessibility.get(new Random().nextInt(movesWithSmallestAccessibility.size())).position);
    }

    private static class Tuple {
        private final Cell position;
        private final long accessibility;

        Tuple(final Cell position, final long accessibility) {
            this.position = position;
            this.accessibility = accessibility;
        }

        long getAccessibility() {
            return accessibility;
        }
    }
}
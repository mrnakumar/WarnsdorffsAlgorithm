package com.knight.assignment;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        final int n = 10; //square board dimension
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                final Cell startPosition = new Cell(row, column);
                final KnightTourFinder knightTourFinder = new KnightTourFinder(startPosition, n);
                final Optional<Path> path = knightTourFinder.findTour();
                if (path.isPresent()) {
                    System.out.println(path.get().getPrettyString());
                    return;
                }
            }
        }
        System.out.println("Could not find any tour.");
    }
}

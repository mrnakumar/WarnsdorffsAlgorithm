package com.knight.assignment.utils;

import com.knight.assignment.Board;
import com.knight.assignment.Cell;
import com.knight.assignment.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BoardUtilsTest {
    @Mock
    private Board board;

    @Mock
    private Cell initialPosition;

    @Mock
    private Cell cellRight;

    @Mock
    private Cell cellBelow;

    @Test
    @DisplayName("should return zero accessibility when no unvisited neighbour")
    public void testGetAccessibility_When_NoMoveLeft() {
        when(board.isOutside(Mockito.any())).thenReturn(true);
        initialPosition = new Cell(0, 0);
        assertEquals(0, BoardUtils.getAccessibility(board, initialPosition, new Move[]{new Move(1, 1)}));

        when(board.isOutside(Mockito.any())).thenReturn(false);
        when(board.isVisited(Mockito.any())).thenReturn(true);
        assertEquals(0, BoardUtils.getAccessibility(board, initialPosition, new Move[]{new Move(1, 1)}));
    }

    @Test
    public void testGetAccessibility() {
        final Move moveRight = new Move(1, 0);
        final Move moveDown = new Move(-1, 0);
        when(initialPosition.apply(moveRight)).thenReturn(cellRight);
        when(initialPosition.apply(moveDown)).thenReturn(cellBelow);
        when(board.isVisited(cellBelow)).thenReturn(true);
        when(board.isVisited(cellRight)).thenReturn(false);
        assertEquals(1, BoardUtils.getAccessibility(board, initialPosition, new Move[]{moveRight, moveDown}));

        when(board.isVisited(cellBelow)).thenReturn(false);
        assertEquals(2, BoardUtils.getAccessibility(board, initialPosition, new Move[]{moveRight, moveDown}));

        when(board.isOutside(cellBelow)).thenReturn(true);
        when(board.isOutside(cellRight)).thenReturn(false);
        assertEquals(1, BoardUtils.getAccessibility(board, initialPosition, new Move[]{moveRight, moveDown}));

        when(board.isOutside(cellBelow)).thenReturn(false);
        assertEquals(2, BoardUtils.getAccessibility(board, initialPosition, new Move[]{moveRight, moveDown}));
    }
}
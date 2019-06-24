package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Board;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImposibleMoveException;
import ru.job4j.chess.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChessTest {
    Board board = new Board();


    @Test(expected = ImposibleMoveException.class)
    public void whenThrowsImpossibleMoveException() {
        board.add(new BishopBlack(Cell.C8));
        board.move(Cell.C8, Cell.C7);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenThrowsFigureNotFoundException() {
        board.add(new BishopBlack(Cell.C8));
        board.move(Cell.C7, Cell.B6);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenThrowsOccupiedWayException() {
        board.add(new BishopBlack(Cell.C8));
        board.add(new BishopBlack(Cell.B7));
        board.move(Cell.C8, Cell.A6);
    }

    @Test
    public void whenBishopGoes() {
        board.add(new BishopBlack(Cell.C8));
        assertTrue(board.move(Cell.C8, Cell.E6));
        assertTrue(board.move(Cell.E6, Cell.A2));
        assertTrue(board.move(Cell.A2, Cell.B1));
        assertTrue(board.move(Cell.B1, Cell.C2));
    }
}

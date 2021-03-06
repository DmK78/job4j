package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public abstract class Figure {
    private final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }


    public Cell position() {
        return this.position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public abstract Figure copy(Cell dest);

    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }
}

package ru.job4j.chess.firuges.white;

import ru.job4j.chess.Figure;
import ru.job4j.chess.firuges.Cell;


/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}

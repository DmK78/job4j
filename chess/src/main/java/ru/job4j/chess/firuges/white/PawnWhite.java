package ru.job4j.chess.firuges.white;

import ru.job4j.chess.Figure;
import ru.job4j.chess.firuges.Cell;


/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite extends Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y - 1 && source.x == dest.x ||source.y==1 && source.y == dest.y - 2 && source.x == dest.x) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}

package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Figure;
import ru.job4j.chess.firuges.Cell;
//import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack extends Figure {
    final Cell position;

    public PawnBlack(Cell position) {
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
        if (source.y == dest.y + 1 && source.x == dest.x ) {
            steps = new Cell[]{dest};
        }
        /*if(source.y==6 && source.y == dest.y + 2 && source.x == dest.x){
            steps = new Cell[]{dest};
        }*/
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}

package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Figure;
import ru.job4j.chess.ImposibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;


/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        super(position);
        this.position = position;
    }

    /**
     * Возвращает ячейку Cell - текущую позицию
     *
     * @return
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Логика движения фигуры
     *
     * @param source
     * @param dest
     * @return
     * @throws ImposibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImposibleMoveException("not diagonal way");
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] init = Cell.values();
        Cell[] steps = new Cell[size];
        int deltaX = dest.x - source.x > 0 ? +1 : -1;
        int deltaY = dest.y - source.y > 0 ? +1 : -1;
        int currentPos = source.y + (source.x > 0 ? source.x * 8 : source.x);
        for (int i = 0; i < size; i++) {
            steps[i] = init[currentPos + (8 * (i + 1) * deltaX) + (deltaY * (i + 1))];
        }
        return steps;

    }

    /**
     * Проверяет, двигается ли фигура по диагонали
     *
     * @param source
     * @param dest
     * @return
     */
    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            result = true;
        }
        return result;
    }

    /**
     * Копирует фигуру в новую ячейку
     *
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

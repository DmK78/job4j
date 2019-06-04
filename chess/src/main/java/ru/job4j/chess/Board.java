package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class Board {
    Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("there is no figure");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            if(checkWay(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }


        this.figures[index] = this.figures[index].copy(dest);
        rst = true;

        return rst;
    }

    public boolean checkWay(Cell[] steps) {
        boolean result = true;
        for (int i = 0; i < figures.length; i++) {
            for (int j = 0; j < steps.length; j++) {
                if (figures[i].position().equals(steps[j])) {
                    throw new OccupiedWayException("Way is occupied");
                }
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}

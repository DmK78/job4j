package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return checkTableForLine(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return checkTableForLine(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table).flatMap(Arrays::stream).anyMatch(figure3T -> !figure3T.hasMarkX() && !figure3T.hasMarkO());
    }

    public boolean checkTableForLine(Predicate<Figure3T> predicate) {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(predicate, 0, 0, 1, 1)) {
                result = true;
                break;
            }
            if (this.fillBy(predicate, 0, this.table.length - 1, 1, -1)) {
                result = true;
                break;
            }
            if (this.fillBy(predicate, 0, i, 1, 0)) {
                result = true;
                break;
            }
            if (this.fillBy(predicate, i, 0, 0, 1)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

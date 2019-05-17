package ru.job4j.condition;

/**
 * Программа расчета расстояния между точками.
 */

public class Point {
    /**
     * рассчет расстояния.
     *
     * @param x1,x2,y1,y2 Coord.
     * @return dist.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}

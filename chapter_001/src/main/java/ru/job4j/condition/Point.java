package ru.job4j.condition;

/**
 * Программа расчета расстояния между точками.
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * рассчет расстояния.
     *
     * @param  that.
     * @return dist.
     */
    public double distance(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s,%s]", this.x, this.y));
    }
}

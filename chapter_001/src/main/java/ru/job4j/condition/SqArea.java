package ru.job4j.condition;

/**
 * Программа расчета сторон прямоугольника.
 */

public class SqArea {
    /**
     * рассчет сторон.
     *
     * @param p - периметр.
     * @param k - Известно что ширина больше высоты в k раз.
     * @return dist.
     */
    public static int square(int p, int k) {
        // h - one part, w = h*k. then all sides = k+1
        int h = (p / 2) / (k + 1);
        int w = h * k;
        return w * h;
    }
}

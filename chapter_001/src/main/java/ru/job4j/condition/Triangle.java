package ru.job4j.condition;

/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     * <p>
     * Формула.
     * <p>
     * (a + b + c) / 2
     *
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return Перимент.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * Метод должен вычислить прощадь треугольканива.
     * <p>
     * Формула.
     * <p>
     * √ p *(p - a) * (p - b) * (p - c)
     * <p>
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = second.distance(third);
        double c = first.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * <p>
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     * @return есть треугольник или нет
     */
    private boolean exist(double a, double c, double b) {
        return a + c > b && a + b > c && b + c > a;
    }
}

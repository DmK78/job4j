package ru.job4j.calculator;

/**
 * Calculator.
 * <p>
 * author: Dmitry Kolganov (dmk78@inbox.ru)
 */
public class Calculator {
    /**
     * add - adding a and b.
     *
     * @param first  - first double.
     * @param second - second double.
     * @return first + second.
     */
    public double add(double first, double second) {
        return first + second;
    }
    /**
     * subtract - a subtract b.
     *
     * @param first  - first double.
     * @param second - second double.
     * @return first - second.
     */
    public double subtract(double first, double second) {
        return first - second;
    }
    /**
     * div - a divide by b.
     *
     * @param first  - first double.
     * @param second - second double.
     * @return first / second.
     */
    public double div(double first, double second) {
        return first / second;
    }
    /**
     * multiple - multiple a and b.
     *
     * @param first  - first double.
     * @param second - second double.
     * @return first / second.
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}

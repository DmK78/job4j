package ru.job4j.condition;

/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Возвращает большее значение
     *
     * @param first, right - два числа.
     * @return Большее число.
     */
    public int max(int first, int second) {
        return second > first ? second : first;
    }

    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public int max(int first, int second, int third, int fourth) {
        return max(max(first, second), max(third, fourth));
    }

}

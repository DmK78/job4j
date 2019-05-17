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
     * @param left, right - два числа.
     * @return Большее число.
     */
    public int max(int left, int right) {
        return right > left ? right : left;
    }
}

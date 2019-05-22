package ru.job4j.array;
/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

/**
 * Программа заполнения массива значениями в квадрате.
 */
public class Square {
    /**
     * Возвращает большее значение
     * заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
     * @param bound - количество значений в массиве.
     * @return массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }

}

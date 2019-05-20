package ru.job4j.array;
/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */


/**
 * Квадратный массив заполнен true или false по диагоналям.
 */

public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
                break;
            }
            if (data[data.length - i - 1][i] != data[data.length - i - 2][i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

}

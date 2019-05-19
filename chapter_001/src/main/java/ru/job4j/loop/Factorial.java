package ru.job4j.loop;

/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

/**
 * Программа продсчета фасториала.
 */


public class Factorial {

    public int calc(int n) {
        if (n == 0) {
            return 0;
        }
        return n * calc(n - 1);
    }

}

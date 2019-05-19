package ru.job4j.condition;

/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class MultiMax {
    public int max(int first, int second, int third) {
        int result;
        result = (first > second ? first : second);
        result = result > third ? result : third;
       return result;


    }
}

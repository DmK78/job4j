package ru.job4j.array;
/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */


import java.util.Arrays;

/**
 * Удаление дубликатов в массиве.
 */

public class ArrayDuplicate {

    public String[] remove(String[] array) {
        int countOfDuplicates = 0;
        String temp;
        for (int i = 0; i < array.length - 1 - countOfDuplicates; i++) {
            for (int j = i + 1; j < array.length - countOfDuplicates; j++) {
                if (array[i].equals(array[j])) {
                    countOfDuplicates++;
                    //temp = array[j];
                    array[j] = array[array.length - 1 - countOfDuplicates];
                    array[array.length - 1] = null;
                }
            }
        }
        return Arrays.copyOf(array, array.length - countOfDuplicates);
    }
}
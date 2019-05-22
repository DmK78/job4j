package ru.job4j.array;


import java.util.Arrays;

/**
 * Удаление дубликатов в массиве.
 */

public class ArrayDuplicate {
    /**
     *
     * @param array
     * @return
     */
    public String[] remove(String[] array) {
        int countOfDuplicates = 0;
        String temp;
        for (int i = 0; i < array.length - 1 - countOfDuplicates; i++) {
            for (int j = i + 1; j < array.length - countOfDuplicates; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[array.length - 1 - countOfDuplicates];
                    countOfDuplicates++;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - countOfDuplicates);
    }
}



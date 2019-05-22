package ru.job4j.array;

/**
 * Слияние массивов.
 * массивы разной длины и отсортированы по возрастанию.
 */

public class MergeArrays {


    public int[] merge(int[] a, int[] b) {
        int[] resultArr = new int[a.length + b.length];
        int countResult = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= b[i]) {
                resultArr[countResult] = a[i];
                countResult++;
                resultArr[countResult] = b[i];
            } else {
                resultArr[countResult] = b[i];
                countResult++;
                resultArr[countResult] = a[i];
            }
            countResult++;
        }
        return resultArr;

    }

}

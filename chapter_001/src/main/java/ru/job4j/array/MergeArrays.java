package ru.job4j.array;

/**
 * Слияние массивов.
 * массивы разной длины и отсортированы по возрастанию.
 */

public class MergeArrays {


    public int[] merge(int[] a, int[] b) {
        int[] resultArr = new int[a.length + b.length];
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < resultArr.length; i++) {
            if (countA < a.length && countB < b.length) {
                if (a[countA] < b[countB]) {
                    resultArr[i] = a[countA];
                    countA++;
                } else {
                    resultArr[i] = b[countB];
                    countB++;
                }
            } else if (countA < a.length) {
                resultArr[i] = a[countA];
                countA++;
            } else if (countB < b.length) {
                resultArr[i] = b[countB];
                countB++;
            }
        }
        return resultArr;
    }


}

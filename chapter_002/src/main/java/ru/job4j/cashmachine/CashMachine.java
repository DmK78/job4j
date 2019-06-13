package ru.job4j.cashmachine;
/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Автомат размена купюр
 */
public class CashMachine {

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
        Arrays.sort(values);
    }

    public List<List<Integer>> exchange(int note) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = values.length - 1; i >= 0; i--) {
            List<Integer> tmpArr = new ArrayList<>();
            int count = note / values[i];
            int remain = note;
            if (note < values[i]) {
                continue;
            }
            if (count != note) {
                for (int j = count; j > 0; j--) {
                    for (int o = 1; o <= j; o++) {
                        tmpArr.add(values[i]);
                        remain -= values[i];
                    }
                    tmpArr.addAll(appendNotes(remain, i - 1));
                    result.add(tmpArr);
                    remain = note;
                    tmpArr = new ArrayList<>();
                }
            } else {
                result.add(appendNotes(note, i));
            }

        }

        return result;
    }

    public List<Integer> appendNotes(int note, int maxCoin) {
        List<Integer> result = new ArrayList<>();
        int remain = note;
        for (int i = maxCoin; i >= 0; i--) {
            while (values[i] <= remain) {
                result.add(values[i]);
                remain -= values[i];
            }
        }
        return result;
    }
}
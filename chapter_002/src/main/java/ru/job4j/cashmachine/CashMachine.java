package ru.job4j.cashmachine;
/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Автомат размена купюр
 */
public class CashMachine {

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        List<List<Integer>> result = new ArrayList<>();
        int remain = note;
        for (int currentCoin : values) {
            List<Integer> currentArr = new ArrayList<>();
            if (note < currentCoin) {
                continue;
            }
            if (note % currentCoin == 0) {
                for (int i = 0; i < note / currentCoin; i++) {
                    currentArr.add(currentCoin);
                    remain -= currentCoin;
                }
                result.add(currentArr);
                if (note / currentCoin > 1) {
                    remain = note;
                    currentArr = new ArrayList<>();
                    currentArr.add(currentCoin);
                    remain -= currentCoin;
                    for (int anotherCoin : values) {
                        while (remain > 0) {
                            if (anotherCoin < currentCoin && anotherCoin <= remain) {
                                currentArr.add(anotherCoin);
                                remain -= anotherCoin;
                            } else {
                                break;
                            }
                        }
                    }
                    currentArr.sort(null);
                    int sum = 0;
                    for (int i : currentArr) {
                        sum += i;
                    }
                    if (sum == note) {
                        result.add(currentArr);
                    }
                }
            }
            while (remain > 0) {
                if (currentCoin <= remain) {
                    currentArr.add(currentCoin);
                    remain -= currentCoin;

                } else {
                    for (int anotherCoin : values) {
                        if (anotherCoin < currentCoin && anotherCoin <= remain) {
                            currentArr.add(anotherCoin);
                            remain -= anotherCoin;
                        }
                    }
                }
            }
            if (note % currentCoin != 0) {
                remain = note;
                result.add(currentArr);
            }
        }
        return result;
    }
}
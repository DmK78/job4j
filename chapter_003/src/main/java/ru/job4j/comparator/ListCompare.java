package ru.job4j.comparator;

import java.util.Comparator;

/**
 * сравнивает 2 строки в лексографическом порядке
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int equalLetters = 0;
        int count = left.length() > right.length() ? right.length() : left.length();
        for (int i = 0; i < count; i++) {
            int compareChar = (Character.valueOf(left.charAt(i)).compareTo(right.charAt(i)));
            if (compareChar > 0) {
                result = 1;
            } else if (compareChar < 0) {
                result = -1;
            } else {
                equalLetters++;
            }
        }
        if (equalLetters == count && left.length() != right.length()) {
            if (left.length() > right.length()) {
                result = 1;
            } else {
                result = -1;
            }
        }
        return result;
    }
}
package ru.job4j.convertmatrix2list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] rows : array) {
            for (int cells : rows) {
                list.add(cells);
            }
        }
        return list;
    }
}
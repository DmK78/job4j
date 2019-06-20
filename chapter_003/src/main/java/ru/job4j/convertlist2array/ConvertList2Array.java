package ru.job4j.convertlist2array;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : (list.size() / rows) + 1;
        int[][] array = new int[rows][cells];
        int listCounter = 0;
        for (int rowInd = 0; rowInd < rows; rowInd++) {
            for (int cellInd = 0; cellInd < cells; cellInd++) {
                if (listCounter < list.size()) {
                    array[rowInd][cellInd] = list.get(listCounter++);
                } else {
                    array[rowInd][cellInd] = 0;
                }
            }
        }
        return array;
    }
}
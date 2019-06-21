package ru.job4j.convertlist2array;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : (list.size() / rows) + 1;
        int[][] array = new int[rows][cells];
        int x = 0;
        int y = 0;
        for (int value : list) {
            array[x][y] = value;
            y++;
            if (y == cells) {
                y = 0;
                x++;
            }
        }
        return array;
    }
}
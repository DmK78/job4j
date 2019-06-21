package ru.job4j.converterlist;

import java.util.*;


public class ConvertList {
    /**
     * Конвертирует спмсок с вложенными массивами
     * @param list - список с элементами int[]
     * @return List<Integer>
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        ListIterator<int[]> it = list.listIterator();
        while (it.hasNext()) {
            for (int a : it.next()) {
                result.add(a);
            }
        }
        return result;
    }
}

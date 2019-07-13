package ru.job4j.converterlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {


    @Test
    public void whenConvertSuccess() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = List.of(new int[]{1, 2},new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = List.of(1,2,3,4,5,6);
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvert20NumbersSuccess() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = List.of(new int[]{1, 2},new int[]{3, 4, 5, 6}
        ,new int[]{7, 8, 9, 10},new int[]{11},new int[]{12,13,14,15,16,17,18,19,20});
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        assertThat(result, is(expect));
    }
}

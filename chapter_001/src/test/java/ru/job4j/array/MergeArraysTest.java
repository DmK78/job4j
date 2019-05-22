package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergeArraysTest {
    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        MergeArrays mergeArrays = new MergeArrays();
        int[] result = mergeArrays.merge(new int[]{1, 3},new int[]{2, 4});
        int[] check = {1, 2, 3, 4};
        assertThat(result, is(check));
    }
}

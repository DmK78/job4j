package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergeArraysTest {
    @Test
    public void whenTwoArrays22ThenSort() {
        MergeArrays mergeArrays = new MergeArrays();
        int[] result = mergeArrays.merge(new int[]{1, 3}, new int[]{2, 4});
        int[] check = {1, 2, 3, 4};
        assertThat(result, is(check));
    }

    @Test
    public void whenTwoArrays32ThenSort() {
        MergeArrays mergeArrays = new MergeArrays();
        int[] result = mergeArrays.merge(new int[]{1, 2, 3}, new int[]{2, 4});
        int[] check = {1, 2, 2, 3, 4};
        assertThat(result, is(check));
    }

    @Test
    public void whenTwoArraysThen55Sort() {
        MergeArrays mergeArrays = new MergeArrays();
        int[] result = mergeArrays.merge(new int[]{11, 45, 46, 47, 90}, new int[]{2, 4, 100, 109, 200});
        int[] check = {2, 4, 11, 45, 46, 47, 90, 100, 109, 200};
        assertThat(result, is(check));
    }

    @Test
    public void whenTwoArrays15ThenSort() {
        MergeArrays mergeArrays = new MergeArrays();
        int[] result = mergeArrays.merge(new int[]{7}, new int[]{2, 3, 4, 5, 6});
        int[] check = {2, 3, 4, 5, 6, 7};
        assertThat(result, is(check));
    }

    @Test
    public void whenTwoArrays51ThenSort() {
        MergeArrays mergeArrays = new MergeArrays();
        int[] result = mergeArrays.merge(new int[]{2, 3, 4, 5, 6}, new int[]{7});
        int[] check = {2, 3, 4, 5, 6, 7};
        assertThat(result, is(check));
    }


}

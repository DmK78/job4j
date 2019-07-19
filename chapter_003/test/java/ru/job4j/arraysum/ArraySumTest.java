package ru.job4j.arraysum;

import arraysum.ArraySum;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArraySumTest {
    @Test
    public void whenAddingUserAccount() {
        ArraySum arraySum = new ArraySum();
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Double result =arraySum.sum(array);
        assertThat(result, is(220D));
    }
}

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;


public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] check = {"Привет", "Мир", "Супер"};
        assertThat(result, arrayContainingInAnyOrder(check));
    }

    @Test
    public void whenRemoveDuplicatesThenArray15WithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"1", "1", "2", "3", "3", "4", "4", "3", "5", "6", "7", "8", "9", "10", "11", "11", "12", "13", "14", "15"});
        String[] check = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        assertThat(result, arrayContainingInAnyOrder(check));
    }

    @Test
    public void whenRemoveDuplicatesThenArray2WithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"1", "1", "1", "3", "1"});
        String[] check = {"1", "3"};
        assertThat(result, arrayContainingInAnyOrder(check));
    }

    @Test
    public void whenRemoveDuplicatesThenArray1WithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"1", "1", "1", "1", "1", "1", "1"});
        String[] check = {"1"};
        assertThat(result, arrayContainingInAnyOrder(check));
    }
}
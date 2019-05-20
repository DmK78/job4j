package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] check = {"Привет", "Мир", "Супер"};
    }

    @Test
    public void whenRemoveDuplicatesThenArray20WithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"1", "1", "2", "3", "3", "4", "4", "3", "5", "6", "7", "8", "9", "10", "11", "11", "12", "13", "14", "15"});
        String[] check = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",};
    }
}
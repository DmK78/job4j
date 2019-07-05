package ru.job4j.matrixtolist;

import org.junit.Test;
import ru.job4j.scool.Student;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {


    @Test
    public void whenConvertMatrixToListSuccess() {
        MatrixToList matrixToList = new MatrixToList();
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 5, 7, 8)
        );
        List result = matrixToList.convertMatrisToList(matrix);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 5, 7, 8);
        assertThat(result, is(expect));
    }
}

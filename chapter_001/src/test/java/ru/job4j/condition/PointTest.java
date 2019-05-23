package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenZeroAndTenThenTen() {
        Point point = new Point(0, 0);
        double result = point.distance(new Point(0, 10));
        assertThat(result, is(10D));
    }

    @Test
    public void whenShowInfo() {
        Point a = new Point(1, 5);
        a.info();
        Point b = new Point(2, 2);
        b.info();
    }
}

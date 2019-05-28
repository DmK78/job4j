package ru.job4j.pseudo;

import org.junit.Test;
import ru.job4j.ru.job4j.pseudo.Square;
import ru.job4j.ru.job4j.pseudo.Triangle;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++++" + System.lineSeparator())
                                .append("++++++" + System.lineSeparator())
                                .append("++++++" + System.lineSeparator())
                                .append("++++++" + System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriamgle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +   " + System.lineSeparator())
                                .append("  +++  " + System.lineSeparator())
                                .append(" +++++ " + System.lineSeparator())
                                .append("+++++++" + System.lineSeparator())
                                .toString()
                )
        );
    }


}

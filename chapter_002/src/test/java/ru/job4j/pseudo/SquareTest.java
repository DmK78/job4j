package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.ru.job4j.pseudo.Square;
import ru.job4j.ru.job4j.pseudo.Triangle;
import ru.job4j.tracker.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

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
    public void whenDrawTriangle() {

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

package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"try", "5", "0"})
        );
        ArrayList<Integer> ranges = new ArrayList<>();
        ranges.add(0);
        ranges.add(1);
        ranges.add(3);
        ranges.add(3);
        input.ask("Enter", ranges);
        StringBuilder string = new StringBuilder();
        string.append("Please enter numbers...")
                .append(System.lineSeparator())
                .append("Please enter number of menu...")
                .append(System.lineSeparator());

        assertThat(
                this.mem.toString(),
                is(
                        string.toString())
        );
    }
}
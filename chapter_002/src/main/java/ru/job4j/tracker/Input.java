package ru.job4j.tracker;

import java.util.ArrayList;

public interface Input {
    String ask(String question);

    int ask(String question, ArrayList<Integer> ranges);

    int askInt(String s);
}

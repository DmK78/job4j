package ru.job4j.dagger;

import ru.job4j.tracker.Input;

import javax.inject.Inject;

public class Calc {
    private final Input input;
    private final Out out;

    @Inject
    public Calc(Input input, Out out) {
        this.input = input;
        this.out = out;
    }

    public void add() {
        int first = input.askInt("first: ");
        int second = input.askInt("second: ");
        out.print("result " + (first + second));

    }


}

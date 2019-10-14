package ru.job4j.tracker;

import java.util.ArrayList;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    @Override
    public int ask(String question, ArrayList<Integer> ranges) {
        boolean isValid = false;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, ranges);
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter numbers...");
            } catch (MenuOutException e) {
                System.out.println("Please enter number of menu...");
            }
        } while (!isValid);
        return value;
    }

    @Override
    public int askInt(String s) {
        boolean isValid = false;
        int value = -1;
        do {
            try {
                value = this.input.askInt(s);
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter numbers...");
            } catch (MenuOutException e) {
                System.out.println("Please enter number of menu...");
            }
        } while (!isValid);
        return value;
    }
}

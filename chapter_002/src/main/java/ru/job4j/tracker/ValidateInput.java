package ru.job4j.tracker;

import java.util.ArrayList;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, ArrayList<Integer> range) {
        boolean isValid = false;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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

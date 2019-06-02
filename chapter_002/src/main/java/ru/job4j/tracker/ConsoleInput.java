package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean isValid = false;
        for (int value : range) {
            if (key == value) {
                isValid = true;
                break;
            }
        }
        if (isValid) {
            return key;
        } else {
            throw new MenuOutException("Enter values from menu");
        }
    }
}

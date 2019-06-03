package ru.job4j.pseudo;

import ru.job4j.pseudo.Shape;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   " + System.lineSeparator());
        pic.append("  +++  " + System.lineSeparator());
        pic.append(" +++++ " + System.lineSeparator());
        pic.append("+++++++" + System.lineSeparator());
        return pic.toString();
    }
}

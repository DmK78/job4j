package ru.job4j.pseudo;

import ru.job4j.pseudo.Shape;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++++" + System.lineSeparator());
        pic.append("++++++" + System.lineSeparator());
        pic.append("++++++" + System.lineSeparator());
        pic.append("++++++" + System.lineSeparator());
        return pic.toString();
    }
}

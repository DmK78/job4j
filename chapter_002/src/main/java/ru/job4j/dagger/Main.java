package ru.job4j.dagger;

public class Main {
    public static void main(String[] args) {
        InputComponent component = DaggerInputComponent.create();
        component.instance().add();
    }
}

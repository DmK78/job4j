package ru.job4j.userconvert;

public class User {
    private static int coutnerId = 0;
    private int id;
    private String name;
    private String city;

    public User(String name, String city) {
        this.name = name;
        this.city = city;
        this.id = coutnerId++;
    }

    public int getId() {
        return id;
    }

}

package ru.job4j.sortuser;

class User implements Comparable {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name
                + '\''
                + ", age="
                + age
                + '}';
    }

    @Override
    public int compareTo(Object o) {
        return ((User) o).age.compareTo(this.age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

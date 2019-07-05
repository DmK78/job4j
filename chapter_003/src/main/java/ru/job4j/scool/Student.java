package ru.job4j.scool;


import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private int score;

    public Student(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                &&
                Objects.equals(firstName, student.firstName)
                &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, score);
    }

    @Override
    public String toString() {
        return "" + firstName + " " + lastName + " " + score + "\n";
    }
}

package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean transfer(Account destination, double amount) {
        boolean result = false;
        if (amount > 0 && this.value >= amount && destination != null) {
            this.value -= amount;
            destination.value += amount;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Account requisites= " + requisites + " value= " + value + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.value, value) == 0
                && Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }
}

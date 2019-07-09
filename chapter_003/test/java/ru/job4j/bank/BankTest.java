package ru.job4j.bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddingUserAccount() {
        Bank bank = new Bank();
        User user = new User("Ivan", "12345");
        Account account = new Account(100, "111");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        bank.addAccountToUser("111",account);
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, List.of(account));
        assertThat(bank.findUserAccounts("12345"), is(expect.get(user)));
    }

    @Test
    public void whenAddingUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "12345");
        bank.addUser(user);
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, new ArrayList<>());
        assertThat(bank.findUserAccounts("12345"), is(expect.get(user)));
    }

    @Test
    public void whenRemovingUserAccount() {
        Bank bank = new Bank();
        User user = new User("Ivan", "12345");
        Account account = new Account(100, "111");
        Account account1 = new Account(200, "222");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        bank.addAccountToUser(user.getPassport(), account1);
        bank.delAccountFromUser(user.getPassport(),account);
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, List.of(account1));
        assertThat(bank.findUserAccounts("12345"), is(expect.get(user)));
    }

    @Test
    public void whenGettingUserAccounts() {
        Bank bank = new Bank();
        User user = new User("Ivan", "12345");
        Account account = new Account(100, "111");
        Account account1 = new Account(200, "222");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        bank.addAccountToUser(user.getPassport(), account1);
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, List.of(account,account1));
        assertThat(bank.findUserAccounts("12345"), is(expect.get(user)));
    }

    @Test
    public void whenFindingAccountByPassportAndRequisistes() {
        Bank bank = new Bank();
        User user = new User("Ivan", "12345");
        Account account = new Account(100, "111");
        Account account1 = new Account(200, "222");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        bank.addAccountToUser(user.getPassport(), account1);
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, List.of(account));
        assertThat(bank.findAccByPassAndReq("12345","111"), is(expect.get(user).get(0)));
    }

    @Test
    public void whenFindingUserByPassport() {
        Bank bank = new Bank();
        User user = new User("Ivan", "12345");
        bank.addUser(user);
        assertThat(bank.findUserByPassport("12345"), is(user));
    }


}

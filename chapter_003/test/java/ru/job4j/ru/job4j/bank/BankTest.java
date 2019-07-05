package ru.job4j.ru.job4j.bank;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.Bank;
import ru.job4j.bank.User;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BankTest {

    @Test
    public void whenAddingUserAccount() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "1");
        bank.addUser(user1);
        Account account1 = new Account(100, "1");
        bank.addAccountToUser(user1.getPassport(),account1);
        List<Account> expect = new ArrayList<>();
        expect.add(account1);
        assertThat(bank.findUserAccounts(user1.getPassport()).get(0), is(expect.get(0)));
    }

    @Test
    public void whenDeletingUserAccount() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "1");
        bank.addUser(user1);
        Account account1 = new Account(100, "1");
        Account account2 = new Account(200, "2");
        bank.addAccountToUser(user1.getPassport(),account1);
        bank.addAccountToUser(user1.getPassport(),account2);
        bank.delAccountFromUser(user1.getPassport(),account1);
        List<Account> expect = new ArrayList<>();
        expect.add(account2);
        assertThat(bank.findUserAccounts(user1.getPassport()), is(expect));
    }

    @Test
    public void whenTransferSuccess() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "1");
        User user2 = new User("Dmitry", "2");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1 = new Account(100, "1");
        Account account2 = new Account(200, "2");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.transferMoney(user1.getPassport(), account1.getRequisites(), user2.getPassport(), account2.getRequisites(), 100);
        List<Account> expect = new ArrayList<>();
        expect.add(new Account(0, "1"));
        expect.add(new Account(300, "2"));
        assertThat(bank.findUserAccounts(user1.getPassport()).get(0), is(expect.get(0)));
        assertThat(bank.findUserAccounts(user2.getPassport()).get(0), is(expect.get(1)));

    }
}

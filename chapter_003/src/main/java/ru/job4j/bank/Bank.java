package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> users = new TreeMap<>();

    public void addUser(User user) {
        this.users.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                users.get(user).add(account);
                break;
            }
        }
    }

    public void delAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                users.get(user).remove(account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                result = entry.getValue();
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account accountSrc = null;
        Account accountDst = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (srcPassport.equals(entry.getKey().getPassport())) {
                for (Account account : entry.getValue()) {
                    if (srcRequisite.equals(account.getRequisites())) {
                        accountSrc = account;
                        break;
                    }
                }
            }
        }
        if (accountSrc != null && accountSrc.getValue() >= amount) {
            for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
                if (destPassport.equals(entry.getKey().getPassport())) {
                    for (Account account : entry.getValue()) {
                        if (dstRequisite.equals(account.getRequisites())) {
                            accountDst = account;
                            break;
                        }
                    }
                }
            }
        }
        if (accountDst != null) {
            if (accountSrc.transfer(accountDst, amount)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Bank{"
                + "users="
                + users
                + '}';
    }
}


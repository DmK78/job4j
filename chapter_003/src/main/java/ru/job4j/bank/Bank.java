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

    public User findUserByPassport(String passport) {
        return users.keySet().stream().filter(user -> passport.equals(user.getPassport())).findFirst().orElse(null);
    }

    public void addAccountToUser(String passport, Account account) {
        users.get(findUserByPassport(passport)).add(account);
    }

    public void delAccountFromUser(String passport, Account account) {
        users.get(findUserByPassport(passport)).remove(account);
    }

    public Account findAccByPassAndReq(String passport, String requisite) {
        return findUserAccounts(passport).stream().filter(account -> requisite.equals(account.getRequisites())).findFirst().orElse(null);
    }

    public List<Account> findUserAccounts(String passport) {
        return users.get(users.keySet().stream().filter(user -> passport.equals(user.getPassport())).findFirst().orElse(null));

    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account accountSrc = findAccByPassAndReq(srcPassport, srcRequisite);
        Account accountDst = null;
        if (accountSrc != null && accountSrc.getValue() >= amount) {
            accountDst = findAccByPassAndReq(destPassport, dstRequisite);
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


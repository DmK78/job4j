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

    /**
     * находит аккаунт по номеру паспорта и реквизитам счета.
     * @param passport
     * @param requisite
     * @return
     */
    public Account findAccByPassAndReq(String passport, String requisite) {
        Account result = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                for (Account account : entry.getValue()) {
                    if (requisite.equals(account.getRequisites())) {
                        result = account;
                        break;
                    }
                }
            }
        }
        return result;
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


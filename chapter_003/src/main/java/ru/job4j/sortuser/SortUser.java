package ru.job4j.sortuser;

import java.util.*;

public class SortUser {

    /**
     * будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     *
     * @return
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        for (User user : list) {
            result.add(user);
        }
        return result;
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = 0;
                result = o1.getName().length() > o2.getName().length() ? 1 : -1;
                return result;
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge().compareTo(o2.getAge());
                }
                return result;
            }
        });


        return list;
    }

    public static void main(String[] args) {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 34));
        users.add(new User("Petr", 30));
        users.add(new User("Dmitry", 41));
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new LinkedHashSet<>();
        expect.add(users.get(1));
        expect.add(users.get(0));
        expect.add(users.get(2));

        for (User user : result) {
            System.out.println(user.toString());
        }
        for (User user : expect) {
            System.out.println(user.toString());
        }


    }
}

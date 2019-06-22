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

    public static void main(String[] args) {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan",34));
        users.add(new User("Petr",30));
        users.add(new User("Dmitry",41));
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new LinkedHashSet<>();
        expect.add(users.get(1));
        expect.add(users.get(0));
        expect.add(users.get(2));

        for(User user:result){
            System.out.println(user.toString());
        }
        for(User user:expect){
            System.out.println(user.toString());
        }



    }
}

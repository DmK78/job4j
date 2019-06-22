package ru.job4j.userconvert;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    /**
     * принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User.
     *
     * @param list
     * @return
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }


}

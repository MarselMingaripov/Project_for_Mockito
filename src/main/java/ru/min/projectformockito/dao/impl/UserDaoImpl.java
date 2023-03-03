package ru.min.projectformockito.dao.impl;

import org.springframework.stereotype.Repository;
import ru.min.projectformockito.model.User;
import ru.min.projectformockito.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final List<User> userList = new ArrayList<>();

    public UserDaoImpl(List<User> userList) {
        this.userList.add(new User("Иван"));
        this.userList.add(new User("Петр"));
        this.userList.add(new User("Сидор"));
    }

    @Override
    public User getUserByName(String name) {
        if (!userList.isEmpty()) {
            return userList.stream()
                    .filter(v -> v.getName().equals(name))
                    .findFirst().get();
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {

        return userList;
    }
}

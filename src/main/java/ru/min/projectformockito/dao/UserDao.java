package ru.min.projectformockito.dao;

import ru.min.projectformockito.model.User;

import java.util.List;

public interface UserDao {

    User getUserByName(String name);

    List<User> findAllUsers();
}

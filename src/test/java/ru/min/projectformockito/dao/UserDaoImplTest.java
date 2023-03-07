package ru.min.projectformockito.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.min.projectformockito.dao.impl.UserDaoImpl;
import ru.min.projectformockito.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    public static final String USERNAME_1 = "Петр";
    public static final String USERNAME_2 = "Саша";
    User user1;
    User user2;
    List<User> list = new ArrayList<>();
    private final UserDaoImpl out = new UserDaoImpl(list);
    @BeforeEach
    void init(){
        user1 = new User(USERNAME_1);
        user2 = new User(USERNAME_2);
        list.add(user1);
    }

    @Test
    void shouldReturnNotNullWhenUserExistsByUsername() {
        assertNotNull(out.getUserByName(user1.getName()));
    }

    @Test
    void shouldReturnNullWhenUserNotExistsByUsername() {
        assertNull(out.getUserByName(user2.getName()));
    }
}
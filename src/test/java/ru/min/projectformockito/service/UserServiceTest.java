package ru.min.projectformockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.min.projectformockito.dao.UserDao;
import ru.min.projectformockito.model.User;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    public static final String NAME = "Иван";
    User user;
    @BeforeEach
    public void init(){
        user = new User(NAME);
    }
    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private UserService out;

    @Test
    void returnTrueWhenUserExists() {
        when(userDaoMock.getUserByName(NAME)).thenReturn(user);
        assertTrue(out.checkUserExists(user));
    }

    @Test
    void returnFalseWhenUserNotExists() {
        when(userDaoMock.getUserByName(anyString())).thenReturn(null);
        assertFalse(out.checkUserExists(user));
    }
}
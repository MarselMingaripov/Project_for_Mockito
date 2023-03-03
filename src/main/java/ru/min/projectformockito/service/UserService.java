package ru.min.projectformockito.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.min.projectformockito.dao.UserDao;
import ru.min.projectformockito.model.User;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;


    public boolean checkUserExists(User user){
        return userDao.getUserByName(user.getName()) != null;
    }
}

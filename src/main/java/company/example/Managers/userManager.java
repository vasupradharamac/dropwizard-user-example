package com.company.example.manager;

import com.company.example.dao.UserDao;
import com.company.example.database.tables.*;
import com.company.example.exception.UserEntityException;
import java.util.Optional;

public class UserManager {

    private final UserDao userDao;

    public User getById(int userId) throws UserEntityException {

        return userDao
                .findById(userId)
                .orElseThrow(() -> new UserEntityException("No such user!!));
    }

    public Optional<User> findById(Integer userId) {
        return userDao.findById(userId);
    }


}
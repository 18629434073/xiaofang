package com.ht.service.impl;

import com.ht.dao.IUserDao;
import com.ht.model.User;
import com.ht.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by UPC on 2016/12/10.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired(required = true)
    private IUserDao userDao;

    @Override
    public User getUser(String userid) {
        return userDao.getUser(userid);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}

package com.ht.dao;

import com.ht.model.User;

/**
 * Created by UPC on 2016/12/10.
 */
public interface IUserDao {
    User getUser(String userid);

    void saveUser(User user);
}

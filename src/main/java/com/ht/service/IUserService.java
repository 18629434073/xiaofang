package com.ht.service;

import com.ht.model.User;

/**
 * Created by UPC on 2016/12/10.
 */
public interface IUserService {


    User getUser(String userid);

    void saveUser(User user);
}

package com.hupeng.service;

import com.hupeng.entity.User;

public interface UserService {
    int userRegister(User user);
    int userLogin(User user);
    int getUserId(String account);
}

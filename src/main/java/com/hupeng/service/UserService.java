package com.hupeng.service;

import com.hupeng.entity.User;

public interface UserService {
    public int userRegister(User user);
    public int userLogin(User user);
}

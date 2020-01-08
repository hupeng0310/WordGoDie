package com.hupeng.service;

import com.hupeng.entity.User;
import com.hupeng.entity.UserExaminationInfo;

import java.util.List;

public interface UserService {
    int userRegister(User user);
    int userLogin(User user);
    int getUserId(String account);
    List<UserExaminationInfo> getUserExaminationInfoByID(int id);
}

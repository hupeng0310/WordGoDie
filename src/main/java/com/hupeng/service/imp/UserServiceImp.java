package com.hupeng.service.imp;

import com.hupeng.dao.IUserDao;
import com.hupeng.entity.User;
import com.hupeng.entity.UserExaminationInfo;
import com.hupeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    public static final int SUCCESS = 0;
    public static final int FAILED = 1;
    public static final int EMAIL_REGISTERED = 2;
    public static final int ACCOUNT_REGISTERED = 3;
    public static final int ACCOUNT_NOT_FOUND =4;
    public static final int PASSWORD_ERROR = 5;
    @Autowired
    private IUserDao iUserDao;

    @Override
    public int userRegister(User user) {
        if(iUserDao.selectByEmail(user.getEmail())!=0) {
            return EMAIL_REGISTERED;
        }else if(iUserDao.selectByAccount(user.getAccount()) !=0){
            return ACCOUNT_REGISTERED;
        }
        else {
            return iUserDao.addUser(user) == 1?SUCCESS:FAILED;
        }
    }

    @Override
    public int userLogin(User user) {
        if(iUserDao.selectByAccount(user.getAccount()) != 0) {
            if(iUserDao.selectByAccountAndPassword(user) != 0) {
                return SUCCESS;
            }else {
                return PASSWORD_ERROR;
            }
        }else if(iUserDao.selectByEmail(user.getEmail()) !=0) {
            if(iUserDao.selectByEmailAndPassword(user) != 0) {
                return SUCCESS;
            }else{
                return PASSWORD_ERROR;
            }

        }else {
            return ACCOUNT_NOT_FOUND;
        }
    }

    @Override
    public int getUserId(String account) {
        return this.iUserDao.getUserIdByAccout(account);
    }

    @Override
    public List<UserExaminationInfo> getUserExaminationInfoByID(int id) {
        System.out.println("用户id" + id);
        return this.iUserDao.getExaminationInfoByID(id);
    }
}

package com.hupeng.dao;

import com.hupeng.entity.User;
import com.hupeng.entity.UserExaminationInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    @Select("select count(*) from user  where email=#{email} limit 1")
    int selectByEmail(@Param("email") String email);

    @Select("select count(*) from user where account=#{account} limit 1")
    int selectByAccount(@Param("account")String account);

    @Select("select count(*) from user where email=#{user.email} and password=md5(#{user.password})")
    int selectByEmailAndPassword(@Param("user") User user);

    @Select("select count(*) from user where account=#{user.account} and password=md5(#{user.password})")
    int selectByAccountAndPassword(@Param("user") User user);

    @Insert("insert into user(email,account,password) values(#{user.email},#{user.account},md5(#{user.password}))")
    int addUser(@Param("user")User user);

    @Select("select id from user where account = #{account} or email = #{account}")
    int getUserIdByAccout(@Param("account") String account);

    @Select("select user.account,examination.pass_topic,examination.topic_num,examination.hand_date from user,examination where user.id = #{id}")
    List<UserExaminationInfo> getExaminationInfoByID(int id);
}

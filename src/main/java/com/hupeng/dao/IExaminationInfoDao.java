package com.hupeng.dao;

import com.hupeng.entity.ExaminationInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IExaminationInfoDao {
    @Insert("insert into examination values(#{info.id},#{info.pass_topic},#{info.topic_num},now())")
    int addExaminationInfo(@Param("info")ExaminationInfo examinationInfo);
}

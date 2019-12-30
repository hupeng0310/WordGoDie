package com.hupeng.dao;

import com.hupeng.entity.Vocabulary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVocabularyDao {
    @Select("select * from vocabulary limit #{start},#{end}")
    List<Vocabulary> SelectVocabularyById(@Param("start") int start, @Param("end") int end);
    @Select("select count(id) from vocabulary")
    int countVocabulary();
}

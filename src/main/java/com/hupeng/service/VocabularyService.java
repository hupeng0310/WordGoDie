package com.hupeng.service;

import com.hupeng.entity.Vocabulary;

import java.util.List;

public interface VocabularyService {
    List<Vocabulary> selectVocabularyById(int start,int end);
    int countVocabulary();
}

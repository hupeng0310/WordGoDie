package com.hupeng.service;

import com.hupeng.entity.Vocabulary;

import java.util.List;

public interface VocabularyService {
    public List<Vocabulary> selectVocabularyById(int start,int end);
}

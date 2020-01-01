package com.hupeng.service.imp;

import com.hupeng.dao.IVocabularyDao;
import com.hupeng.entity.Exercises;
import com.hupeng.entity.Vocabulary;
import com.hupeng.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vocabularyService")
public class VocabularyServiceImp implements VocabularyService {
    @Autowired
    IVocabularyDao iVocabularyDao;
    @Override
    public List<Vocabulary> selectVocabularyById(int start, int end) {
        return iVocabularyDao.SelectVocabularyById(start,end);
    }

    @Override
    public int countVocabulary() {
        return iVocabularyDao.countVocabulary();
    }

    @Override
    public Exercises produceExercises(Vocabulary vocabulary) {
        return null;
    }
}

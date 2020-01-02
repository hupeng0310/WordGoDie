package com.hupeng.service.imp;

import com.hupeng.dao.IVocabularyDao;
import com.hupeng.entity.Vocabulary;
import com.hupeng.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service("vocabularyService")
public class VocabularyServiceImp implements VocabularyService {
    private static final int VOCABULARY_NUMBER = 20;
    @Autowired
    IVocabularyDao iVocabularyDao;

    private HashSet<Integer> getVocabulariesID() {
        int maxVocabularyNumber = iVocabularyDao.countVocabulary();
        HashSet<Integer> vocabulariesIDSet = new HashSet<Integer>();
        while(vocabulariesIDSet.size() < VocabularyServiceImp.VOCABULARY_NUMBER) {
            vocabulariesIDSet.add((int)(Math.random()*maxVocabularyNumber + 1));
        }
        return vocabulariesIDSet;
    }

    @Override
    public List<Vocabulary> getVocabularies() {
        HashSet<Integer> vocabulariesIDSet = this.getVocabulariesID();
        ArrayList<Vocabulary> vocabularies = new ArrayList<Vocabulary>();
        for(int id:vocabulariesIDSet) {
            vocabularies.add(iVocabularyDao.SelectVocabularyById(id));
        }
        return vocabularies;
    }
}

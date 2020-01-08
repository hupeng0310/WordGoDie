package com.hupeng.service.imp;

import com.hupeng.dao.ExaminationInfoDao;
import com.hupeng.entity.ExaminationInfo;
import com.hupeng.service.ExaminationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ExaminationInfoService")
public class ExaminationInfoServiceImp implements ExaminationInfoService {
    @Autowired
    ExaminationInfoDao examinationInfoDao;
    @Override
    public boolean addExaminationInfo(ExaminationInfo examinationInfo) {
        return this.examinationInfoDao.addExaminationInfo(examinationInfo) > 0;
    }
}

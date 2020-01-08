package com.hupeng.service.imp;

import com.hupeng.dao.IExaminationInfoDao;
import com.hupeng.entity.ExaminationInfo;
import com.hupeng.service.ExaminationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ExaminationInfoService")
public class ExaminationInfoServiceImp implements ExaminationInfoService {
    @Autowired
    IExaminationInfoDao iExaminationInfoDao;
    @Override
    public boolean addExaminationInfo(ExaminationInfo examinationInfo) {
        return this.iExaminationInfoDao.addExaminationInfo(examinationInfo) > 0;
    }
}

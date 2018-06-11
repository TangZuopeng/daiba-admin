package com.daiba.user.service.impl;

import com.daiba.user.dao.QualificationDao;
import com.daiba.user.model.QualApplyUser;
import com.daiba.user.model.Qualification;
import com.daiba.user.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/11.
 */
@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    QualificationDao qualificationDao;

    @Override
    public List<QualApplyUser> getQualificationByStaId(int staId) {
        return qualificationDao.selectQualificationByStaId(staId);
    }
}

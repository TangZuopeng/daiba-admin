package com.daiba.user.service;

import com.daiba.user.model.QualApplyUser;

import java.util.List;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface QualificationService {

    public List<QualApplyUser> getQualificationByStaId(int staId);

}

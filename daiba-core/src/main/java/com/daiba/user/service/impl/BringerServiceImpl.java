package com.daiba.user.service.impl;

import com.daiba.user.dao.BringerDao;
import com.daiba.user.dao.QualificationDao;
import com.daiba.user.model.Address;
import com.daiba.user.service.BringerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tinydolphin on 2018/5/16.
 */
@Service("bringerService")
public class BringerServiceImpl implements BringerService {

    @Autowired
    QualificationDao qualificationDao;

    @Autowired
    BringerDao bringerDao;

    @Override
    public List<String> getOpenIdByCampus(String campus1,String campus2,int isReceiver) {
        return qualificationDao.selectOpenIdByCampus(campus1,campus2,isReceiver);
    }

    @Override
    public Address getBrierAddress(int briId) {
        return bringerDao.selectAddressByBriId(briId);
    }
}

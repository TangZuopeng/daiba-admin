package com.daiba.todaydata.service.impl;

import com.daiba.todaydata.dao.TodayDataDao;
import com.daiba.todaydata.model.TodayData;
import com.daiba.todaydata.service.TodayDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Created by tinydolphin on 2018/5/16.
 */
@Service("todayDateService")
public class TodayDataServiceImpl implements TodayDataService {

    @Autowired
    private TodayDataDao todayDataDao;

    @Override
    public TodayData getTodayData(HttpServletRequest request) {
        String startTime = "2017-05-30 00:00:00";
        String endTime = "2017-06-30 00:00:00";
        return todayDataDao.getTodayData(startTime, endTime);
    }
}

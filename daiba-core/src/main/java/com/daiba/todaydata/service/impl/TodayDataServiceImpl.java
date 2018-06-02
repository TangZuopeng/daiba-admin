package com.daiba.todaydata.service.impl;

import com.daiba.todaydata.dao.TodayDataDao;
import com.daiba.todaydata.service.TodayDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by dolphinzhou on 2016/10/16.
 */
@Service("todayDateService")
public class TodayDataServiceImpl implements TodayDataService {

    @Autowired
    private TodayDataDao todayDataDao;

}

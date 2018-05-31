package com.daiba.data.service.impl;

import com.daiba.data.dao.TodayDataDao;
import com.daiba.data.service.TodayDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by dolphinzhou on 2016/10/16.
 */
@Service("adminService")
public class TodayDataServiceImpl implements TodayDataService {

    @Autowired
    private TodayDataDao todayDataDao;

}

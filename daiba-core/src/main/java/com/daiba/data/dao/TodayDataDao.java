package com.daiba.data.dao;

import com.daiba.data.model.TodayData;
import com.daiba.mybatis.MyBatisScan;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by dolphinzhou on 2016/10/16.
 */
@MyBatisScan
public interface TodayDataDao {
    /**
     * 获取今日数据
     * @param date
     * @return
     */
    public TodayData getTodayData(@Param("date") Date date);

    /**
     * 更新管理员最近登录时间
     *
     * @param todayData
     */
//    public void updateAdminTime(TodayData todayData);
}

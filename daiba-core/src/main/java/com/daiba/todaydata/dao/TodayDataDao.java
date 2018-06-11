package com.daiba.todaydata.dao;

import com.daiba.todaydata.model.TodayData;
import com.daiba.mybatis.MyBatisScan;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by tinydolphin on 2018/5/16.
 */
@MyBatisScan
public interface TodayDataDao {

    /**
     * 获取今日数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public TodayData getTodayData(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 更新管理员最近登录时间
     *
     * @param todayData
     */
//    public void updateAdminTime(TodayData todayData);
}

package com.daiba.todaydata.service;

import com.daiba.todaydata.model.TodayData;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tinydolphin on 2018/5/16.
 */
public interface TodayDataService {
    /**
     * 管理员登录
     *
     * @param request
     * @return 1-登录成功 2-账户不存在 3-账号或密码不正确
     */
    public TodayData getTodayData(HttpServletRequest request);

}

package com.daiba.admin.dao;

import com.daiba.admin.model.Admin;
import com.daiba.mybatis.MyBatisScan;
import org.apache.ibatis.annotations.Param;

/**
 * Created by tinydolphin on 2018/5/16.
 */
@MyBatisScan
public interface AdminDao {
    /**
     * 根据管理员账号，获取管理员实例
     *
     * @param account
     * @return
     */
    public Admin selectByAccount(@Param("account") String account);

    /**
     * 更新管理员最近登录时间
     *
     * @param admin
     */
    public void updateAdminTime(Admin admin);
}

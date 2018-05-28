package com.daiba.user.service;

import com.daiba.user.model.Address;

import java.util.List;

/**
 * Created by dolphinzhou on 2016/10/16.
 */
public interface BringerService {
    /**
     * 通过校区获取带客的openId
     *
     * @param campus1
     * @param campus2
     * @return
     */
    public List<String> getOpenIdByCampus(String campus1,String campus2,int isReceiver);

    /**
     * 根据带客Id查其真实地址
     * @param briId
     * @return
     */
    public Address getBrierAddress(int briId);
}

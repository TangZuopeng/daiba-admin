package com.daiba.firm.service.impl;

import com.daiba.dishes.dao.DishesDao;
import com.daiba.firm.dao.FirmDao;
import com.daiba.firm.model.Firm;
import com.daiba.firm.service.FirmService;
import com.daiba.user.dao.BringerDao;
import com.daiba.user.dao.UserDao;
import com.daiba.user.model.User;
import com.daiba.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by tinydolphin on 2018/5/16.
 */
@Service("firmService")
public class FirmServiceImpl implements FirmService {

    @Autowired
    private FirmDao firmDao;

    @Autowired
    private BringerDao bringerDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DishesDao dishesDao;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<Firm> showAllFirm(String acceptAddCode, int orderType, int count) {
        List<Firm> firms = null;
        String key = RedisUtils.ORDER_PRE + acceptAddCode + "|" + orderType;
        if (count != 0) {
            return firmDao.selectAllFirmByOrderAcceptAddCode(acceptAddCode, orderType, count);
        }
        if (!redisUtils.hasKey(key)) {
            firms = firmDao.selectAllFirmByOrderAcceptAddCode(acceptAddCode, orderType, count);
            redisUtils.lSet(key, (List<Object>)(Object) firms, RedisUtils.EXPIRE_TIME);
            return firms;
        }
        List<Object> list = redisUtils.lGet(key, 0, 7);
        firms = (List<Firm>)(Object) list;
        return firms;
    }

    @Override
    public List<Firm> showUserAllFirm(int useId, int orderState) {
        return firmDao.selectAllFirmByUserId(useId, orderState);
    }

    @Override
    public List<Firm> showBringerAllFirm(int briId, int orderState) {
        return firmDao.selectAllFirmByBringerId(briId, orderState);
    }

    @Override
    public Firm acceptFirm(String firmId, int briId) {
        int orderState = 01;//已接单
        Date acceptTime = new Date();
        firmDao.updateFirmAcceptTime(firmId, orderState, acceptTime);
        firmDao.updateFirmBringer(firmId, briId);
        return getFirmDetail(firmId);
    }

    @Override
    public Firm getFirmDetail(String firmId) {
        return firmDao.selectFirmDetail(firmId);
    }

    @Override
    public int cancelFirm(String firmId, String phoneNum) {
        int orderState = 03;//已取消
        Date cancelTime = new Date();
        Firm firm = firmDao.selectFirmDetail(firmId);
        if (firm != null) {
            int firmStatus = firmDao.selectFirmSatus(firmId);
            if (firmStatus == 0) {
                String firmUserPhoneNum = firm.getUser().getPhoneNum();
                if (phoneNum.equals(firmUserPhoneNum)) {
                    //更新订单状态和时间
                    firmDao.updateFirmCancleTime(firmId, orderState, cancelTime);
                    int orderMoney = firm.getOrderMoney();
                    User user = firm.getUser();
                    int userId = user.getUserId();
                    String openId = user.getOpenId();

                    //取消订单之后用户的 发单数-1 金额也减少
                    userDao.downUserOrderNumAndSpending(userId, orderMoney);

                    return 1;
                } else {
                    return 4;
                }
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

    //用户确认收货
    /*@Override
    public int confirmFirm(String firmId, String phoneNum, String openId) {
        int orderState = 02;//已完成
        Date finishTime = new Date();
        Firm firm = firmDao.selectFirmDetail(firmId);
        if (firm != null) {
            if (firmDao.selectFirmSatus(firmId) == 1) {
                String firmUserPhoneNum = firm.getUser().getPhoneNum();
                //用户信息与该订单信息匹配情况
                if (phoneNum.equals(firmUserPhoneNum)) {
                    confirmFirmDo(firm, orderState, finishTime, openId);
                    return 1;
                } else {
                    return 4;
                }
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }*/

    @Override
    public void payFinishFirm(String firmId) {
        int orderState = 00;
        firmDao.updataFirmPayFinish(firmId, orderState);
    }

    @Override
    public int getFirmStatus(String firmId) {
        return firmDao.selectFirmSatus(firmId);
    }

    @Override
    public int cancelFirmByBringer(String firmId, String phoneNum) {
        int orderState = 03;//已取消
        Date cancelTime = new Date();
        Firm firm = firmDao.selectFirmDetail(firmId);
        if (firm != null) {
            int firmStatus = firmDao.selectFirmSatus(firmId);
            if (firmStatus == 1) {
                User bringer = userDao.selectAcceptUserInfo(firm.getBriId());
                //订单中带客的OpenId
                String bringerOpenId = bringer.getOpenId();
                String firmBringerPhoneNum = bringer.getPhoneNum();
                if (phoneNum.equals(firmBringerPhoneNum)) {
                    //更新订单状态和时间
                    firmDao.updateFirmCancleTime(firmId, orderState, cancelTime);
                    int orderMoney = firm.getOrderMoney();
                    User user = firm.getUser();
                    int userId = user.getUserId();
                    //订单中用户的OpenId
                    String userOpenId = user.getOpenId();

                    //取消订单之后用户的 发单数-1 金额也减少
                    userDao.downUserOrderNumAndSpending(userId, orderMoney);
                    //将申请取消状态还原
                    firmDao.updateIsApplyCancel(firmId, 0);
                    return 1;
                } else {
                    return 4;
                }
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

    //@Override
    //public int confirmFirmInfo(String firmId, String phoneNum) {
    //    Firm firm = firmDao.selectPhoneNumAndMoneyByFirmId(firmId);
    //    if(phoneNum.equals(firm.getUser().getPhoneNum())){
    //        return firm.getOrderMoney();
    //    }
    //    return 0;
    //}

    @Override
    public void addFirm(Firm firm, int userId, String orderId) {
        firmDao.addFirm(firm, userId, orderId);
    }

    @Override
    public List<Firm> loadFirmsToAdmin() throws Exception {
        return firmDao.selectFirmsByTableParams();
    }

    @Override
    public Firm loadFirmDetailToAdmin(String firmId) throws Exception {
        return firmDao.selectFirmDetailToAdmin(firmId);
    }
}

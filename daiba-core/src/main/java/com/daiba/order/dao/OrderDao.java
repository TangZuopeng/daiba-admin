package com.daiba.order.dao;

import com.daiba.mybatis.MyBatisScan;
import com.daiba.order.model.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author　 tinydolphin
 * @date　 2018-5-01  18:48
 * @description　 $
 */
@MyBatisScan
public interface OrderDao {

    /**
     * 根据 id 获取 order
     *
     * @param id
     * @return
     */
    public Order selectOrderById(String id);

    //插入一个订单
    public void addOrder(Order order);

    //根据取件号获得一个订单
    public Order getOrderByToakenNum(String tokenNum);

    /**
     * 根据 orderId 删除订单
     */
    public void deleteOrder(@Param("orderId") String orderId);

}

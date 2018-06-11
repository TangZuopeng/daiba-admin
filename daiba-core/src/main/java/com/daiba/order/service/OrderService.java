package com.daiba.order.service;

import com.daiba.order.model.Order;

/**
 * @author　 tinydolphin
 * @date　 2018-5-01  18:49
 * @description　 $
 */
public interface OrderService {

    /**
     * 根据id获取order实体类
     * @param id
     * @return
     */
    public Order getOrderById(String id);

    public void addOrder(Order order) throws Exception;

    public Order getOrder(String tokenNum) throws  Exception;

}

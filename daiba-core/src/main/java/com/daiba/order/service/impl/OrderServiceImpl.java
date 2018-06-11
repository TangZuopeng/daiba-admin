package com.daiba.order.service.impl;

import com.daiba.order.dao.OrderDao;
import com.daiba.order.model.Order;
import com.daiba.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author　 tinydolphin
 * @date　 2018-5-01  18:51
 * @description　 $
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order getOrderById(String id) {
        return orderDao.selectOrderById(id);
    }

    @Override
    public void addOrder(Order order) throws Exception {
        orderDao.addOrder(order);
    }

    @Override
    public Order getOrder(String tokenNum) throws Exception {
        return orderDao.getOrderByToakenNum(tokenNum);
    }
}

package com.libaoshen.hrs.dao;

import java.util.List;

import com.libaoshen.hrs.bean.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderid);
    
    List<Order> selectAllOrder();
    
    List<Order> selectByUserId(Integer userid);
    
    List<Order> selectByOrderState(String orderstate);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
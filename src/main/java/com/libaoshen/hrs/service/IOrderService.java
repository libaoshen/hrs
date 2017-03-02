package com.libaoshen.hrs.service;

import java.sql.Date;
import java.util.List;

import com.libaoshen.hrs.bean.Order;

public interface IOrderService {
	//添加订单
	public void addOrder(Order order);
	//查询所有的订单
	public List<Order> getAllOrder();
	//根据id查找订单
	public Order getOrderById(Long orderid);
	//根据用户id查找订单
	public List<Order> getOrdersByUserId(Integer userid);
	//删除订单
	public void deleteOrder(Order order);
	//修改订单
	public void updateOrder(Order order);
	//根据下单时间查询订单
	public List<Order> getOrdersByOrderTime(Date orderTime);
	//根据订单状态查找订单
	public List<Order> getOrdersByOrderState(String orderState);
}

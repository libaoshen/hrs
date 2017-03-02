package com.libaoshen.hrs.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.libaoshen.hrs.bean.Order;
import com.libaoshen.hrs.dao.OrderMapper;
import com.libaoshen.hrs.service.IOrderService;
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	@Resource
	private OrderMapper orderMapper;
	
	public void addOrder(Order order) {
		orderMapper.insert(order);
	}

	public Order getOrderById(Long orderid) {
		return orderMapper.selectByPrimaryKey(orderid);
	}

	public List<Order> getOrdersByUserId(Integer userid) {
		return orderMapper.selectByUserId(userid);
	}

	public void deleteOrder(Order order) {
		orderMapper.deleteByPrimaryKey(order.getOrderid());
	}

	public void updateOrder(Order order) {
		orderMapper.updateByPrimaryKey(order);
	}

	public List<Order> getOrdersByOrderTime(Date orderTime) {
		List<Order> orderList = orderMapper.selectAllOrder();
		//转化为格式化字符串,然后比较其两个字符串是否在同一天
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0 ; i < orderList.size(); i++){
			if(!sdf.format(orderList.get(i).getOrdertime()).equals(sdf.format(new java.util.Date(orderTime.getTime())))) {
				orderList.remove(i);
			}
		}
		
		return orderList;
	}

	public List<Order> getOrdersByOrderState(String orderState) {
		return orderMapper.selectByOrderState(orderState);
	}

	public List<Order> getAllOrder() {
		return orderMapper.selectAllOrder();
	}
}

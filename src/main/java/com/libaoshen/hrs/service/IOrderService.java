package com.libaoshen.hrs.service;

import java.sql.Date;
import java.util.List;

import com.libaoshen.hrs.bean.Order;

public interface IOrderService {
	//��Ӷ���
	public void addOrder(Order order);
	//��ѯ���еĶ���
	public List<Order> getAllOrder();
	//����id���Ҷ���
	public Order getOrderById(Long orderid);
	//�����û�id���Ҷ���
	public List<Order> getOrdersByUserId(Integer userid);
	//ɾ������
	public void deleteOrder(Order order);
	//�޸Ķ���
	public void updateOrder(Order order);
	//�����µ�ʱ���ѯ����
	public List<Order> getOrdersByOrderTime(Date orderTime);
	//���ݶ���״̬���Ҷ���
	public List<Order> getOrdersByOrderState(String orderState);
}

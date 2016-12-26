package com.libaoshen.hrs.admin.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.libaoshen.hrs.bean.Admin;
import com.libaoshen.hrs.bean.Order;
import com.libaoshen.hrs.service.IAdminService;
import com.libaoshen.hrs.service.IOrderService;

/**
 * ������Ԫ������
 * @author 404
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)		//��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class OrderTest01 {
	private static Logger logger = Logger.getLogger(AdminTest01.class);
	@Resource
	private IOrderService orderService;
	
	@Test
	public void testOrder01(){
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
		//���
//		Order order = new Order();
//		order.setUserid(3);
//		order.setRoomid(3);
//		try {
//			order.setEndtime(sdf.parse("2016-12-10"));
//			order.setStarttime(sdf.parse("2016-12-08"));
//			order.setDeadline(sdf.parse("2016-12-09"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		order.setRoomnum(3);
//		order.setOrdertime(new Date());
//		order.setOrderip("127.0.0.1");
//		order.setTotalprice(1200.0f);
//		order.setOrderstate("δ֧��");
//		order.setRegisterinfo("����,����,����");
//		order.setRemarks("лл,ϣ���ܾ�����ס");
		
		//orderService.addOrder(order);
		//��ѯ
		//List<Order> order1 = orderService.getOrdersByUserId(3);
		
//		List<Order> order1 = new ArrayList<Order>();
//		try {
//			order1 = orderService.getOrdersByOrderTime(new java.sql.Date(sdf.parse("2016-12-08").getTime()));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(Order o : order1) {
//			logger.info(JSON.toJSONString(o));
//		}
		
		Order order = orderService.getOrderById(4L);
		logger.info(JSON.toJSONString(order));
		
//		List<Order> orderList = orderService.getOrdersByOrderState("δ֧��");
//		for(Order o : orderList){
//			logger.info(JSON.toJSONString(o));
//		}
		
//		List<Order> orderList = orderService.getAllOrder();
//		for(Order o : orderList){
//			logger.info(JSON.toJSONString(o));
//		}
		
		order.setRemarks("лл");
		orderService.updateOrder(order);
		
		orderService.deleteOrder(order);
	}
}

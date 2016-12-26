package com.libaoshen.hrs.admin.test;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.libaoshen.hrs.bean.Room;
import com.libaoshen.hrs.service.IRoomService;

@RunWith(SpringJUnit4ClassRunner.class)		//��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RoomTest01 {
	private static Logger logger = Logger.getLogger(AdminTest01.class);
	@Resource
	private IRoomService roomService;
	
	@Test
	public void testRoomFunction(){
		//addRoom
		Room room = new Room();
		room.setRoomname("��׼��");
		room.setBedtype("˫�˴�");
		room.setRoomprice(400.0f);
		room.setRoomtotalnum(20);
		room.setRoomleftnum(20);
		room.setHasbroadband(true);
		room.setDescription("���������21-24ƽ����;¥�㣺2-6��;���ͣ����˴�1.1�ף�2��;�ɼӴ���RMB 100/��/��ҹ;�����ס������2��");
		room.setImginfo("1.png;2.png");
		roomService.addRoom(room);
		
		//selectAllRoom
//		List<Room> rooms = roomService.getAllRoom();
//		for(Room r : rooms){
//			logger.info(JSON.toJSONString(r));
//		}
		
		//������Ϣ�������־����
		//selectRoomById
//		Room room = roomService.getRoomById(1);
//		logger.info(JSON.toJSONString(room));
		
		//selectRoomByRoomName
//		Room room = roomService.getRoomByRoomName("��׼��");
//		logger.info(JSON.toJSONString(room));
		
		//updateRoom
//		Room room = new Room();
//		room.setRoomid(1);
//		room.setRoomname("��׼��1");
//		room.setBedtype("˫�˴�");
//		room.setRoomprice(300.0f);
//		room.setRoomtotalnum(18);
//		room.setRoomleftnum(15);
//		room.setHasbroadband(true);
//		room.setDescription("���������21-24ƽ����;¥�㣺2-6��;���ͣ����˴�1.1�ף�2��;�ɼӴ���RMB 100/��/��ҹ;�����ס������2��");
//		room.setImginfo("1.png;2.png");
//		
//		roomService.updateRoom(room);
//		logger.info(JSON.toJSONString(roomService.getRoomById(1)));
		
		//deleteRoomById
//		int i = roomService.deleteRoomByRoomId(1);
//		logger.info(i);
	}
}

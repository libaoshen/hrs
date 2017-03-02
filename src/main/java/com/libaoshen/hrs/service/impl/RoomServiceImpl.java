package com.libaoshen.hrs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.libaoshen.hrs.bean.Room;
import com.libaoshen.hrs.dao.RoomMapper;
import com.libaoshen.hrs.service.IRoomService;

/**
 * 房型服务实现类
 * @author 404
 *
 */
@Service("roomService")
public class RoomServiceImpl implements IRoomService {
	@Resource
	private RoomMapper roomMapper;
	
	public Room getRoomById(Integer roomId) {
		return roomMapper.selectByPrimaryKey(roomId);
	}

	public Room getRoomByRoomName(String roomName) {
		return roomMapper.selectByRoomName(roomName);
	}

	public int deleteRoomByRoomId(Integer roomId) {
		return roomMapper.deleteByPrimaryKey(roomId);
	}

	public void updateRoom(Room room) {
		roomMapper.updateByPrimaryKey(room);
	}

	public void addRoom(Room room) {
		roomMapper.insert(room);
		
	}

	public List<Room> getAllRoom() {
		return roomMapper.selectAllRoom();
	}
	
}

package com.libaoshen.hrs.service;

import java.util.List;

import com.libaoshen.hrs.bean.Room;

/**
 * 房间服务类
 * @author 404
 *
 */
public interface IRoomService {
	//根据主键id查找房型信息
	public Room getRoomById(Integer roomId);
	//根据房型名查找房型信息
	public Room getRoomByRoomName(String roomName);
	//根据房型id删除房型信息
	public int deleteRoomByRoomId(Integer roomId);
	//修改房型信息
	public void updateRoom(Room room);
	//增加房型信息
	public void addRoom(Room room);
	//查找所有房型信息
	public List<Room> getAllRoom();
}

package com.libaoshen.hrs.service;

import java.util.List;

import com.libaoshen.hrs.bean.Room;

/**
 * ���������
 * @author 404
 *
 */
public interface IRoomService {
	//��������id���ҷ�����Ϣ
	public Room getRoomById(Integer roomId);
	//���ݷ��������ҷ�����Ϣ
	public Room getRoomByRoomName(String roomName);
	//���ݷ���idɾ��������Ϣ
	public int deleteRoomByRoomId(Integer roomId);
	//�޸ķ�����Ϣ
	public void updateRoom(Room room);
	//���ӷ�����Ϣ
	public void addRoom(Room room);
	//�������з�����Ϣ
	public List<Room> getAllRoom();
}

package com.libaoshen.hrs.dao;

import java.util.List;

import com.libaoshen.hrs.bean.Room;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomid);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomid);


    Room selectByRoomName(String roomName);

    List<Room> selectAllRoom();
    
    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}
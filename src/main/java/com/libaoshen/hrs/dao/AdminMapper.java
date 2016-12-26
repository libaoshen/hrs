package com.libaoshen.hrs.dao;

import java.util.List;

import com.libaoshen.hrs.bean.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminid);
    
    Admin selectByUniqueKey(String adminname);
    
    List<Admin> selectAll();

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}
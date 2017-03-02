package com.libaoshen.hrs.service;

import java.util.List;

import com.libaoshen.hrs.bean.User;

/**
 * 用户服务类
 * @author 404
 *
 */
public interface IUserService {
	//根据主键id查找用户信息
	public User getUserById(Integer userId);
	//根据用户名查找用户信息
	public User getUserByUserName(String userName);
	//修改用户信息
	public void updateUser(User user);
	//增加用户信息
	public void addUser(User user);
	//查找所有的用户信息
	public List<User> getAllUser();
}

package com.libaoshen.hrs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.libaoshen.hrs.bean.User;
import com.libaoshen.hrs.dao.UserMapper;
import com.libaoshen.hrs.service.IUserService;

/**
 * 用户服务实现类
 * @author 404
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource 
	private UserMapper userMapper;

	public User getUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public User getUserByUserName(String userName) {
		return userMapper.selectByUserName(userName);
	}

	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	public void addUser(User user) {
		userMapper.insert(user);
	}

	public List<User> getAllUser() {
		return userMapper.selectAll();
	}
}

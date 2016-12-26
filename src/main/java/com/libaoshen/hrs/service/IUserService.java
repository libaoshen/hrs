package com.libaoshen.hrs.service;

import java.util.List;

import com.libaoshen.hrs.bean.User;

/**
 * �û�������
 * @author 404
 *
 */
public interface IUserService {
	//��������id�����û���Ϣ
	public User getUserById(Integer userId);
	//�����û��������û���Ϣ
	public User getUserByUserName(String userName);
	//�޸��û���Ϣ
	public void updateUser(User user);
	//�����û���Ϣ
	public void addUser(User user);
	//�������е��û���Ϣ
	public List<User> getAllUser();
}

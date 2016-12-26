package com.libaoshen.hrs.service;

import java.util.List;

import com.libaoshen.hrs.bean.Admin;

/**
 * 管理员服务类
 * @author 404
 *
 */
public interface IAdminService {
	//根据主键id查找管理员
	public Admin getAdminById(int adminId);
	//根据unique值adminName查找管理员
	public Admin getAdminByAdminName(String adminName);
	//查询所有的管理员信息
	public List<Admin> getAllAdmin();
}

package com.libaoshen.hrs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.libaoshen.hrs.bean.Admin;
import com.libaoshen.hrs.dao.AdminMapper;
import com.libaoshen.hrs.service.IAdminService;

/**
 * 管理员服务接口实现类，同时采用注解声明为一个bean，名为adminService
 * @author 404
 *
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {
	
	@Resource
	private AdminMapper adminMapper;
	
	public Admin getAdminByAdminName(String adminName) {
		return adminMapper.selectByUniqueKey(adminName);
	}

	public Admin getAdminById(int adminId) {
		return adminMapper.selectByPrimaryKey(adminId);
	}
	
	public List<Admin> getAllAdmin() {
		return adminMapper.selectAll();
	}
}

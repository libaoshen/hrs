package com.libaoshen.hrs.admin.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.libaoshen.hrs.bean.Admin;
import com.libaoshen.hrs.service.IAdminService;

/**
 * ����Ա��Ԫ������
 * @author 404
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)		//��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class AdminTest01 {
	private static Logger logger = Logger.getLogger(AdminTest01.class);
	@Resource
	private IAdminService adminService;
	
	@Test
	public void testMybatis(){
		//Admin admin = adminService.getAdminById(1);
		Admin admin = adminService.getAdminByAdminName("admin");
		//������Ϣ�������־����
		logger.info(JSON.toJSONString(admin));
		List<Admin> admins = adminService.getAllAdmin();
		for(Admin a : admins){
			logger.info(JSON.toJSONString(a));
		}
	}
}

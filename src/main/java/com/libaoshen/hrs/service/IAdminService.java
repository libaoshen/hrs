package com.libaoshen.hrs.service;

import java.util.List;

import com.libaoshen.hrs.bean.Admin;

/**
 * ����Ա������
 * @author 404
 *
 */
public interface IAdminService {
	//��������id���ҹ���Ա
	public Admin getAdminById(int adminId);
	//����uniqueֵadminName���ҹ���Ա
	public Admin getAdminByAdminName(String adminName);
	//��ѯ���еĹ���Ա��Ϣ
	public List<Admin> getAllAdmin();
}

package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysRole;

/**
 * ��ɫ��Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��18�� ����9:07:05
 */
public interface SysRoleDao {
	
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	List<SysRole> querySysRole();
	
	/**
	 * �޸Ľ�ɫ
	 */
	int updateSysRole(Map<String,Object> mp);
	
	/**
	 * ��ӽ�ɫ
	 */
	int insertSysRole(Map<String, Object> mp);
	
	/**
	 * ��id�鿴��ɫ
	 */
	int selectSysRoleByName(Map<String,String> mp);


} 

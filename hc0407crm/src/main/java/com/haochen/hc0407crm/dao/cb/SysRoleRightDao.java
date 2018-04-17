package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysRight;
import com.haochen.hc0407crm.entity.SysRoleRight;

/**
 * ��ɫȨ��Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��7�� ����5:51:09
 */
public interface SysRoleRightDao {
	
	/**
	 * ���������ҽ�ɫȨ��
	 * @param mp
	 * @return
	 */
	List<SysRight> listSysRoleRight(Map mp);
	
	/**
	 * ��ӽ�ɫȨ��
	 * @param mp
	 * @return
	 */
	int insertSysRoleRight(Map<String,Object> mp);
	
	/**
	 * ɾ����ɫȨ��
	 * 
	 */
	int deleteSysRoleRight(Map<String, Object> mp);
}

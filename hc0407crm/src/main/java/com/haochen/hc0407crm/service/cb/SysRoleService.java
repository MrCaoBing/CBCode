package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysRight;
import com.haochen.hc0407crm.entity.SysRole;

/**
 * �ͻ���Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��18�� ����9:18:53
 */
public interface SysRoleService {
	
	/**
	 * �г����н�ɫ
	 * @return
	 */
	List<SysRole> listSysRole();
	
	
	/**
	 * ��ӽ�ɫ
	 */
	int addSysRole();
	
	/**
	 * ����ɫid�鿴Ȩ��
	 */
	List<SysRight> listSysRoleById(Map<String,String> mp);
	
	/**
	 * �жϽ�ɫ�����Ƿ����
	 * @param mp
	 * @return
	 */
	int ifRoleNameExists(Map<String,String> mp);
	
	/**
	 * ��ӽ�ɫȨ��
	 * @param mp
	 * @return
	 * @throws Exception 
	 */
	int addSysRoleRight(Map<String,Object> mp) throws Exception;
	
	/**
	 * �޸Ľ�ɫȨ��
	 * @param mp
	 * @return
	 * @throws Exception 
	 */
	int setSysRoleRight(Map<String,Object> mp) throws Exception;
	
}

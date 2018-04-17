package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.Node;
import com.haochen.hc0407crm.entity.SysUser;
import com.haochen.hc0407crm.utils.Paging;

/**
 * ϵͳ�û���Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��7�� ����4:48:49
 */
public interface SysUserService {
	
	/**
	 * �û���¼����¼�ɹ�����Ȩ�޽ڵ��ϣ����򷵻�null
	 * @param mp
	 * @return
	 */
	Map login(Map mp);
	
	/**
	 * �����ֵ���Ҫ���г������û�
	 * @param pg
	 * @return
	 */
	Paging listAllSysUser(Paging pg);
	
	/**
	 * �޸��û�
	 * @param mp
	 * @return
	 */
	int setSysUser(Map<String,String> mp);
	
	/**
	 * ����û�
	 * @param mp
	 * @return
	 */
	int addSysUser(Map<String,String> mp);
	
	/**
	 * �ж��û��Ƿ����
	 * @param name
	 * @return
	 */
	int ifSysUserNameExists(String name);
}

package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysUser;
import com.haochen.hc0407crm.utils.Paging;
/**
 * ϵͳ�û���Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��7�� ����4:16:50
 */
public interface SysUserDao {
	
	/**
	 * �������г�ϵͳ�û�
	 * @param mp
	 * @return
	 */
	List<SysUser> listSysUser(Map mp);
	

	/**
	 * ��ѯ�����˵���Ϣ
	 * @param �û��ı��
	 * @return ����һ����ѯ����Ϣ
	 */
	SysUser selectCreateUserInfo(int id);
	
	
	/**
	 * ��ѯָ�ɾ������Ϣ
	 * @param �û��ı��
	 * @return ����һ����ѯ����Ϣ
	 */
	SysUser selectDueUserInfo(int id);
	
	/**
	 * �����ֵ���Ҫ���г������û�
	 * @param pg
	 * @return
	 */
	List<SysUser> queryAllSysUser(Paging pg);
	
	/**
	 * �����ֵ���Ҫ���г������û�������Ŀ
	 * @param pg
	 * @return
	 */
	int queryAllSysUserCount(Paging pg);
	
	/**
	 * �޸��û�
	 * @param mp
	 * @return
	 */
	int updateSysUser(Map<String,String> mp);
	
	/**
	 * ����û�
	 * @param mp
	 * @return
	 */
	int insertSysUser(Map<String,String> mp);
	
	/**
	 * �����ֲ�ѯ�û�
	 * @param name
	 * @return
	 */
	int querySysUserByName(String name);
}

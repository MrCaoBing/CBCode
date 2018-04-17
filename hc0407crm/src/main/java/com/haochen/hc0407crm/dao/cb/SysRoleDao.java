package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysRole;

/**
 * 角色的Dao接口
 * @author Mr.Cao
 * @date 2018年1月18日 上午9:07:05
 */
public interface SysRoleDao {
	
	/**
	 * 查询所有角色
	 * @return
	 */
	List<SysRole> querySysRole();
	
	/**
	 * 修改角色
	 */
	int updateSysRole(Map<String,Object> mp);
	
	/**
	 * 添加角色
	 */
	int insertSysRole(Map<String, Object> mp);
	
	/**
	 * 按id查看角色
	 */
	int selectSysRoleByName(Map<String,String> mp);


} 

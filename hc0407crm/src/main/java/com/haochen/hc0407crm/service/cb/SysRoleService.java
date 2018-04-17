package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysRight;
import com.haochen.hc0407crm.entity.SysRole;

/**
 * 客户的Service接口
 * @author Mr.Cao
 * @date 2018年1月18日 上午9:18:53
 */
public interface SysRoleService {
	
	/**
	 * 列出所有角色
	 * @return
	 */
	List<SysRole> listSysRole();
	
	
	/**
	 * 添加角色
	 */
	int addSysRole();
	
	/**
	 * 按角色id查看权限
	 */
	List<SysRight> listSysRoleById(Map<String,String> mp);
	
	/**
	 * 判断角色名字是否存在
	 * @param mp
	 * @return
	 */
	int ifRoleNameExists(Map<String,String> mp);
	
	/**
	 * 添加角色权限
	 * @param mp
	 * @return
	 * @throws Exception 
	 */
	int addSysRoleRight(Map<String,Object> mp) throws Exception;
	
	/**
	 * 修改角色权限
	 * @param mp
	 * @return
	 * @throws Exception 
	 */
	int setSysRoleRight(Map<String,Object> mp) throws Exception;
	
}

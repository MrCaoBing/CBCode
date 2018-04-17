package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysRight;
import com.haochen.hc0407crm.entity.SysRoleRight;

/**
 * 角色权限Dao接口
 * @author Mr.Cao
 * @date 2018年1月7日 下午5:51:09
 */
public interface SysRoleRightDao {
	
	/**
	 * 按条件查找角色权限
	 * @param mp
	 * @return
	 */
	List<SysRight> listSysRoleRight(Map mp);
	
	/**
	 * 添加角色权限
	 * @param mp
	 * @return
	 */
	int insertSysRoleRight(Map<String,Object> mp);
	
	/**
	 * 删除角色权限
	 * 
	 */
	int deleteSysRoleRight(Map<String, Object> mp);
}

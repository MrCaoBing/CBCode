package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.Node;
import com.haochen.hc0407crm.entity.SysUser;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 系统用户的Service接口
 * @author Mr.Cao
 * @date 2018年1月7日 下午4:48:49
 */
public interface SysUserService {
	
	/**
	 * 用户登录，登录成功返回权限节点结合，否则返回null
	 * @param mp
	 * @return
	 */
	Map login(Map mp);
	
	/**
	 * 数据字典需要理列出所有用户
	 * @param pg
	 * @return
	 */
	Paging listAllSysUser(Paging pg);
	
	/**
	 * 修改用户
	 * @param mp
	 * @return
	 */
	int setSysUser(Map<String,String> mp);
	
	/**
	 * 添加用户
	 * @param mp
	 * @return
	 */
	int addSysUser(Map<String,String> mp);
	
	/**
	 * 判断用户是否存在
	 * @param name
	 * @return
	 */
	int ifSysUserNameExists(String name);
}

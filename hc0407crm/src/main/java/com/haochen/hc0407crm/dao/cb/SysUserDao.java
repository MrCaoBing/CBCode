package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SysUser;
import com.haochen.hc0407crm.utils.Paging;
/**
 * 系统用户的Dao接口
 * @author Mr.Cao
 * @date 2018年1月7日 下午4:16:50
 */
public interface SysUserDao {
	
	/**
	 * 按条件列出系统用户
	 * @param mp
	 * @return
	 */
	List<SysUser> listSysUser(Map mp);
	

	/**
	 * 查询创建人的信息
	 * @param 用户的编号
	 * @return 返回一个查询的信息
	 */
	SysUser selectCreateUserInfo(int id);
	
	
	/**
	 * 查询指派经理的信息
	 * @param 用户的编号
	 * @return 返回一个查询的信息
	 */
	SysUser selectDueUserInfo(int id);
	
	/**
	 * 数据字典需要理列出所有用户
	 * @param pg
	 * @return
	 */
	List<SysUser> queryAllSysUser(Paging pg);
	
	/**
	 * 数据字典需要理列出所有用户数据条目
	 * @param pg
	 * @return
	 */
	int queryAllSysUserCount(Paging pg);
	
	/**
	 * 修改用户
	 * @param mp
	 * @return
	 */
	int updateSysUser(Map<String,String> mp);
	
	/**
	 * 添加用户
	 * @param mp
	 * @return
	 */
	int insertSysUser(Map<String,String> mp);
	
	/**
	 * 按名字查询用户
	 * @param name
	 * @return
	 */
	int querySysUserByName(String name);
}

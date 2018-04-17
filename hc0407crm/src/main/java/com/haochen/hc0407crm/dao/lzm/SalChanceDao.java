package com.haochen.hc0407crm.dao.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SalChance;

public interface SalChanceDao {
	
	/**
	 * 查询所有的销售机会，可按照条件模糊查询，并分页
	 * @param 传递过来的参数条件
	 * @return	返回一个查询信息的结果集
	 */
	List<SalChance> selectAllSalChanceInfo(Map<String,Object> map);
	
	
	/**
	 * 查询销售机会的总记录信息
	 * @return 返回一个受影响的行数
	 */
	int selectSalChanceCountRecordInfo(Map<String,Object> map);
	
	/**
	 * 新增销售机会
	 * @param 传递一个要添加的数据对象
	 * @return 返回一个受影响的行数,大于0则成功
	 */
	int insertSalChanceInfo(SalChance salChance);
	
	
	/**
	 * 删除销售机会,根据传递过来的参数,删除指定的信息
	 * @param 参数条件
	 * @return 返回一个受影响的行数,大于0则成功
	 */
	int deleteSalChanceInfo(Integer chcId);
	
	
	/**
	 * 修改销售机会
	 * @param 传递一个要修改的数据对象
	 * @return 返回一个受影响的行数
	 */
	int updateSalChanceInfo(Map<String,Object> map);
	
	/**
	 * 根据条件查询指定的销售机会
	 * @param id
	 * @return
	 */
	SalChance selectAppointSalChanceInfo(Integer id);
	
	/**
	 * 根据客户名称查询是否存在客户。
	 * @param name
	 * @return
	 */
	SalChance selectCheckchcCustName(String name);
	
}

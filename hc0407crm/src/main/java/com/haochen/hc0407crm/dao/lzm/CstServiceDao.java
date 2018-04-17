package com.haochen.hc0407crm.dao.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstService;
import com.haochen.hc0407crm.utils.Paging;

public interface CstServiceDao {
	
	/**
	 * 查询所有已分配的客户服务信息,可根据条件模糊查询并分页
	 * @param map
	 * @return
	 */
	List<CstService> selectCstServiceInfo(Map<String,Object> map);
	
	/**
	 * 处理(修改)客户服务信息
	 * @param map
	 * @return
	 */
	Integer updateCstServiceInfo(Map<String,Object> map);
	
	/**
	 * 查询所有已分配的客户服务总条数,可根据条件模糊查询
	 * @param map
	 * @return
	 */
	Integer selectCstServiceInfoCount(Map<String,Object> map);
	
	/**
	 * 对服务的创建（新增）
	 * @param map
	 * @return
	 */
	int insertCstService(Map map);
	/**
	 * 查询所有新创建的客户，分页并可查询
	 * @param pg
	 * @return
	 */
	List<CstService> listCstServiceTiaojian(Paging<CstService> pg);
	/**
	 * 所有新创建客户的总条数
	 * @param pg
	 * @return
	 */
	int findCstServiceCount(Paging pg);
	/**
	 * 删除服务分配中新创建的服务
	 * @param map
	 * @return
	 */
	int deleteCstService(Map map);
	/**
	 * 为新创建的服务信息指定处理经理
	 * @param map
	 * @return
	 */
	int updateCstService(Map map);
}

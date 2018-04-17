package com.haochen.hc0407crm.service.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstService;
import com.haochen.hc0407crm.utils.Paging;

public interface CstServiceService {

	/**
	 * 查询所有已分配的客户服务信息
	 * 
	 * @param map
	 * @return
	 */
	List<CstService> findCstServiceInfo(Map<String, Object> map);

	/**
	 * 处理(修改)客户服务信息
	 * 
	 * @param map
	 * @return
	 */
	Integer setCstServiceInfo(Map<String, Object> map);

	/**
	 * 查询所有已分配的客户服务总条数,可根据条件模糊查询
	 * 
	 * @param map
	 * @return
	 */
	Integer findCstServiceInfoCount(Map<String, Object> map);

	/**
	 * 对服务的创建（新增）
	 * 
	 * @param map
	 * @return
	 */
	int addCstService(Map map);

	/**
	 * 查询所有新创建的客户，分页并可查询
	 * 
	 * @param pg
	 * @return
	 */
	Paging findCstServiceTiaojian(Paging<CstService> pg);

	/**
	 * 删除服务分配中新创建的服务
	 * 
	 * @param map
	 * @return
	 */
	int delCstService(Map map);
	
	/**
	 * 指定分配人（修改）
	 * @param map
	 * @return
	 */
	int setCstService(Map map);
}

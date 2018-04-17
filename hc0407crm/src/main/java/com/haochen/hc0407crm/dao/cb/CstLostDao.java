package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLost;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 客户流失的Dao
 * @author Mr.Cao
 * @date 2018年1月12日 下午7:21:00
 */
public interface CstLostDao {
	
	/**
	 * 查询客户流失信息
	 * @param pg
	 * @return
	 */
	List<CstLost> queryCstLost(Paging pg);
	
	/**
	 * 查询客户流失信息数据条目
	 * @param pg
	 * @return
	 */
	int queryCstLostCount(Paging pg);
	
	/**
	 * 修改客户流失信息
	 * @param pg
	 * @return
	 */
	int updateCstLost(Map mp);
	
	/**
	 * 插入客户流失信息
	 * @param map
	 * @return
	 */
	int insertCstLost(Map mp);
	
	
}
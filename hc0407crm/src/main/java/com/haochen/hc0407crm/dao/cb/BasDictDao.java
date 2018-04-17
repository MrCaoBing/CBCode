package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.BasDict;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 数据字典的Dao接口
 * 
 * @author Mr.Cao
 * @date 2018年1月8日 下午3:01:32
 */
public interface BasDictDao {
	/**
	 * 按条件列出BasDict
	 * 
	 * @param map
	 * @return
	 */
	List<BasDict> listBasDict(Map map);

	/**
	 * 按条件查询客户
	 * 
	 * @param mp
	 * @return
	 */
	List<BasDict> listBasDictTiaojian(Paging<BasDict> pg);
	
	/**
	 * 分页之前查询页码条数
	 * @param mp
	 * @return
	 */
	int findBasDictCount(Paging pg);
	
	/**
	 * 新增
	 * @param mp
	 * @return
	 */
	int insertBasDict(Map mp);
	
	/**
	 * 删除
	 * @param mp
	 * @return
	 */
	int deleteBasDict(Map mp);
	
	/**
	 * 修改
	 * @param mp
	 * @return
	 */
	int updateBasDict(Map mp);
	
	int findDictItem(String dictItem);
}

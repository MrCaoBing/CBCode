package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.BasDict;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 数据字典的Service接口
 * @author Mr.Cao
 * @date 2018年1月8日 下午3:11:13
 */
public interface BasDictService {
	
	/**
	 * 加载程序的基础数据
	 * @return
	 */
	Map loadFoundationData();
	
	/**
	 * 按条件查询客户
	 * @param pg
	 * @return
	 */
	Paging listBasDictTiaojian(Paging<BasDict> pg);
	
	/**
	 * 新增
	 * @param mp
	 * @return
	 */
	int addBasDict(Map mp);
	
	/**
	 * 删除
	 * @param mp
	 * @return
	 */
	int delBasDict(Map mp);
	
	/**
	 * 修改
	 * @param mp
	 * @return
	 */
	int setBasDict(Map mp);
	
	int findDictItem(String dictItem1);
}

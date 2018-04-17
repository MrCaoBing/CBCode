package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLost;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 客户流失信息的Service接口
 * @author Mr.Cao
 * @date 2018年1月12日 下午8:00:21
 */
public interface CstLostService {
	
	/**
	 * 列出客户流失信息
	 * @param pg
	 * @return
	 */
	Paging listCstLost(Paging pg);
	
	/**
	 * 修改客户流失信息
	 * @param mp
	 * @return
	 * @throws Exception 
	 */
	int setCstLost(Map mp) throws Exception;
	
	/**
	 * 修改客户流失信息
	 * @param mp
	 * @return
	 */
	int addCstLost(Map mp);
}

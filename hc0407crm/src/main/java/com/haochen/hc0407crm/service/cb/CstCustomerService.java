package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 客户的Service接口
 * @author Mr.Cao
 * @date 2018年1月8日 下午8:28:30
 */
public interface CstCustomerService {
	
	/**
	 * 按条件列出客户
	 * @param pg
	 * @return
	 */
	Paging listCstCustomer(Paging<CstCustomer> pg);
	
	/**
	 * 按客户编号拿到客户对象
	 * @param mp
	 * @return
	 */
	CstCustomer findCstCustomerById(Map mp);
	
	/**
	 * 添加客户对象
	 * @param mp
	 * @return
	 */
	int addCstCustomer(Map mp);
	
	/**
	 * 修改客户
	 * @param mp
	 * @return
	 */
	int setCstCustomer(Map mp);
	
	/**
	 * 根据用户编号查询用户
	 * @param mp
	 * @return
	 */
	CstCustomer findCstCustomerInfo(String custNo);
	
	/**
	 * 根据用户Id(自动增长)查询用户,判断id客户是否存在
	 * @param mp
	 * @return
	 */
	CstCustomer getCstCustomerByName(String custName);
}

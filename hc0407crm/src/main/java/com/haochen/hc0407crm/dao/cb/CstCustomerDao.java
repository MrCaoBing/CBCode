package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 客户的Dao接口
 * @author Mr.Cao
 * @date 2018年1月8日 下午7:51:24
 */
public interface CstCustomerDao {
	/**
	 * 按条件查询客户
	 * @param mp
	 * @return
	 */
	List<CstCustomer> listCstCustomer(Paging<CstCustomer> pg);
	
	/**
	 * 分页之前查询页码条数
	 * @param mp
	 * @return
	 */
	int findCstCustomerCount(Paging pg);
	
	/**
	 * 修改客户
	 * @param mp
	 * @return
	 */
	int updateCstCustomer(Map mp);

	/**
	 * 添加用户
	 * @param mp
	 * @return
	 */
	int insertCstCustomer(Map mp);
	
	
	/**
	 * 根据用户编号查询用户
	 * @param mp
	 * @return
	 */
	CstCustomer selectCstCustomerInfo(String custNo);
	
	/**
	 * 根据用户Id(自动增长)查询用户
	 * @param mp
	 * @return
	 */
	CstCustomer selectIdCstCustomerInfo(Integer custNo);
	
	/**
	 * 根据用户Id(自动增长)查询用户,判断id客户是否存在
	 * @param mp
	 * @return
	 */
	CstCustomer selectCstCustomerByName(String custName);
}

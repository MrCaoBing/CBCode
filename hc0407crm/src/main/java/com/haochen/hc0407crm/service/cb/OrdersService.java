package com.haochen.hc0407crm.service.cb;

import com.haochen.hc0407crm.utils.Paging;

/**
 * 订单的Service接口
 * @author Mr.Cao
 * @date 2018年1月12日 上午10:15:07
 */
public interface OrdersService {
	
	/**
	 * 列出Orders
	 * @param pg
	 * @return
	 */
	Paging listOrders(Paging pg);
	
}

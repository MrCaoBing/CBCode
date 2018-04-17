package com.haochen.hc0407crm.dao.cb;

import java.util.List;

import com.haochen.hc0407crm.entity.Orders;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 订单的Dao接口
 * @author Mr.Cao
 * @date 2018年1月12日 上午9:37:32
 */
public interface OrdersDao {
		
		/**
		 * 分页查询
		 * @param pg
		 * @return
		 */
		List<Orders> selectOrders(Paging pg);
		
		/**
		 * 分页之前查询数据条目
		 * @param pg
		 * @return
		 */
		int selectOrdersCount(Paging pg);
		
}

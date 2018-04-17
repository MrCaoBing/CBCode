package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.OrdersLine;

/**
 * 订单明细的Dao接口
 * @author Mr.Cao
 * @date 2018年1月12日 上午11:45:12
 */
public interface OrdersLineDao {
	
	/**
	 * 查询订单明细
	 * @param mp
	 * @return
	 */
	List<OrdersLine> queryOrdersLine(Map mp);
}

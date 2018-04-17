package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.OrdersLine;

/**
 * 订单明细表Service接口
 * @author Mr.Cao
 * @date 2018年1月12日 下午1:01:15
 */
public interface OrdersLineService {
	
	/**
	 * 列出商品明细
	 * @param map
	 * @return
	 */
	List<OrdersLine> listOrdersLine(Map map);
}

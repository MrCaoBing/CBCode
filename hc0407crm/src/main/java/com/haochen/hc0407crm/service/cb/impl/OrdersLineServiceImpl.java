package com.haochen.hc0407crm.service.cb.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haochen.hc0407crm.dao.cb.OrdersLineDao;
import com.haochen.hc0407crm.entity.OrdersLine;
import com.haochen.hc0407crm.service.cb.OrdersLineService;
@Service("ordersLineServiceImpl")
public class OrdersLineServiceImpl implements OrdersLineService {
	
	@Autowired
	private OrdersLineDao OrdersLineDao;
	
	@Override
	public List<OrdersLine> listOrdersLine(Map mp) {
		return OrdersLineDao.queryOrdersLine(mp);
	}

}

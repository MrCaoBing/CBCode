package com.haochen.hc0407crm.service.cb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.service.cb.OrdersService;
import com.haochen.hc0407crm.dao.cb.OrdersDao;
import com.haochen.hc0407crm.utils.Paging;
@Service("ordersServiceImpl")
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersDao OrdersDao;
	
	@Override
	public Paging listOrders(Paging pg) {
		pg.setCount(OrdersDao.selectOrdersCount(pg));
		pg.setData(OrdersDao.selectOrders(pg));
		return pg;
	}

}

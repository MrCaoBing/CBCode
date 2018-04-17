package com.haochen.hc0407crm.controller.cb;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.entity.Orders;
import com.haochen.hc0407crm.service.cb.OrdersService;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 针对订单的控制器
 * @author Mr.Cao
 * @date 2018年1月12日 上午10:47:09
 */
@Controller
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("listOrders.do")
	public @ResponseBody Map listOrders(Paging<Orders> pg) {
		pg = ordersService.listOrders(pg);
		Map mp = pg.getResultMap();
		return mp;		
	}
}

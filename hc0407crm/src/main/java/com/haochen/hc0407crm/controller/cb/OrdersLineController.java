package com.haochen.hc0407crm.controller.cb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.service.cb.OrdersLineService;

/**
 * ��Զ�����ϸ�Ŀ�����
 * @author Mr.Cao
 * @date 2018��1��12�� ����1:08:22
 */
@Controller
public class OrdersLineController {
	
	@Autowired
	private OrdersLineService ordersLineService;
	
	@RequestMapping("listOrdersLine.do")
	public @ResponseBody List listOrdersLine(@RequestParam Map map) {
		return ordersLineService.listOrdersLine(map);
	}
}

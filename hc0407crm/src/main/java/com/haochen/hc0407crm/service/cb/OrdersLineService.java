package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.OrdersLine;

/**
 * ������ϸ��Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��12�� ����1:01:15
 */
public interface OrdersLineService {
	
	/**
	 * �г���Ʒ��ϸ
	 * @param map
	 * @return
	 */
	List<OrdersLine> listOrdersLine(Map map);
}

package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.OrdersLine;

/**
 * ������ϸ��Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��12�� ����11:45:12
 */
public interface OrdersLineDao {
	
	/**
	 * ��ѯ������ϸ
	 * @param mp
	 * @return
	 */
	List<OrdersLine> queryOrdersLine(Map mp);
}

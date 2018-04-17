package com.haochen.hc0407crm.dao.cb;

import java.util.List;

import com.haochen.hc0407crm.entity.Orders;
import com.haochen.hc0407crm.utils.Paging;

/**
 * ������Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��12�� ����9:37:32
 */
public interface OrdersDao {
		
		/**
		 * ��ҳ��ѯ
		 * @param pg
		 * @return
		 */
		List<Orders> selectOrders(Paging pg);
		
		/**
		 * ��ҳ֮ǰ��ѯ������Ŀ
		 * @param pg
		 * @return
		 */
		int selectOrdersCount(Paging pg);
		
}

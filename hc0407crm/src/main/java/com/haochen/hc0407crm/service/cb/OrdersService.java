package com.haochen.hc0407crm.service.cb;

import com.haochen.hc0407crm.utils.Paging;

/**
 * ������Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��12�� ����10:15:07
 */
public interface OrdersService {
	
	/**
	 * �г�Orders
	 * @param pg
	 * @return
	 */
	Paging listOrders(Paging pg);
	
}

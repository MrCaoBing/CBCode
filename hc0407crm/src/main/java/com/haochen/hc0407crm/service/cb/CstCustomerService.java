package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.utils.Paging;

/**
 * �ͻ���Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��8�� ����8:28:30
 */
public interface CstCustomerService {
	
	/**
	 * �������г��ͻ�
	 * @param pg
	 * @return
	 */
	Paging listCstCustomer(Paging<CstCustomer> pg);
	
	/**
	 * ���ͻ�����õ��ͻ�����
	 * @param mp
	 * @return
	 */
	CstCustomer findCstCustomerById(Map mp);
	
	/**
	 * ��ӿͻ�����
	 * @param mp
	 * @return
	 */
	int addCstCustomer(Map mp);
	
	/**
	 * �޸Ŀͻ�
	 * @param mp
	 * @return
	 */
	int setCstCustomer(Map mp);
	
	/**
	 * �����û���Ų�ѯ�û�
	 * @param mp
	 * @return
	 */
	CstCustomer findCstCustomerInfo(String custNo);
	
	/**
	 * �����û�Id(�Զ�����)��ѯ�û�,�ж�id�ͻ��Ƿ����
	 * @param mp
	 * @return
	 */
	CstCustomer getCstCustomerByName(String custName);
}

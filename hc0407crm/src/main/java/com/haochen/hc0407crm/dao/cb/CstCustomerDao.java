package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.utils.Paging;

/**
 * �ͻ���Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��8�� ����7:51:24
 */
public interface CstCustomerDao {
	/**
	 * ��������ѯ�ͻ�
	 * @param mp
	 * @return
	 */
	List<CstCustomer> listCstCustomer(Paging<CstCustomer> pg);
	
	/**
	 * ��ҳ֮ǰ��ѯҳ������
	 * @param mp
	 * @return
	 */
	int findCstCustomerCount(Paging pg);
	
	/**
	 * �޸Ŀͻ�
	 * @param mp
	 * @return
	 */
	int updateCstCustomer(Map mp);

	/**
	 * ����û�
	 * @param mp
	 * @return
	 */
	int insertCstCustomer(Map mp);
	
	
	/**
	 * �����û���Ų�ѯ�û�
	 * @param mp
	 * @return
	 */
	CstCustomer selectCstCustomerInfo(String custNo);
	
	/**
	 * �����û�Id(�Զ�����)��ѯ�û�
	 * @param mp
	 * @return
	 */
	CstCustomer selectIdCstCustomerInfo(Integer custNo);
	
	/**
	 * �����û�Id(�Զ�����)��ѯ�û�,�ж�id�ͻ��Ƿ����
	 * @param mp
	 * @return
	 */
	CstCustomer selectCstCustomerByName(String custName);
}

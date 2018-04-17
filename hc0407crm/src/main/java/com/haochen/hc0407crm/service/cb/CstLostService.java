package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLost;
import com.haochen.hc0407crm.utils.Paging;

/**
 * �ͻ���ʧ��Ϣ��Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��12�� ����8:00:21
 */
public interface CstLostService {
	
	/**
	 * �г��ͻ���ʧ��Ϣ
	 * @param pg
	 * @return
	 */
	Paging listCstLost(Paging pg);
	
	/**
	 * �޸Ŀͻ���ʧ��Ϣ
	 * @param mp
	 * @return
	 * @throws Exception 
	 */
	int setCstLost(Map mp) throws Exception;
	
	/**
	 * �޸Ŀͻ���ʧ��Ϣ
	 * @param mp
	 * @return
	 */
	int addCstLost(Map mp);
}

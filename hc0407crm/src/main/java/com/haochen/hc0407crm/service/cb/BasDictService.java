package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.BasDict;
import com.haochen.hc0407crm.utils.Paging;

/**
 * �����ֵ��Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��8�� ����3:11:13
 */
public interface BasDictService {
	
	/**
	 * ���س���Ļ�������
	 * @return
	 */
	Map loadFoundationData();
	
	/**
	 * ��������ѯ�ͻ�
	 * @param pg
	 * @return
	 */
	Paging listBasDictTiaojian(Paging<BasDict> pg);
	
	/**
	 * ����
	 * @param mp
	 * @return
	 */
	int addBasDict(Map mp);
	
	/**
	 * ɾ��
	 * @param mp
	 * @return
	 */
	int delBasDict(Map mp);
	
	/**
	 * �޸�
	 * @param mp
	 * @return
	 */
	int setBasDict(Map mp);
	
	int findDictItem(String dictItem1);
}

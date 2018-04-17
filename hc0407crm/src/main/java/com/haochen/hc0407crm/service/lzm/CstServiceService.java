package com.haochen.hc0407crm.service.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstService;
import com.haochen.hc0407crm.utils.Paging;

public interface CstServiceService {

	/**
	 * ��ѯ�����ѷ���Ŀͻ�������Ϣ
	 * 
	 * @param map
	 * @return
	 */
	List<CstService> findCstServiceInfo(Map<String, Object> map);

	/**
	 * ����(�޸�)�ͻ�������Ϣ
	 * 
	 * @param map
	 * @return
	 */
	Integer setCstServiceInfo(Map<String, Object> map);

	/**
	 * ��ѯ�����ѷ���Ŀͻ�����������,�ɸ�������ģ����ѯ
	 * 
	 * @param map
	 * @return
	 */
	Integer findCstServiceInfoCount(Map<String, Object> map);

	/**
	 * �Է���Ĵ�����������
	 * 
	 * @param map
	 * @return
	 */
	int addCstService(Map map);

	/**
	 * ��ѯ�����´����Ŀͻ�����ҳ���ɲ�ѯ
	 * 
	 * @param pg
	 * @return
	 */
	Paging findCstServiceTiaojian(Paging<CstService> pg);

	/**
	 * ɾ������������´����ķ���
	 * 
	 * @param map
	 * @return
	 */
	int delCstService(Map map);
	
	/**
	 * ָ�������ˣ��޸ģ�
	 * @param map
	 * @return
	 */
	int setCstService(Map map);
}

package com.haochen.hc0407crm.dao.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstService;
import com.haochen.hc0407crm.utils.Paging;

public interface CstServiceDao {
	
	/**
	 * ��ѯ�����ѷ���Ŀͻ�������Ϣ,�ɸ�������ģ����ѯ����ҳ
	 * @param map
	 * @return
	 */
	List<CstService> selectCstServiceInfo(Map<String,Object> map);
	
	/**
	 * ����(�޸�)�ͻ�������Ϣ
	 * @param map
	 * @return
	 */
	Integer updateCstServiceInfo(Map<String,Object> map);
	
	/**
	 * ��ѯ�����ѷ���Ŀͻ�����������,�ɸ�������ģ����ѯ
	 * @param map
	 * @return
	 */
	Integer selectCstServiceInfoCount(Map<String,Object> map);
	
	/**
	 * �Է���Ĵ�����������
	 * @param map
	 * @return
	 */
	int insertCstService(Map map);
	/**
	 * ��ѯ�����´����Ŀͻ�����ҳ���ɲ�ѯ
	 * @param pg
	 * @return
	 */
	List<CstService> listCstServiceTiaojian(Paging<CstService> pg);
	/**
	 * �����´����ͻ���������
	 * @param pg
	 * @return
	 */
	int findCstServiceCount(Paging pg);
	/**
	 * ɾ������������´����ķ���
	 * @param map
	 * @return
	 */
	int deleteCstService(Map map);
	/**
	 * Ϊ�´����ķ�����Ϣָ��������
	 * @param map
	 * @return
	 */
	int updateCstService(Map map);
}

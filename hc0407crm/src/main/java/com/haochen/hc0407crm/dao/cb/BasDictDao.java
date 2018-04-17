package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.BasDict;
import com.haochen.hc0407crm.utils.Paging;

/**
 * �����ֵ��Dao�ӿ�
 * 
 * @author Mr.Cao
 * @date 2018��1��8�� ����3:01:32
 */
public interface BasDictDao {
	/**
	 * �������г�BasDict
	 * 
	 * @param map
	 * @return
	 */
	List<BasDict> listBasDict(Map map);

	/**
	 * ��������ѯ�ͻ�
	 * 
	 * @param mp
	 * @return
	 */
	List<BasDict> listBasDictTiaojian(Paging<BasDict> pg);
	
	/**
	 * ��ҳ֮ǰ��ѯҳ������
	 * @param mp
	 * @return
	 */
	int findBasDictCount(Paging pg);
	
	/**
	 * ����
	 * @param mp
	 * @return
	 */
	int insertBasDict(Map mp);
	
	/**
	 * ɾ��
	 * @param mp
	 * @return
	 */
	int deleteBasDict(Map mp);
	
	/**
	 * �޸�
	 * @param mp
	 * @return
	 */
	int updateBasDict(Map mp);
	
	int findDictItem(String dictItem);
}

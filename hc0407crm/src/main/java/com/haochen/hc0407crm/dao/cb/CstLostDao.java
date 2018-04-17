package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLost;
import com.haochen.hc0407crm.utils.Paging;

/**
 * �ͻ���ʧ��Dao
 * @author Mr.Cao
 * @date 2018��1��12�� ����7:21:00
 */
public interface CstLostDao {
	
	/**
	 * ��ѯ�ͻ���ʧ��Ϣ
	 * @param pg
	 * @return
	 */
	List<CstLost> queryCstLost(Paging pg);
	
	/**
	 * ��ѯ�ͻ���ʧ��Ϣ������Ŀ
	 * @param pg
	 * @return
	 */
	int queryCstLostCount(Paging pg);
	
	/**
	 * �޸Ŀͻ���ʧ��Ϣ
	 * @param pg
	 * @return
	 */
	int updateCstLost(Map mp);
	
	/**
	 * ����ͻ���ʧ��Ϣ
	 * @param map
	 * @return
	 */
	int insertCstLost(Map mp);
	
	
}
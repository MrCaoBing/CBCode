package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstActivity;

/**
 * �ͻ�������¼Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��11�� ����3:15:50
 */
public interface CstActivityDao {
	
	/**
	 * �������г��ͻ�������¼
	 * @param pg
	 * @return
	 */
	List<CstActivity> listCstActivity(Map mp);
	
	/**
	 * �������޸Ŀͻ�������¼
	 * @param mp
	 * @return
	 */
	int updateCstActivity(Map mp);
	
	/**
	 * ��ӿͻ�������¼
	 * @param mp
	 * @return
	 */
	int insertCstActivity(Map mp);
	
	/**
	 * ��idɾ���ͻ�������¼
	 * @param id
	 * @return
	 */
	int deleteCstActivity(Map mp);
}

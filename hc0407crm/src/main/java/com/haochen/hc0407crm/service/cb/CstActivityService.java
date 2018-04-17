package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstActivity;

/**
 * �ͻ�������¼service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��11�� ����3:15:50
 */
public interface CstActivityService{
	
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
	int setCstActivity(Map mp);
	
	/**
	 * ��ӿͻ�������¼
	 * @param mp
	 * @return
	 */
	int addCstActivity(Map mp);
	
	/**
	 * ��idɾ���ͻ�������¼
	 * @param id
	 * @return
	 */
	int delCstActivity(Map mp);
}

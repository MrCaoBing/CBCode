package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLinkman;

/**
 * �ͻ���ϵ�˵�service��ӿ�
 * @author Mr.Cao
 * @date 2018��1��10�� ����7:05:38
 */
public interface CstLinkmanService {
	
	/**
	 * �������г��ͻ���ϵ��
	 * @param pg
	 * @return
	 */
	List<CstLinkman> listCstLinkman(Map mp);
	
	/**
	 * �������޸Ŀͻ���ϵ��
	 * @param mp
	 * @return
	 */
	int setCstLinkman(Map mp);
	
	/**
	 * ��ӿͻ���ϵ��
	 * @param mp
	 * @return
	 */
	int addCstLinkman(Map mp);
	
	/**
	 * ��idɾ���ͻ���ϵ��
	 * @param id
	 * @return
	 */
	int delCstLinkman(Map mp);
}

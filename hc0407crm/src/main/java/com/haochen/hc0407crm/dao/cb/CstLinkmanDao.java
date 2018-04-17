package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLinkman;
import com.haochen.hc0407crm.utils.Paging;

/**
 * �ͻ���ϵ�����ݷ��ʲ�ӿ�
 * @author Mr.Cao
 * @date 2018��1��10�� ����6:28:15
 */
public interface CstLinkmanDao {
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
	int updateCstLinkman(Map mp);
	
	/**
	 * ��ӿͻ���ϵ��
	 * @param mp
	 * @return
	 */
	int insertCstLinkman(Map mp);
	
	/**
	 * ��idɾ���ͻ���ϵ��
	 * @param id
	 * @return
	 */
	int deleteCstLinkman(Map mp);
}

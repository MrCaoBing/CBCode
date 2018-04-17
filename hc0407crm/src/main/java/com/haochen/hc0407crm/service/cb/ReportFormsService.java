package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.utils.Paging;

/**
 * �����Service�ӿ�
 * @author Mr.Cao
 * @date 2018��1��14�� ����4:24:01
 */
public interface ReportFormsService {
	
	/**
	 * �г��ͻ�����
	 * @param pg
	 * @return
	 */
	Paging listCustAccounted(Paging pg);
	
	/**
	 * �г��ͻ�����
	 * @param pg
	 * @return
	 */
	Paging listCustConstitute(Paging pg);
	
	/**
	 * �г����񹹳�
	 * @param pg
	 * @return
	 */
	Paging listCustService(Paging pg);
	
	/**
	 * �г��ͻ���ʧ
	 * @param pg
	 * @return
	 */
	List<Map<String, Object>> listCustLost();
}

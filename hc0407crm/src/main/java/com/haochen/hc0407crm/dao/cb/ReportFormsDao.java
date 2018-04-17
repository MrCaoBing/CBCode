package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.utils.Paging;

/**
 * ͳ�Ʊ����Dao�ӿ�
 * @author Mr.Cao
 * @date 2018��1��14�� ����4:13:38
 */
public interface ReportFormsDao {
	
	/**
	 * ��ѯ�ͻ�����
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String,String>> queryCustAccounted(Paging pg);
	
	/**
	 * ��ѯ�ͻ�����������Ŀ
	 * @param pg
	 * @return
	 */
	int queryCustAccountedCount(Paging pg);
	
	/**
	 * ��ѯ�ͻ�����
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String,String>> queryCustConstitute(Paging pg);
	
	/**
	 * ��ѯ�ͻ�����������Ŀ
	 * @param pg
	 * @return
	 */
	int queryCustConstituteCount(Paging pg);
	
	/**
	 * ��ѯ���񹹳�
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String,String>> queryCustService(Paging pg);
	
	/**
	 * ��ѯ����������Ŀ
	 * @param pg
	 * @return
	 */
	int queryCustServiceCount(Paging pg);

	/**
	 * ��ѯ�ͻ���ʧ
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String, Object>> queryCustLost();
	
}

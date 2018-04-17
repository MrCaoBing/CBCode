package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.utils.Paging;

/**
 * 统计报表的Dao接口
 * @author Mr.Cao
 * @date 2018年1月14日 下午4:13:38
 */
public interface ReportFormsDao {
	
	/**
	 * 查询客户贡献
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String,String>> queryCustAccounted(Paging pg);
	
	/**
	 * 查询客户贡献数据条目
	 * @param pg
	 * @return
	 */
	int queryCustAccountedCount(Paging pg);
	
	/**
	 * 查询客户构成
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String,String>> queryCustConstitute(Paging pg);
	
	/**
	 * 查询客户构成数据条目
	 * @param pg
	 * @return
	 */
	int queryCustConstituteCount(Paging pg);
	
	/**
	 * 查询服务构成
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String,String>> queryCustService(Paging pg);
	
	/**
	 * 查询服务数据条目
	 * @param pg
	 * @return
	 */
	int queryCustServiceCount(Paging pg);

	/**
	 * 查询客户流失
	 * @param pg
	 * @return
	 * List<Map<String,String>> queryCustAccounted(Paging pg);
	 */	
	List<Map<String, Object>> queryCustLost();
	
}

package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.utils.Paging;

/**
 * 报表的Service接口
 * @author Mr.Cao
 * @date 2018年1月14日 下午4:24:01
 */
public interface ReportFormsService {
	
	/**
	 * 列出客户贡献
	 * @param pg
	 * @return
	 */
	Paging listCustAccounted(Paging pg);
	
	/**
	 * 列出客户构成
	 * @param pg
	 * @return
	 */
	Paging listCustConstitute(Paging pg);
	
	/**
	 * 列出服务构成
	 * @param pg
	 * @return
	 */
	Paging listCustService(Paging pg);
	
	/**
	 * 列出客户流失
	 * @param pg
	 * @return
	 */
	List<Map<String, Object>> listCustLost();
}

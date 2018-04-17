package com.haochen.hc0407crm.dao.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLinkman;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 客户联系人数据访问层接口
 * @author Mr.Cao
 * @date 2018年1月10日 下午6:28:15
 */
public interface CstLinkmanDao {
	/**
	 * 按条件列出客户联系人
	 * @param pg
	 * @return
	 */
	List<CstLinkman> listCstLinkman(Map mp);
	
	/**
	 * 按条件修改客户联系人
	 * @param mp
	 * @return
	 */
	int updateCstLinkman(Map mp);
	
	/**
	 * 添加客户联系人
	 * @param mp
	 * @return
	 */
	int insertCstLinkman(Map mp);
	
	/**
	 * 按id删除客户联系人
	 * @param id
	 * @return
	 */
	int deleteCstLinkman(Map mp);
}

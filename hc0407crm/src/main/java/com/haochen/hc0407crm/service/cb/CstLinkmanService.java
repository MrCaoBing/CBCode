package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstLinkman;

/**
 * 客户联系人的service层接口
 * @author Mr.Cao
 * @date 2018年1月10日 下午7:05:38
 */
public interface CstLinkmanService {
	
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
	int setCstLinkman(Map mp);
	
	/**
	 * 添加客户联系人
	 * @param mp
	 * @return
	 */
	int addCstLinkman(Map mp);
	
	/**
	 * 按id删除客户联系人
	 * @param id
	 * @return
	 */
	int delCstLinkman(Map mp);
}

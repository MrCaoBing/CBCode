package com.haochen.hc0407crm.service.cb;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.CstActivity;

/**
 * 客户交往记录service接口
 * @author Mr.Cao
 * @date 2018年1月11日 下午3:15:50
 */
public interface CstActivityService{
	
	/**
	 * 按条件列出客户交往记录
	 * @param pg
	 * @return
	 */
	List<CstActivity> listCstActivity(Map mp);
	
	/**
	 * 按条件修改客户交往记录
	 * @param mp
	 * @return
	 */
	int setCstActivity(Map mp);
	
	/**
	 * 添加客户交往记录
	 * @param mp
	 * @return
	 */
	int addCstActivity(Map mp);
	
	/**
	 * 按id删除客户交往记录
	 * @param id
	 * @return
	 */
	int delCstActivity(Map mp);
}

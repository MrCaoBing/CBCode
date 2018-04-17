package com.haochen.hc0407crm.service.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SalPlan;

public interface SalPlanService {
	/**
	 * 查询所有指定销售机会的开发计划
	 * @return
	 */
	List<SalPlan> findSalPlanInfo(Integer chcId);
	
	/**
	 * 添加开发计划
	 * @param salPlan
	 * @return
	 */
	Integer addSalPlanInfo(SalPlan salPlan);
	
	/**
	 * 修改开发计划
	 * @param map
	 * @return
	 */
	Integer setSalPlanInfo(Map<String,Object> map);
	
	/**
	 * 删除开发计划
	 * @param plaId
	 * @return
	 */
	Integer delSalPlanInfo(Integer plaId);
}

package com.haochen.hc0407crm.service.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SalPlan;

public interface SalPlanService {
	/**
	 * ��ѯ����ָ�����ۻ���Ŀ����ƻ�
	 * @return
	 */
	List<SalPlan> findSalPlanInfo(Integer chcId);
	
	/**
	 * ��ӿ����ƻ�
	 * @param salPlan
	 * @return
	 */
	Integer addSalPlanInfo(SalPlan salPlan);
	
	/**
	 * �޸Ŀ����ƻ�
	 * @param map
	 * @return
	 */
	Integer setSalPlanInfo(Map<String,Object> map);
	
	/**
	 * ɾ�������ƻ�
	 * @param plaId
	 * @return
	 */
	Integer delSalPlanInfo(Integer plaId);
}

package com.haochen.hc0407crm.dao.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SalPlan;

public interface SalPlanDao {
	/**
	 * ��ѯ����ָ�����ۻ���Ŀ����ƻ�
	 * @return
	 */
	List<SalPlan> selectSalPlanInfo(Integer chcId);
	
	/**
	 * ��ӿ����ƻ�
	 * @param salPlan
	 * @return
	 */
	Integer insertSalPlanInfo(SalPlan salPlan);
	
	/**
	 * �޸Ŀ����ƻ�
	 * @param map
	 * @return
	 */
	Integer updateSalPlanInfo(Map<String,Object> map);
	
	
	/**
	 * ɾ�������ƻ�
	 * @param plaId
	 * @return
	 */
	Integer deleteSalPlanInfo(Integer plaId);
}

package com.haochen.hc0407crm.service.lzm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.lzm.SalPlanDao;
import com.haochen.hc0407crm.entity.SalPlan;
import com.haochen.hc0407crm.service.lzm.SalPlanService;

@Service
public class SalPlanServiceImpl implements SalPlanService{

	
	private SalPlanDao salPlanDao;
	
	
	@Autowired
	public void setSalPlanDao(SalPlanDao salPlanDao) {
		this.salPlanDao = salPlanDao;
	}

	@Override
	public List<SalPlan> findSalPlanInfo(Integer chcId) {
	
		return salPlanDao.selectSalPlanInfo(chcId);
	}

	@Override
	public Integer addSalPlanInfo(SalPlan salPlan) {
	
		return salPlanDao.insertSalPlanInfo(salPlan);
	}

	@Override
	public Integer setSalPlanInfo(Map<String, Object> map) {
	
		return salPlanDao.updateSalPlanInfo(map);
	}

	@Override
	public Integer delSalPlanInfo(Integer plaId) {
		// TODO Auto-generated method stub
		return salPlanDao.deleteSalPlanInfo(plaId);
	}

}

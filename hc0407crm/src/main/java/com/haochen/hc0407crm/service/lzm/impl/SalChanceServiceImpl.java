package com.haochen.hc0407crm.service.lzm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.lzm.SalChanceDao;
import com.haochen.hc0407crm.entity.SalChance;
import com.haochen.hc0407crm.service.lzm.SalChanceService;

@Service
public class SalChanceServiceImpl implements SalChanceService{

	private SalChanceDao salChanceDao;
	
	
	@Autowired
	public void setSalChanceDao(SalChanceDao salChanceDao) {
		this.salChanceDao = salChanceDao;
	}



	public List<SalChance> findAllSalChanceInfo(Map<String, Object> map) {
		
		return salChanceDao.selectAllSalChanceInfo(map);
	}



	@Override
	public int selectSalChanceCountRecordInfo(Map<String,Object> map) {
	
		return salChanceDao.selectSalChanceCountRecordInfo(map);
	}



	@Override
	public int addSalChanceInfo(SalChance salChance) {
	
		return salChanceDao.insertSalChanceInfo(salChance);
	}



	@Override
	public int delSalChanceInfo(Integer chcId) {
		
		return salChanceDao.deleteSalChanceInfo(chcId);
	}



	@Override
	public int setSalChanceInfo(Map<String,Object> map) {
		
		return salChanceDao.updateSalChanceInfo(map);
	}



	@Override
	public SalChance findAppointSalChanceInfo(Integer id) {
	
		return salChanceDao.selectAppointSalChanceInfo(id);
	}



	@Override
	public SalChance findCheckchcCustName(String name) {
		// TODO Auto-generated method stub
		return salChanceDao.selectCheckchcCustName(name);
	}

}

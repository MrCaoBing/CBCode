package com.haochen.hc0407crm.service.cb.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.cb.CstActivityDao;
import com.haochen.hc0407crm.entity.CstActivity;
import com.haochen.hc0407crm.service.cb.CstActivityService;
@Service("cstActivityServiceImpl")
public class CstActivityServiceImpl implements CstActivityService {

	@Autowired
	private CstActivityDao cstActivityDao;
	
	@Override
	public List<CstActivity> listCstActivity(Map mp) {
		return cstActivityDao.listCstActivity(mp);
	}

	@Override
	public int setCstActivity(Map mp) {
		try{
			return cstActivityDao.updateCstActivity(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public int addCstActivity(Map mp) {
		try{
			return cstActivityDao.insertCstActivity(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public int delCstActivity(Map mp) {
		try{
			return cstActivityDao.deleteCstActivity(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}
	
}



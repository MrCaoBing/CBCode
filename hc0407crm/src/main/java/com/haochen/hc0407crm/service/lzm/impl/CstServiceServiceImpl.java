package com.haochen.hc0407crm.service.lzm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.lzm.CstServiceDao;
import com.haochen.hc0407crm.entity.CstService;
import com.haochen.hc0407crm.service.lzm.CstServiceService;
import com.haochen.hc0407crm.utils.Paging;

@Service
public class CstServiceServiceImpl implements CstServiceService{

	
	@Autowired
	private CstServiceDao cstServiceDao;
	
	
	@Override
	public List<CstService> findCstServiceInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cstServiceDao.selectCstServiceInfo(map);
	}

	@Override
	public Integer setCstServiceInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cstServiceDao.updateCstServiceInfo(map);
	}

	@Override
	public Integer findCstServiceInfoCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cstServiceDao.selectCstServiceInfoCount(map);
	}

	@Override
	public int addCstService(Map map) {
		try {
			return cstServiceDao.insertCstService(map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Paging findCstServiceTiaojian(Paging<CstService> pg) {
		pg.setCount(cstServiceDao.findCstServiceCount(pg));
		pg.setData(cstServiceDao.listCstServiceTiaojian(pg));
		return pg;
	}

	@Override
	public int delCstService(Map map) {
		try {
			return cstServiceDao.deleteCstService(map);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int setCstService(Map map) {
		try{
			return cstServiceDao.updateCstService(map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}

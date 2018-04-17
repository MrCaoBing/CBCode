package com.haochen.hc0407crm.service.cb.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.cb.CstLinkmanDao;
import com.haochen.hc0407crm.entity.CstLinkman;
import com.haochen.hc0407crm.service.cb.CstLinkmanService;
@Service("cstLinkmanServiceImpl")
public class CstLinkmanServiceImpl implements CstLinkmanService{
	
	@Autowired
	private CstLinkmanDao cstLinkmanDao;
	
	@Override
	public List<CstLinkman> listCstLinkman(Map mp) {
		return cstLinkmanDao.listCstLinkman(mp);
	}

	@Override
	public int setCstLinkman(Map mp) {
		try {
			return cstLinkmanDao.updateCstLinkman(mp);
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int addCstLinkman(Map mp) {
		try {
			return cstLinkmanDao.insertCstLinkman(mp);
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int delCstLinkman(Map mp) {
		try {
			return cstLinkmanDao.deleteCstLinkman(mp);
		} catch (Exception e) {
			return 0;
		}		
	}

}

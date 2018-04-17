package com.haochen.hc0407crm.service.cb.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haochen.hc0407crm.dao.cb.CstCustomerDao;
import com.haochen.hc0407crm.dao.cb.CstLostDao;
import com.haochen.hc0407crm.service.cb.CstLostService;
import com.haochen.hc0407crm.utils.Paging;
@Service("cstLostServiceImpl")
@Transactional  
public class CstLostServiceImpl implements CstLostService {
	
	@Autowired
	private CstLostDao cstLostDao;
	@Autowired
	private CstCustomerDao cstCustomerDao;
	
	
	@Override
	public Paging listCstLost(Paging pg) {	
		pg.setCount(cstLostDao.queryCstLostCount(pg));
		pg.setData(cstLostDao.queryCstLost(pg));
		return pg;
	}

	@Override
	public int setCstLost(Map mp) throws Exception{

		        //为流失客户需更改客户信息
				if ("3".equals(mp.get("lstStatus"))) {
					cstCustomerDao.updateCstCustomer(mp);					
				}
				cstLostDao.updateCstLost(mp);
				return 1;
	}

	@Override
	public int addCstLost(Map mp) {
		try {
			return cstLostDao.insertCstLost(mp);
		} catch(Exception e) {
			return 0;
		}
	}

}

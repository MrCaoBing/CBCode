package com.haochen.hc0407crm.service.cb.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.cb.CstCustomerDao;
import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.service.cb.CstCustomerService;
import com.haochen.hc0407crm.utils.Paging;
@Service("cstCustomerServiceImpl")
public class CstCustomerServiceImpl implements CstCustomerService {
	
	@Autowired
	private CstCustomerDao cstCustomerDao;

	@Override
	public Paging listCstCustomer(Paging<CstCustomer> pg) {
		pg.setCount(cstCustomerDao.findCstCustomerCount(pg));		
		pg.setData(cstCustomerDao.listCstCustomer(pg));
		return pg;
	}

	@Override
	public CstCustomer findCstCustomerById(Map mp) {
		//为了复用数据访问层，所以先把条件封装进paging类的map
		Paging<CstCustomer> pg = new Paging<CstCustomer>();
		pg.setMap(mp);
		//因为返回集合，所以第一个就是客户对象
		return cstCustomerDao.listCstCustomer(pg).get(0);
	}

	@Override
	public int addCstCustomer(Map mp) {
		
		try{
			return cstCustomerDao.insertCstCustomer(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
		
	}

	@Override
	public int setCstCustomer(Map mp) {		
		try{
			return cstCustomerDao.updateCstCustomer(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}		
		
	}

	@Override
	public CstCustomer findCstCustomerInfo(String custNo) {
		return cstCustomerDao.selectCstCustomerInfo(custNo);
	}

	@Override
	public CstCustomer getCstCustomerByName(String custName) {
		return cstCustomerDao.selectCstCustomerByName(custName);
	}
	
}

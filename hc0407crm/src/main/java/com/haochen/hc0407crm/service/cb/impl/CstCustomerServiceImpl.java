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
		//Ϊ�˸������ݷ��ʲ㣬�����Ȱ�������װ��paging���map
		Paging<CstCustomer> pg = new Paging<CstCustomer>();
		pg.setMap(mp);
		//��Ϊ���ؼ��ϣ����Ե�һ�����ǿͻ�����
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

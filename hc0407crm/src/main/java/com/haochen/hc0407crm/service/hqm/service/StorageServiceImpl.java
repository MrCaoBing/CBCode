package com.haochen.hc0407crm.service.hqm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.hqm.StorageDao;
import com.haochen.hc0407crm.entity.Storage;
import com.haochen.hc0407crm.service.hqm.StorageService;
import com.haochen.hc0407crm.utils.Paging;

@Service("StorageServiceImpl")
public class StorageServiceImpl implements StorageService {
	@Autowired
	private StorageDao storageDao;
	
	@Override
	public Paging listStorageTiaojian(Paging<Storage> pg) {
		pg.setCount(storageDao.findStorageCount(pg));		
		pg.setData(storageDao.listStorageTiaojian(pg));
		return pg;
	}

}

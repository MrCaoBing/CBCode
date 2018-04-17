package com.haochen.hc0407crm.dao.hqm;

import java.util.List;

import com.haochen.hc0407crm.entity.Storage;
import com.haochen.hc0407crm.utils.Paging;

public interface StorageDao {
	List<Storage> listStorageTiaojian(Paging<Storage> pg);
	
	int findStorageCount(Paging pg);
	
	
}

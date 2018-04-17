package com.haochen.hc0407crm.service.hqm;

import com.haochen.hc0407crm.entity.Storage;
import com.haochen.hc0407crm.utils.Paging;

public interface StorageService {
	Paging listStorageTiaojian(Paging<Storage> pg);
}

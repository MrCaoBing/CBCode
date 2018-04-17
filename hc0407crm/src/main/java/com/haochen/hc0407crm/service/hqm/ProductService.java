package com.haochen.hc0407crm.service.hqm;

import com.haochen.hc0407crm.entity.Product;
import com.haochen.hc0407crm.utils.Paging;

public interface ProductService {
	Paging listProductTiaojian(Paging<Product> pg);
}

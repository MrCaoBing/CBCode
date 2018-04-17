package com.haochen.hc0407crm.dao.hqm;

import java.util.List;

import com.haochen.hc0407crm.entity.Product;
import com.haochen.hc0407crm.utils.Paging;

public interface ProductDao {

	List<Product> listProductTiaojian(Paging<Product> pg);

	int findProductCount(Paging pg);
}

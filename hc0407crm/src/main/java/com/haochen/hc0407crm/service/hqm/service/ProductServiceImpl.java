package com.haochen.hc0407crm.service.hqm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.hqm.ProductDao;
import com.haochen.hc0407crm.entity.Product;
import com.haochen.hc0407crm.service.hqm.ProductService;
import com.haochen.hc0407crm.utils.Paging;
@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Paging listProductTiaojian(Paging<Product> pg) {
		pg.setCount(productDao.findProductCount(pg));		
		pg.setData(productDao.listProductTiaojian(pg));
		return pg;
	}

}

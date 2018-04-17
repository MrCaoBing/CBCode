package com.haochen.hc0407crm.controller.hqm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.Product;
import com.haochen.hc0407crm.service.hqm.ProductService;
import com.haochen.hc0407crm.utils.Paging;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("listProductTiaojian.do")
	public @ResponseBody Map listProductTiaojian(Paging<Product> pg) {
		System.out.println(pg);
		return productService.listProductTiaojian(pg).getResultMap();
	}
}

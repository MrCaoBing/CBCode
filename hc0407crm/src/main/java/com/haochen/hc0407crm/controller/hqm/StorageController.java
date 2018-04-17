package com.haochen.hc0407crm.controller.hqm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.Storage;
import com.haochen.hc0407crm.service.hqm.StorageService;
import com.haochen.hc0407crm.utils.Paging;

@Controller
public class StorageController {
	@Autowired
	private StorageService storageService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("listStorageTiaojian.do")
	public @ResponseBody Map listProductTiaojian(Paging<Storage> pg) {
		System.out.println(pg);
		return storageService.listStorageTiaojian(pg).getResultMap();
	}
}

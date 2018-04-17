package com.haochen.hc0407crm.controller.cb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.service.cb.CstActivityService;

@Controller
public class CstActivityController {

	
	@Autowired
	private CstActivityService CstActivityServiceImpl;
	
	
	/**
	 * 数据表格
	 */
	@RequestMapping("listCstActivity.do")
	@ResponseBody
	public  Map listCstActivity(@RequestParam Map mp) {
		List lis = CstActivityServiceImpl.listCstActivity(mp);
		System.out.println(lis);
		System.out.println(mp);		
		mp.put("msg", "");
		mp.put("code", 0);	
		mp.put("count", lis.size());
		mp.put("data", lis);	
		return mp;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("setCstActivity.do")
	@ResponseBody
	public  int setCstActivity(@RequestParam Map mp) {
		return CstActivityServiceImpl.setCstActivity(mp);
	}
	
	@RequestMapping("delCstActivity.do")
	@ResponseBody
	public  int delCstActivity(@RequestParam Map mp) {
		return CstActivityServiceImpl.delCstActivity(mp);
	}
	
	@RequestMapping("addCstActivity.do")
	@ResponseBody
	public  int addCstActivity(@RequestParam Map mp) {
		return CstActivityServiceImpl.addCstActivity(mp);
	}
}

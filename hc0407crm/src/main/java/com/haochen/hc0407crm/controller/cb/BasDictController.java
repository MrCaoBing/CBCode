package com.haochen.hc0407crm.controller.cb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.BasDict;
import com.haochen.hc0407crm.service.cb.BasDictService;
import com.haochen.hc0407crm.utils.Paging;

@Controller
public class BasDictController {
	
	@Autowired
	private BasDictService basDictService;
	
	@RequestMapping("loadFoundationData.jsp")
	public String loadFoundationData(HttpServletRequest request) {
		//加载基础数据,存到Application作用域中		
		return "jsp/cb/index";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("listBasDictTiaojian.do")
	public @ResponseBody Map listBasDictTiaojian(Paging<BasDict> pg) {
		System.out.println(pg);
		return basDictService.listBasDictTiaojian(pg).getResultMap();
	}
	
	@RequestMapping("addBasDict.do")
	public @ResponseBody int addBasDict(@RequestParam Map<String,Object> mp) {
		//因为Map接收没有默认值,数据库会报错
		for (String s : mp.keySet()) {
			if ("".equals(mp.get(s))) {
				mp.put(s, "0");
			}
		}
		System.out.println(mp);
		int result = basDictService.addBasDict(mp);
		System.out.println(result);
		return result;	
	}
	
	@RequestMapping("delBasDict.do")
	public @ResponseBody int delBasDict(@RequestParam Map map,Integer id) {	
		map.put("dictId",id);
		return basDictService.delBasDict(map);
	}
	
	@RequestMapping("setBasDict.do")
	@ResponseBody
	public  int setBasDict(@RequestParam Map mp) {
		return basDictService.setBasDict(mp);
	}
	
	@RequestMapping("findDictItem.do")
	public @ResponseBody int findDictItem(String dictItem1, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return basDictService.findDictItem(dictItem1);
	}
	
}
package com.haochen.hc0407crm.controller.lzm;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.CstService;
import com.haochen.hc0407crm.service.lzm.CstServiceService;
import com.haochen.hc0407crm.utils.Paging;

@Controller
public class CstServiceController {

	@Autowired
	private CstServiceService cstServiceService;

	@RequestMapping("/findCstServiceInfo")
	public @ResponseBody Map<String, Object> findCstServiceInfo(@RequestParam Map<String, Object> map,
			HttpServletResponse response) {
		if ("".equals(map.get("svrCreateDate")) && map.get("svrCreateDate") == "") {
			map.put("svrCreateDate", null);

		}
		if ("".equals(map.get("svrCreateDate1")) && map.get("svrCreateDate1") == "") {
			map.put("svrCreateDate1", null);
		}
		map.put("page",
				(Integer.valueOf(map.get("page").toString()) - 1) * Integer.valueOf(map.get("limit").toString()));
		map.put("limit", Integer.valueOf(map.get("limit").toString()));
		List<CstService> list = cstServiceService.findCstServiceInfo(map);
		Integer count = cstServiceService.findCstServiceInfoCount(map);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("code", "");
		map1.put("msg", "");
		map1.put("count", count);
		map1.put("data", list);
		return map1;
	}

	@RequestMapping("/setCstServiceInfo")
	public void setCstServiceInfo(@RequestParam Map<String, Object> map, HttpServletResponse response)
			throws IOException {
		map.put("svrDealDate", new Date());
		if (map.get("select").equals("0")) {
			map.put("svrStatus", 3);
		} else if (map.get("select").equals("1")) {
			if (Integer.valueOf(map.get("svrSatisfy").toString()) >= 3) {
				map.put("svrStatus", 4);
			} else {
				map.put("svrStatus", 1);
			}
		}
		Integer result = cstServiceService.setCstServiceInfo(map);
		response.getWriter().print(result);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("addCstService.do")
	public @ResponseBody int addCstService(@RequestParam Map<String, Object> mp) {
		// 因为Map接收没有默认值,数据库会报错
		for (String s : mp.keySet()) {
			if ("".equals(mp.get(s))) {
				mp.put(s, "0");
			}
		}
		System.out.println(mp);
		int result = cstServiceService.addCstService(mp);
		System.out.println(result);
		return result;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("findCstServiceTiaojian.do")
	public @ResponseBody Map findCstServiceTiaojian(Paging<CstService> pg) {
		System.out.println(pg);
		return cstServiceService.findCstServiceTiaojian(pg).getResultMap();
	}

	@RequestMapping("delCstService.do")
	public @ResponseBody int delCstService(@RequestParam Map map, Integer id) {
		map.put("svrId", id);
		return cstServiceService.delCstService(map);
	}

	@RequestMapping("setCstService.do")
	@ResponseBody
	public int setCstService(@RequestParam Map map) {
		return cstServiceService.setCstService(map);
	}
}

package com.haochen.hc0407crm.controller.lzm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.entity.CstLinkman;
import com.haochen.hc0407crm.entity.SalChance;
import com.haochen.hc0407crm.service.cb.CstCustomerService;
import com.haochen.hc0407crm.service.cb.CstLinkmanService;
import com.haochen.hc0407crm.service.lzm.SalChanceService;
import com.haochen.hc0407crm.utils.Paging;

@Controller
public class ChanceController {

	@Autowired
	private SalChanceService salChanceService;

	@Autowired
	private CstCustomerService cstCustomerService;

	@Autowired
	private CstLinkmanService cstLinkmanService;

	/*
	 * 查询所有销售机会并分页的controller方法
	 */
	@RequestMapping("/findAllSalChanceInfo")
	public @ResponseBody Map findAllSalChanceInfo(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		Integer currPage = Integer.valueOf(map.get("page").toString());
		currPage = (currPage - 1) * Integer.valueOf(map.get("limit").toString());
		map.put("page", currPage);
		map.put("limit", Integer.valueOf(map.get("limit").toString()));
		List<SalChance> list = salChanceService.findAllSalChanceInfo(map);
		int count = salChanceService.selectSalChanceCountRecordInfo(map);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("code", "");
		map1.put("msg", "");
		map1.put("count", count);
		map1.put("data", list);

		return map1;
	}

	/*
	 * 添加销售机会的controller方法
	 */
	@RequestMapping("/addSalChanceInfo")
	public void addSalChanceInfo(SalChance salChance, HttpServletResponse response) throws IOException {
		if(salChance.getChcTel()==null){
			salChance.setChcTel("");
		}
		salChance.setChcCreateDate(new Date());
		if (salChance.getChcCreateUser().getUsrId() != null) {
			salChance.setChcCreateDate(new Date());
		}
		Integer result = salChanceService.addSalChanceInfo(salChance);
		response.getWriter().print(result);
	}

	/*
	 * 删除销售机会的controller方法
	 */
	@RequestMapping("/delSalChanceInfo")
	public void delSalChanceInfo(Integer chcId, HttpServletResponse response) throws IOException {
		Integer result = salChanceService.delSalChanceInfo(chcId);
		response.getWriter().print(result);
	}

	@RequestMapping("/setSalChanceInfo")
	public void setSalChanceInfo(@RequestParam Map<String, Object> map, HttpServletResponse response,
			HttpSession session) throws IOException {
		if (map.get("chcStatus")!=null&&map.get("chcStatus").equals("3")) {
			String str = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
			map.put("custId", "HK" + str);
			// 因为Map接收没有默认值,数据库会报错
			for (String s : map.keySet()) {
				if ("".equals(map.get(s))) {
					map.put(s, "0");
				}
			}
			Integer resultCustomer = cstCustomerService.addCstCustomer(map);
			CstCustomer customer=cstCustomerService.findCstCustomerInfo(map.get("custId").toString());
			map.put("custNo",customer.getCustNo());
			Integer resultLinkman = cstLinkmanService.addCstLinkman(map);
			if (resultCustomer > 0 && resultLinkman > 0) {
				if (map.get("chcDueId") != null) {
					map.put("chcDueDate", new Date());
				}
				Integer result = salChanceService.setSalChanceInfo(map);
				response.getWriter().print(result);
			}

		} else {
			if (map.get("chcDueId") != null) {
				map.put("chcDueDate", new Date());
			}
			Integer result = salChanceService.setSalChanceInfo(map);
			response.getWriter().print(result);
		}

	}
	@RequestMapping("/findCheckchcCustName")
	public void findCheckchcCustName(String chcCustName,HttpServletResponse response) throws IOException{
		SalChance sc=salChanceService.findCheckchcCustName(chcCustName);
		if(sc!=null){
			response.getWriter().print(1);
		}else{
			response.getWriter().print(0);
		}
	}
}

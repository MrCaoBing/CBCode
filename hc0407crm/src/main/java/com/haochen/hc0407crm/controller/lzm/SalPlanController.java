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
import com.haochen.hc0407crm.entity.SalPlan;
import com.haochen.hc0407crm.service.cb.CstCustomerService;
import com.haochen.hc0407crm.service.cb.CstLinkmanService;
import com.haochen.hc0407crm.service.lzm.SalChanceService;
import com.haochen.hc0407crm.service.lzm.SalPlanService;
import com.haochen.hc0407crm.utils.Paging;

@Controller
public class SalPlanController {
	int i = 1;
	@Autowired
	private SalPlanService salPlanService;
	@Autowired
	private SalChanceService salChanceService;

	

	@RequestMapping("/findSalPlanInfo")
	public @ResponseBody Map<String, Object> findSalPlanInfo(Integer chcId, HttpSession session) {
		SalChance salChance = salChanceService.findAppointSalChanceInfo(chcId);
		List<SalPlan> list = salPlanService.findSalPlanInfo(chcId);
		Map<String, Object> map = new HashMap<String, Object>();
		session.setAttribute("salChance", salChance);

		System.out.println(i++);
		map.put("code", 0);
		map.put("msg", null);
		map.put("count", 0);
		map.put("data", list);
		return map;
	}

	@RequestMapping("/delSalPlanInfo")
	public void delSalPlanInfo(Integer plaId, HttpServletResponse response) throws IOException {
		Integer result = salPlanService.delSalPlanInfo(plaId);
		response.getWriter().print(result);
	}

	@RequestMapping("/addSalPlanInfo")
	public void addSalPlanInfo(SalPlan salPlan, HttpServletResponse response) throws IOException {
		salPlan.setPlaDate(new Date());
		Integer result = salPlanService.addSalPlanInfo(salPlan);
		response.getWriter().print(result);
	}

	@RequestMapping("/setSalPlanInfo")
	public void setSalPlanInfo(@RequestParam Map<String, Object> map, HttpServletResponse response) throws IOException {
		Integer result = salPlanService.setSalPlanInfo(map);
		response.getWriter().print(result);
	}
}

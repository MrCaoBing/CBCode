package com.haochen.hc0407crm.controller.cb;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.service.cb.CstCustomerService;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 针对客户操作的控制器
 * @author Mr.Cao
 * @date 2018年1月10日 上午10:36:27
 */
@Controller
public class CstCustomerController {
	
	@Autowired
	private CstCustomerService cstCustomerService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("listCstCustomer.do")
	public @ResponseBody Map listCstCustomer(Paging<CstCustomer> pg) {
		return cstCustomerService.listCstCustomer(pg).getResultMap();
	}
	
	/**
	 * 修改客户之前按id查到该客户
	 * @param mp
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("findCstCustomer.do")
	public String findCstCustomerById(@RequestParam Map mp,HttpServletRequest request) {
		CstCustomer cc = cstCustomerService.findCstCustomerById(mp);
		request.setAttribute("CstCustomer", cc);
		return "jsp/custInfoEdit";
	}
	
	/**
	 * 修改客户
	 * @param mp
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("setCstCustomer.do")
	public @ResponseBody int setCstCustomer(@RequestParam Map<String,String> mp) {
		System.out.println("set"+mp);
		//因为Map接收没有默认值,数据库会报错
		for (String s : mp.keySet()) {
			if ("".equals(mp.get(s))) {
				mp.put(s, "0");
			}
		}
		int result = cstCustomerService.setCstCustomer(mp);
		System.out.println(result);
		return result;	
	}
	
	/**
	 * 添加客户
	 * @param mp
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("addCstCustomer.do")
	public @ResponseBody int addCstCustomer(@RequestParam Map<String,Object> mp) {
		String str = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
		mp.put("custId", "HK"+str);
		//因为Map接收没有默认值,数据库会报错
		for (String s : mp.keySet()) {
			if ("".equals(mp.get(s))) {
				mp.put(s,"0");
			}
		}
		System.out.println(mp);
		int result = cstCustomerService.addCstCustomer(mp);
		System.out.println(result);
		return result;	
	}
	
	/**
	 * 跳转页面
	 * @param mp
	 * @param request
	 * @return
	 */
	@RequestMapping("skipToLinkmanPage.do")
	public String skipToLinkmanPage(@RequestParam Map mp,HttpServletRequest request) {	
		request.setAttribute("CstCustomer", cstCustomerService.findCstCustomerById(mp));
		return (String) mp.get("url");
	}
	
	
	
	@RequestMapping("listLoseCstCustomer.do")
	public @ResponseBody Map listLoseCstCustomer(Paging<CstCustomer> pg) {
		return cstCustomerService.listCstCustomer(pg).getResultMap();
	}

	@RequestMapping("idOnCustomerIfExists.do")
	public @ResponseBody CstCustomer idOnCustomerIfExists(String custName) {
		return 	cstCustomerService.getCstCustomerByName(custName);
	}
	
	/**
	 * 客户名智能提示
	 * @param custName
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("idOnCustomerNamePrompt.do")
	public @ResponseBody List<String> idOnCustomerNamePrompt(String term) throws UnsupportedEncodingException {
		term = new String(term.getBytes("ISO-8859-1"),"UTF-8");
		Paging<CstCustomer> pg = new Paging<CstCustomer>();
		pg.getMap().put("custNamePrefix", term);
		pg.setPage(1);
		pg.setLimit(1000000000);
		List<String> prompts = new ArrayList<String>();
		List<CstCustomer> custs = (List<CstCustomer>) cstCustomerService.listCstCustomer(pg).getData();
		for (int i = 0; i < custs.size(); i++) {
			prompts.add(custs.get(i).getCustName());
		}
		return prompts;
	}
}

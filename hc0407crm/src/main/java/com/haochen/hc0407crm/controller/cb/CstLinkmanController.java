package com.haochen.hc0407crm.controller.cb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.service.cb.CstCustomerService;
import com.haochen.hc0407crm.service.cb.CstLinkmanService;
import com.haochen.hc0407crm.service.cb.impl.CstLinkmanServiceImpl;
/**
 * 针对客户联系人的控制器
 * @author Mr.Cao
 * @date 2018年1月10日 下午7:12:26
 */
@Controller
public class CstLinkmanController {
	
	@Autowired
	private CstLinkmanService cstLinkmanService;
	
	@RequestMapping("listCstLinkman.do")
	public @ResponseBody Map listCstLinkman(@RequestParam Map mp) {
		List lis = cstLinkmanService.listCstLinkman(mp);
		mp.clear();
		mp.put("msg", "");
		mp.put("code", 0);	
		mp.put("count", lis.size());
		mp.put("data", lis);	
		return mp;
	}
	
	@RequestMapping("setCstLinkman.do")
	public @ResponseBody int setCstLinkman(@RequestParam Map mp) {
		return cstLinkmanService.setCstLinkman(mp);
	}
	
	@RequestMapping("addCstLinkman.do")
	public @ResponseBody int addCstLinkman(@RequestParam Map mp) {
		return cstLinkmanService.addCstLinkman(mp);
	}
	
	@RequestMapping("delCstLinkman.do")
	public @ResponseBody int delCstLinkman(@RequestParam Map mp) {
		return cstLinkmanService.delCstLinkman(mp);
	}
}

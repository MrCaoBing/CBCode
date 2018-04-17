package com.haochen.hc0407crm.controller.cb;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.CstLost;
import com.haochen.hc0407crm.service.cb.CstCustomerService;
import com.haochen.hc0407crm.service.cb.CstLostService;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 针对客户流失的控制器
 * @author Mr.Cao
 * @date 2018年1月12日 下午8:15:45
 */
@Controller
public class CstLostController {
	
	@Autowired
	private CstLostService CstLostService;
	
	@RequestMapping("listCstLost.do")
	public @ResponseBody Map listCstLost(Paging<CstLost> pg) {		
		return CstLostService.listCstLost(pg).getResultMap();
	}
	@RequestMapping("setCstLost.do")
	public @ResponseBody int setCstLost(@RequestParam Map mp) {		
		try {
			return CstLostService.setCstLost(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}

package com.haochen.hc0407crm.controller.cb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.service.cb.CstCustomerService;
import com.haochen.hc0407crm.service.cb.CstLostService;
import com.haochen.hc0407crm.utils.Paging;

@Component("CheckCustInfoJob")
public class CheckCustInfoJob {
	
	@Autowired
	private CstCustomerService cstCustomerService;
	@Autowired
	private CstLostService cstLostService;
	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void cstCustomerWarning() {
		//�õ�����Ԥ���ͻ�
		Paging<CstCustomer> pg = new Paging<CstCustomer>();
		pg.setPage(1);
		pg.setLimit(1000000000);
		pg.getMap().put("warning", "1");
		pg = cstCustomerService.listCstCustomer(pg);
		System.out.println(pg);
		//���Ԥ����Ϣ
		for (CstCustomer c : pg.getData()) {
			System.out.println(c.getCustNo());
			Map mp = new HashMap();
			mp.put("lstLastOrderDate", c.getLostTime());
			System.out.println(mp.get("lstLastOrderDate"));
			mp.put("custNo", c.getCustNo());
			mp.put("usrNo", c.getSysUser().getUsrId());
			cstLostService.addCstLost(mp);
		}
		//�޸���ؿͻ���Ϣ
		Map map = new HashMap();
		map.put("custStatus", 4);
		cstCustomerService.setCstCustomer(map);
		
		System.out.println("ִ�пͻ�Ԥ�������ɹ���");
	}
}

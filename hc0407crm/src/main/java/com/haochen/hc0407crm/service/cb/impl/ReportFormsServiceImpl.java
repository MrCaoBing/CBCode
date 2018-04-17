package com.haochen.hc0407crm.service.cb.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.cb.ReportFormsDao;
import com.haochen.hc0407crm.service.cb.ReportFormsService;
import com.haochen.hc0407crm.utils.Paging;
@Service("reportFormsServiceImpl")
public class ReportFormsServiceImpl implements ReportFormsService{
	
	@Autowired
	private ReportFormsDao reportFormsDao;
	
	@Override
	public Paging listCustAccounted(Paging pg) {
		pg.setCount(reportFormsDao.queryCustAccountedCount(pg));
		pg.setData(reportFormsDao.queryCustAccounted(pg));
		return pg;
	}

	@Override
	public Paging listCustConstitute(Paging pg) {
		pg.setCount(reportFormsDao.queryCustConstituteCount(pg));
		pg.setData(reportFormsDao.queryCustConstitute(pg));
		return pg;
	}

	@Override
	public Paging listCustService(Paging pg) {
		pg.setCount(reportFormsDao.queryCustServiceCount(pg));
		pg.setData(reportFormsDao.queryCustService(pg));
		return pg;
	}

	@Override
	public List<Map<String, Object>> listCustLost() {
		return reportFormsDao.queryCustLost();
	}

}

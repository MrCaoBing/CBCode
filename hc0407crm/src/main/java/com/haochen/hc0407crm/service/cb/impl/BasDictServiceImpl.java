package com.haochen.hc0407crm.service.cb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.cb.BasDictDao;
import com.haochen.hc0407crm.dao.cb.SysUserDao;
import com.haochen.hc0407crm.entity.BasDict;
import com.haochen.hc0407crm.entity.CstCustomer;
import com.haochen.hc0407crm.entity.SysUser;
import com.haochen.hc0407crm.service.cb.BasDictService;
import com.haochen.hc0407crm.service.cb.SysUserService;
import com.haochen.hc0407crm.utils.Paging;

@Service("basDictServiceImpl")
public class BasDictServiceImpl implements BasDictService {

	@Autowired
	private BasDictDao basDictDao;
	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 加载基础数据
	 */
	@Override
	public Map loadFoundationData() {
		List<BasDict> lis = basDictDao.listBasDict(new HashMap());
		Map roleIdMap = new HashMap();
		roleIdMap.put("roleId", 4);
		// 查找所有是经理的用户
		List<SysUser> syslis = sysUserDao.listSysUser(roleIdMap);
		Map<String, Object> mp = new HashMap();
		mp.put("BasDictList", lis);
		String area = "<option value=\"\"></option>";
		String custLevel = "<option value=\"\"></option>";
		String serviceType = "<option value=\"\"></option>";
		String custSource = "<option value=\"\"></option>";
		String custmanager = "<option value=\"\"></option>";
		for (BasDict bd : lis) {
			if ("地区".equals(bd.getDictType())) {
				area += "<option value=\"" + bd.getDictItem() + "\">" + bd.getDictItem() + "</option>";
			} else if ("客户等级".equals(bd.getDictType())) {
				custLevel += "<option value=\"" + bd.getDictItem() + "\">" + bd.getDictItem() + "</option>";
			} else if ("服务类型".equals(bd.getDictType())) {
				serviceType += "<option value=\"" + bd.getDictItem() + "\">" + bd.getDictItem() + "</option>";
			} else if ("客户来源".equals(bd.getDictType())) {
				custSource += "<option value=\"" + bd.getDictItem() + "\">" + bd.getDictItem() + "</option>";
			}
		}
		for (SysUser su : syslis) {
			custmanager += "<option value=\"" + su.getUsrId() + "\">" + su.getUsrName() + "</option>";
		}
		mp.put("area", area);
		mp.put("custLevel", custLevel);
		mp.put("serviceType", serviceType);
		mp.put("custSource", custSource);
		mp.put("custmanager", custmanager);
		return mp;
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("applicationContext.xml");
		BasDictService su = (BasDictService) cc.getBean("basDictServiceImpl");
		System.out.println(su.loadFoundationData());
	}

	@Override
	public Paging listBasDictTiaojian(Paging<BasDict> pg) {
		pg.setCount(basDictDao.findBasDictCount(pg));
		pg.setData(basDictDao.listBasDictTiaojian(pg));
		return pg;
	}

	@Override
	public int addBasDict(Map mp) {
		try {
			return basDictDao.insertBasDict(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delBasDict(Map mp) {
		try {
			return basDictDao.deleteBasDict(mp);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int setBasDict(Map mp) {
		try{
			return basDictDao.updateBasDict(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int findDictItem(String dictItem1) {
		
		return basDictDao.findDictItem(dictItem1);
	}
	
}

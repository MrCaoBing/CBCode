package com.haochen.hc0407crm.service.cb.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.cb.SysRoleDao;
import com.haochen.hc0407crm.dao.cb.SysRoleRightDao;
import com.haochen.hc0407crm.entity.SysRight;
import com.haochen.hc0407crm.entity.SysRole;
import com.haochen.hc0407crm.service.cb.SysRoleService;
@Service("sysRoleServiceImpl")
public class SysRoleServiceImpl implements SysRoleService{
	
	@Resource
	private SysRoleDao sysRoleDao;
	@Resource
	private SysRoleRightDao sysRoleRightDao;
	
	@Override
	public List<SysRole> listSysRole() {
		return sysRoleDao.querySysRole();
	}

	@Override
	public int addSysRole() {
		return 0;
	}
	@Override
	public List<SysRight> listSysRoleById(Map<String, String> mp) {
		return sysRoleRightDao.listSysRoleRight(mp);
	}
	
	@Override
	public int ifRoleNameExists(Map<String, String> mp) {
		return sysRoleDao.selectSysRoleByName(mp);
	}
	
	@Override
	public int addSysRoleRight(Map<String, Object> mp) throws Exception{
		int i = sysRoleDao.insertSysRole(mp);
		if (mp.get("rightArr") != null) {
			List<String> newRights = (List<String>) Arrays.asList((String[])mp.get("rightArr"));			
			for (String s:newRights) {
				mp.put("rightId", s);
				sysRoleRightDao.insertSysRoleRight(mp);
			}
		}
		return 1;
	}
	@Override
	public int setSysRoleRight(Map<String, Object> mp)  throws Exception{
		//该角色新的的权限
		int i = sysRoleRightDao.deleteSysRoleRight(mp);
		sysRoleDao.updateSysRole(mp);
		if (mp.get("rightArr") != null) {
			List<String> newRights = (List<String>) Arrays.asList((String[])mp.get("rightArr"));	
			if(newRights.size() == 1) return 1;
			for (String s:newRights) {
				mp.put("rightId", s);
				sysRoleRightDao.insertSysRoleRight(mp);
			}
		}		
		return 1;
	}

	
}

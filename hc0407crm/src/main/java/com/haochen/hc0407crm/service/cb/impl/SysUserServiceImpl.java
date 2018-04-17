package com.haochen.hc0407crm.service.cb.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.haochen.hc0407crm.dao.cb.SysRoleRightDao;
import com.haochen.hc0407crm.dao.cb.SysUserDao;
import com.haochen.hc0407crm.entity.Node;
import com.haochen.hc0407crm.entity.SysRight;
import com.haochen.hc0407crm.entity.SysRoleRight;
import com.haochen.hc0407crm.entity.SysUser;
import com.haochen.hc0407crm.service.cb.SysUserService;
import com.haochen.hc0407crm.utils.MD5;
import com.haochen.hc0407crm.utils.Paging;
@Service("sysUserServiceImpl")
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleRightDao sysRoleRightDao;
	
	/**
	 * 登录成功返回Map,
	 * 保存节点集合的Key为:nodes
	 * 保存用户对象的Key为:sysUser
	 */
	@Override
	public Map login(Map mp) {
		if (mp.get("usrPassword") != null) {
			String str = (String) mp.get("usrPassword");
			mp.put("usrPassword", MD5.strMD5(str));
		}
		Map resultmap = new HashMap();
		//用户登录
		System.out.println(mp);
		List<SysUser> sysUser = sysUserDao.listSysUser(mp);
		//登录成功则根据角色编号查找权限
		if (sysUser != null && sysUser.size() != 0) {
			resultmap.put("sysUser", sysUser);
			if (sysUser.get(0).getSysRole() == null) {
				return resultmap;
			}
			mp.put("roleId", sysUser.get(0).getSysRole().getRoleId());
			List<SysRight> sysRight = sysRoleRightDao.listSysRoleRight(mp);
			if (sysRight.size() == 0) {
				return resultmap;
			}
			
			//添加节点
			List<Node> nodes1 = new ArrayList<Node>();
			//遍历父节点
			for (int i = 0; i < sysRight.size(); i++) {
				//如果该参数为ROOT_MENU
				if ("ROOT_MENU".equals(sysRight.get(i).getRightParentCode())) {
					Node node1 = new Node();
					node1.setId(sysRight.get(i).getRightCode());
					node1.setText(sysRight.get(i).getRightText());
					Map mp1 = new HashMap();
					mp1.put("pageUrl", sysRight.get(i).getRightUrl());
					node1.setAttributes(mp1);
					for (int j = 0; j < sysRight.size(); j++) {
						//如果该权限父类为当前外层权限
						if (sysRight.get(j).getRightParentCode().equals(sysRight.get(i).getRightCode())) {
							Node node2 = new Node();							
							node2.setId(sysRight.get(j).getRightCode());
							node2.setText(sysRight.get(j).getRightText());
							Map mp2 = new HashMap();
							//存入该节点包含的页面路径
							mp2.put("pageUrl", sysRight.get(j).getRightUrl());
							node2.setAttributes(mp2);
							node1.getChildren().add(node2);
						}
					}
					nodes1.add(node1);
				}
			}
			resultmap.put("nodes", nodes1);
			return resultmap;
		}		
		return null;
	}
	
	/*public static void main(String[] args) {
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysUserService su = (SysUserService) cc.getBean("sysUserServiceImpl");
		Map mp = new HashMap();
		mp.put("usrName", "admin");
		mp.put("usrPassword", "admin");
		
		System.out.println(su.login(mp));
	}*/

	@Override
	public Paging listAllSysUser(Paging pg) {
		pg.setCount(sysUserDao.queryAllSysUserCount(pg));
		pg.setData(sysUserDao.queryAllSysUser(pg));
		return pg;
	}

	@Override
	public int setSysUser(Map<String, String> mp) {
		//MD5加密
		if (mp.get("usrPwd") != null) {
			System.out.println(mp.get("usrPwd"));
			String str = mp.get("usrPwd");
			System.out.println(str);
			mp.put("usrPwd", MD5.strMD5(str));
		}
		return sysUserDao.updateSysUser(mp);
	}

	@Override
	public int addSysUser(Map<String, String> mp) {
		//MD5加密
		if (mp.get("usrPwd") != null) {
			String str = mp.get("usrPwd");
			mp.put("usrPwd", MD5.strMD5(str));
		}
		return sysUserDao.insertSysUser(mp);
	}

	@Override
	public int ifSysUserNameExists(String name) {
		try {
			//转码
			return sysUserDao.querySysUserByName(new String(name.getBytes("ISO-8859-1"), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}

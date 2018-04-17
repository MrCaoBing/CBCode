package com.haochen.hc0407crm.controller.cb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.service.cb.SysRoleService;

/**
 * 针对角色操作的控制器
 * @author Mr.Cao
 * @date 2018年1月18日 上午9:24:18
 */
@Controller
public class SysRoleController {
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("listSysRole.do")
	public @ResponseBody Map listSysRole() {		
		List lis = sysRoleService.listSysRole();
		Map mp = new HashMap();
		mp.put("msg", "");
		mp.put("code", 0);	
		mp.put("count", lis.size());
		mp.put("data", lis);	
		return mp;
	}
	
	@RequestMapping("setSysRole.do")
	public @ResponseBody int setSysRole(@RequestParam Map<String,Object> mp) throws Exception {
		int i = sysRoleService.setSysRoleRight(mp);
		return i;
	}
	
	@RequestMapping("listSysRightById.do")
	public @ResponseBody List listSysRightById(@RequestParam Map<String,String> mp) {
		return sysRoleService.listSysRoleById(mp);
	}
	
	@RequestMapping("ifRoleNameExists.do")
	public @ResponseBody int ifRoleNameExists(@RequestParam Map<String,String> mp) {
		return sysRoleService.ifRoleNameExists(mp);
	}
	
	@RequestMapping("addRoleRight.do")
	public @ResponseBody int addRoleRight(@RequestParam Map<String,Object> mp) {
		mp.put("rightArr", mp.get("rightArr").toString().split(","));
		try {
			return sysRoleService.addSysRoleRight(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("setRoleRight.do")
	public @ResponseBody int setRoleRight(@RequestParam Map<String,Object> mp) {
		mp.put("rightArr", mp.get("rightArr").toString().split(","));
		try {
			return sysRoleService.setSysRoleRight(mp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}

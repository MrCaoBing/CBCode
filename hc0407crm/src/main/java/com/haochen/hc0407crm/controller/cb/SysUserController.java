package com.haochen.hc0407crm.controller.cb;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.entity.SysUser;
import com.haochen.hc0407crm.service.cb.BasDictService;
import com.haochen.hc0407crm.service.cb.SysUserService;
import com.haochen.hc0407crm.utils.Paging;

/**
 * 针对用户的控制器
 * @author Mr.Cao
 * @date 2018年1月7日 下午10:09:49
 */
@Controller
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserServiceImpl;
	@Autowired
	private BasDictService basDictService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("login.do")
	public @ResponseBody String login(@RequestParam Map mp,HttpServletRequest request,HttpServletResponse response) {
		//如果登录成功,该map必定包含节点集合与用户对象
		Map map = sysUserServiceImpl.login(mp);
		if (map != null) {
			//将节点信息存入request
			request.getSession().setAttribute("nodes", map.get("nodes"));
			//将用户信息存入session
			request.getSession().setAttribute("sysUser", map.get("sysUser"));
			System.out.println(request.getSession().getAttribute("sysUser"));
			//查看基础数据是否被加载
			//if (request.getSession().getServletContext().getAttribute("foundationData") == null) {}			
			System.out.println("加载基础数据!");
			request.getSession().getServletContext().setAttribute("foundationData", basDictService.loadFoundationData());					
			return "jsp/index.jsp";
		}
		return "jsp/login.jsp";
	}
	
	@RequestMapping("listSysUser.do")
	public @ResponseBody Map lisySysUser(Paging<SysUser> pg) {
		return sysUserServiceImpl.listAllSysUser(pg).getResultMap();
	}
	
	@RequestMapping("setSysUser.do")
	public @ResponseBody int setSysUser(@RequestParam Map<String,String> mp) {
		System.out.println(mp);
		return sysUserServiceImpl.setSysUser(mp);
	}
	
	@RequestMapping("addSysUser.do")
	public @ResponseBody int addSysUser(@RequestParam Map<String,String> mp) {
		System.out.println(mp);
		return sysUserServiceImpl.addSysUser(mp);
	}
	
	@RequestMapping("ifNameExists.do")
	public @ResponseBody int ifNameExists(String usrName) {
		return sysUserServiceImpl.ifSysUserNameExists(usrName);
	}
}

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
 * ����û��Ŀ�����
 * @author Mr.Cao
 * @date 2018��1��7�� ����10:09:49
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
		//�����¼�ɹ�,��map�ض������ڵ㼯�����û�����
		Map map = sysUserServiceImpl.login(mp);
		if (map != null) {
			//���ڵ���Ϣ����request
			request.getSession().setAttribute("nodes", map.get("nodes"));
			//���û���Ϣ����session
			request.getSession().setAttribute("sysUser", map.get("sysUser"));
			System.out.println(request.getSession().getAttribute("sysUser"));
			//�鿴���������Ƿ񱻼���
			//if (request.getSession().getServletContext().getAttribute("foundationData") == null) {}			
			System.out.println("���ػ�������!");
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

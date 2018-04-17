package com.haochen.hc0407crm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 系统初始化,用来加载字典表中的数据,判断是否登录等
 * @author Mr.Cao
 * @date 2018年1月8日 下午2:32:41
 */
public class InitFilter implements Filter {
	
	/**
	 * 免检路径。以","号分隔
	 */
	private String exclide_urls;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.exclide_urls = fConfig.getInitParameter("exclide_urls");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String url = ((HttpServletRequest) request).getRequestURI();
		System.out.println("过滤器:目标页面 : "+url);
		//如果用户没有登录则先登录,部分页面可放行比如注册 
		boolean ifLogin = false;
		
		//拿到配置文件中指定的url名,解析为数组
		String[] urls = this.exclide_urls.split(",");
		//逐一匹配
		/*for (int i = 0; i < urls.length; i++) {
			if (url.indexOf(urls[i]) != -1) {
				ifLogin = true;
			}
		}
		
		if(!ifLogin) {
			if (session.getAttribute("sysUser") == null) {
				System.out.println("过滤器：未登录");
				response.sendRedirect("/hc0407crm/jsp/login.jsp");
				return;
			}		
		}*/
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
				
	}

}

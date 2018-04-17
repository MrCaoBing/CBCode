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
 * ϵͳ��ʼ��,���������ֵ���е�����,�ж��Ƿ��¼��
 * @author Mr.Cao
 * @date 2018��1��8�� ����2:32:41
 */
public class InitFilter implements Filter {
	
	/**
	 * ���·������","�ŷָ�
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
		System.out.println("������:Ŀ��ҳ�� : "+url);
		//����û�û�е�¼���ȵ�¼,����ҳ��ɷ��б���ע�� 
		boolean ifLogin = false;
		
		//�õ������ļ���ָ����url��,����Ϊ����
		String[] urls = this.exclide_urls.split(",");
		//��һƥ��
		/*for (int i = 0; i < urls.length; i++) {
			if (url.indexOf(urls[i]) != -1) {
				ifLogin = true;
			}
		}
		
		if(!ifLogin) {
			if (session.getAttribute("sysUser") == null) {
				System.out.println("��������δ��¼");
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

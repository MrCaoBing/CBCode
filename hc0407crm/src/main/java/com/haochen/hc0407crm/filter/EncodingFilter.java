package com.haochen.hc0407crm.filter;

import java.io 

.IOException;
import java.io 

.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;


/**
 * ���������
 * @author Mr.Cao
 *
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	/**
	 * ��ȡ���뷽ʽ
	 */
	protected String encoding = "UTF-8";

	public void destroy() {
		System.out.println("������ : ����!");
		this.encoding = null;
	}


	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding(this.encoding);
		response.setContentType("text/html;charset="+this.encoding);
		response.setCharacterEncoding(this.encoding);

		//��������
		chain.doFilter(new RequestEncoding((HttpServletRequest) request, request.getParameterMap()), response);
	}


	public void init(FilterConfig config) throws ServletException {
		System.out.println("������ : ��ʼ��!");
		//��ǰ������ʹ��ע�����ã�����Ҫ��web.xml�õ���ʼ������
		//this.encoding = config.getInitParameter("encoding");
		System.out.println("������ : ��ʼ��,���˱���Ϊ:"+this.encoding);
	}

}

/**
 * ��reqeust�������а�װ
 * @author Mr.Cao
 *
 */
class RequestEncoding extends HttpServletRequestWrapper  {
	
	private Map<String,String[]> params = new HashMap<String,String[]>();

	public RequestEncoding(HttpServletRequest request, Map<String,String[]> newParams) { 
        super(request);
        //����Բ����е������ַ������滻
  		for (String s:newParams.keySet()) { 
  			this.params.put(s, zhangYi(newParams.get(s),request));
  		}	
    }  
    
    protected static String[] zhangYi(String[] strArr,HttpServletRequest request) {
		for (int i = 0; i < strArr.length; i++) {
			try {				
				if (strArr[i] != null && strArr[i] != "") {
					//��get��������ת��
					System.out.print("����ǰ��"+strArr[i]);
					if (request.getMethod().equals("GET") && isUTF8(strArr[i])) {
						strArr[i] = new String(strArr[i].getBytes("ISO-8859-1"),"UTF-8");
					}	
					//�Թؼ��ַ������滻
					strArr[i] = strArr[i].replace("<", "&lt;");
					strArr[i] = strArr[i].replace(">", "&gt;");	
					strArr[i] = strArr[i].replace("'", "&apos;");	
					strArr[i] = strArr[i].replace("\"", "&quot;");	
					System.out.println("	||	���˺�"+strArr[i]);
				}
			} catch (Exception e) {
				System.err.println("������:ת�����");
			}			
		}
		return strArr;
	}
    
    /**
     * �ж��ַ��Ƿ���UTF-8
     * @param key
     * @return
     */
    public static boolean isUTF8(String key){
        try {
            key.getBytes("ISO-8859-1");
            return true;
        } catch (UnsupportedEncodingException e) {        
            return false;
        }
    }
    
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }
 
    @Override
	public Map<String,String[]> getParameterMap() {	
		return params;
	}

}

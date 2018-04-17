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
 * 编码过滤器
 * @author Mr.Cao
 *
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	/**
	 * 获取编码方式
	 */
	protected String encoding = "UTF-8";

	public void destroy() {
		System.out.println("过滤器 : 销毁!");
		this.encoding = null;
	}


	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding(this.encoding);
		response.setContentType("text/html;charset="+this.encoding);
		response.setCharacterEncoding(this.encoding);

		//过滤器链
		chain.doFilter(new RequestEncoding((HttpServletRequest) request, request.getParameterMap()), response);
	}


	public void init(FilterConfig config) throws ServletException {
		System.out.println("过滤器 : 初始化!");
		//当前过滤器使用注解配置，不需要从web.xml拿到初始化参数
		//this.encoding = config.getInitParameter("encoding");
		System.out.println("过滤器 : 初始化,过滤编码为:"+this.encoding);
	}

}

/**
 * 对reqeust参数进行包装
 * @author Mr.Cao
 *
 */
class RequestEncoding extends HttpServletRequestWrapper  {
	
	private Map<String,String[]> params = new HashMap<String,String[]>();

	public RequestEncoding(HttpServletRequest request, Map<String,String[]> newParams) { 
        super(request);
        //如果对参数中的敏感字符进行替换
  		for (String s:newParams.keySet()) { 
  			this.params.put(s, zhangYi(newParams.get(s),request));
  		}	
    }  
    
    protected static String[] zhangYi(String[] strArr,HttpServletRequest request) {
		for (int i = 0; i < strArr.length; i++) {
			try {				
				if (strArr[i] != null && strArr[i] != "") {
					//对get参数进行转码
					System.out.print("过滤前："+strArr[i]);
					if (request.getMethod().equals("GET") && isUTF8(strArr[i])) {
						strArr[i] = new String(strArr[i].getBytes("ISO-8859-1"),"UTF-8");
					}	
					//对关键字符进行替换
					strArr[i] = strArr[i].replace("<", "&lt;");
					strArr[i] = strArr[i].replace(">", "&gt;");	
					strArr[i] = strArr[i].replace("'", "&apos;");	
					strArr[i] = strArr[i].replace("\"", "&quot;");	
					System.out.println("	||	过滤后："+strArr[i]);
				}
			} catch (Exception e) {
				System.err.println("过滤器:转码错误！");
			}			
		}
		return strArr;
	}
    
    /**
     * 判断字符是否是UTF-8
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

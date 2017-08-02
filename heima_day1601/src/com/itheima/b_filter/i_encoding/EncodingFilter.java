package com.itheima.b_filter.i_encoding;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// 放行,将包装过的request传递
		chain.doFilter(new MyRequest(req), response);
	}

	@Override
	public void destroy() {
	}

}

class MyRequest extends HttpServletRequestWrapper {

	private HttpServletRequest _requst;
	private boolean flagEncoding = false; // 编码转换标志

	public MyRequest(HttpServletRequest request) {
		super(request);
		this._requst = request;
	}

	@Override
	public String getParameter(String name) {
		if (name == null || name.length() == 0)
			return null;
		String[] values = _requst.getParameterValues(name);
		if (values == null || values.length == 0)
			return null;
		return values[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		if (name == null || name.length() == 0)
			return null;
		Map<String, String[]> map = _requst.getParameterMap();
		if (map == null || map.size() == 0)
			return null;
		String[] arrStr = map.get(name);
		if (arrStr.length == 0)
			return null;
		return arrStr;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		String method = _requst.getMethod();
		String[] arrStr;
		if (!flagEncoding) {
			if ("get".equalsIgnoreCase(method)) {
				Map<String, String[]> map = super.getParameterMap();
				for (String key : map.keySet()) {
					arrStr = map.get(key);
					for (int i = 0; i < arrStr.length; i++)
						try {
							arrStr[i] = new String(arrStr[i].getBytes("ISO-8859-1"), "utf-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
				}
				return map;
			} else if ("post".equalsIgnoreCase(method)) {
				try {
					_requst.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e) {
				}
				return _requst.getParameterMap();
			}
			flagEncoding = true;
		}
		return _requst.getParameterMap();
	}
}

/*
 * class MyResponse extends HttpServletResponseWrapper {
 * 
 * private HttpServletResponse _response;
 * 
 * public MyResponse(HttpServletResponse response) { super(response);
 * this._response = response; }
 * 
 * 
 * }
 */

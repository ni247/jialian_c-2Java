package com.itheima.filter;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RRPlus extends HttpServletRequestWrapper {

	public RRPlus(HttpServletRequest request) {
		super(request);
		this._requst = request;
	}

	private HttpServletRequest _requst;
	private boolean flagEncoding = false; // 编码转换标志

	@Override
	public String getParameter(String name) {
		if (name == null || name.length() == 0)
			return null;
		String[] values = getParameterValues(name);
		if (values == null || values.length == 0)
			return null;
		return values[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		if (name == null || name.length() == 0)
			return null;
		Map<String, String[]> map = getParameterMap();
		if (map == null || map.size() == 0)
			return null;
		return map.get(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		String method = _requst.getMethod();
		String[] arrStr;
		if (flagEncoding)
			return _requst.getParameterMap();
		if ("get".equalsIgnoreCase(method)) {
			Map<String, String[]> map = super.getParameterMap();
			for (String key : map.keySet()) {
				arrStr = map.get(key);
				for (int i = 0; i < arrStr.length; i++)
					try {
						arrStr[i] = new String(arrStr[i].getBytes("ISO-8859-1"), "utf-8");
					} catch (UnsupportedEncodingException e) {
					}
			}
			flagEncoding = true;
			return map;
		} else if ("post".equalsIgnoreCase(method)) {
			try {
				flagEncoding = true;
				_requst.setCharacterEncoding("utf-8");
				return _requst.getParameterMap();
			} catch (UnsupportedEncodingException e) {
			}
		}
		return super.getParameterMap();
	}

}

package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.constant.CCommonConstant;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Class<? extends BaseServlet> runClass = this.getClass();
		String methodName = req.getParameter(CCommonConstant.DEFAULT_METHOD);
		if (methodName == null)
			methodName = CCommonConstant.DEFAULT_PAGE;
		String uri = null;
		try {
			Method method = runClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			uri = (String) method.invoke(this, req, resp);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			resp.sendRedirect(getServletContext().getContextPath() + CCommonConstant.ERROR_PAGE);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		if (uri != null && uri.length() > 0)
			req.getRequestDispatcher(uri).forward(req, resp);
	}

	/**
	 * 这一块因为如果没有赋予方法值,/store/user方式.则为了避免空指针.提供一个index方法.返回null;
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws Exception 
	 */
	public String index(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception {
		return null;
	}
}

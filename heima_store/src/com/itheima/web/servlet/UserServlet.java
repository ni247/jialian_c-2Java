package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.itheima.constant.CCommonConstant;
import com.itheima.constant.CUserConstant;
import com.itheima.domain.User;
import com.itheima.myconventer.MyConventer;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.CookUtils;
import com.itheima.utils.MD5Utils;
import com.itheima.utils.UUIDUtils;

/**
 * 和用户相关的方法
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userservlet的add方法执行了");
		return null;
	}

	/**
	 * 跳转到注册页面
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String registUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return CCommonConstant.REGIST_PAGE;
	}

	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1.封装数据
		User use = new User();
		// 注册自定义转换器
		ConvertUtils.register(new MyConventer(), Date.class);
		String name = request.getParameter("name");
		BeanUtils.populate(use, request.getParameterMap());
		// 打印use
		System.out.println(use);
		// 设置用户id
		use.setUid(UUIDUtils.getId());
		// 设置验证码
		use.setCode(UUIDUtils.getCode());
		// 加密密码
		use.setPassword(MD5Utils.md5(use.getPassword()));
		// 2.调用service完成注册
		IUserService service = (IUserService) BeanFactory.getBean("UserService");
		service.regest(use);
		// 3页面请求转发
		request.setAttribute("msg", "用户注册成功,请去邮箱激活");
		// 返回
		return CCommonConstant.MSG_PAGE;
	}

	/**
	 * 用户激活
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取激活码
		String code = request.getParameter("code");
		// 调用service完成激活操作
		IUserService service = (IUserService) BeanFactory.getBean("UserService");
		User user = service.active(code);
		// 页面跳转到msg界面
		if (user == null || user.getState() == CUserConstant.NOT_ACTIVE)
			request.setAttribute(CCommonConstant.DEFAULT_MSG, "激活失败");
		else
			request.setAttribute(CCommonConstant.DEFAULT_MSG, "激活成功");
		// 返回
		return "/jsp/msg.jsp";
	}

	/**
	 * 跳转到登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 注意,密码已加密
		password = MD5Utils.md5(password);
		// 调用servce完成登录 完成user
		IUserService s = (IUserService) BeanFactory.getBean("UserService");
		User user = s.login(username, password);
		// 判断用户
		if (user == null) {
			// 用户名密码不匹配
			request.setAttribute(CCommonConstant.DEFAULT_MSG, "用户名密码不匹配");
			return CCommonConstant.LOGIN_PAGE;
		} else {
			// 继续判断用户状态是否激活
			if (CUserConstant.ACTIVED != user.getState()) {
				request.setAttribute(CCommonConstant.DEFAULT_MSG, "用户未激活");
				return CCommonConstant.LOGIN_PAGE;
			}
		}
		// 将user放入session中,重定向
		request.getSession().setAttribute(CUserConstant.USER_ATTR, user);
		response.sendRedirect(request.getContextPath() + "/");
		return null;
	}

	public String loginUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return CCommonConstant.LOGIN_PAGE;
	}

	/***
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public String loginout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 干掉session
		request.getSession().invalidate();
		// 处理自动登录
		// CookUtils.getCookieByName("username", cookies)
		return CCommonConstant.LOGIN_PAGE;
	}

}

package com.itheima.constant;

public interface CCommonConstant {
	//默认编码
	String RES_CONTENT_TYPE = "text/html;charset=utf-8";
	
	//默认页面
	String DEFAULT_PAGE = "index";
	String DEFAULT_PAGE2 = "/jsp/index.jsp";
	String DEFAULT_METHOD = "method";
	String ERROR_PAGE = "/404.jsp";
	String UNUSUAL_PAGE = "/500.jsp";
	String REGIST_PAGE = "/500.jsp";
	String MSG_PAGE = "/jsp/msg.jsp";
	String DEFAULT_MSG = "msg";
	String LOGIN_PAGE = "/jsp/login.jsp";
	
	//缓存配置文件
	String CHCHE_FILE_NAME="ehcache.xml";
	String DEFAULT_CHCHE_NAME="categoryCache";
	
	int PAGE_SIZE=2;
}

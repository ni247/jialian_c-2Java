package com.itheima.service.impl;

import com.itheima.constant.CUserConstant;
import com.itheima.dao.IProductDao;
import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.MailUtils;

public class UserServiceImpl implements IUserService {

	/**
	 * 用户注册逻辑
	 */
	@Override
	public void regest(User use) throws Exception {
		IUserDao dao = (IUserDao) BeanFactory.getBean("UserDao");
		dao.add(use);
		// 发送邮件
		// email-收件人地址
		// 收件信息
		String emailMsg = "欢迎注册我们的会员,<a href='http://localhost/store/user?method=active&code=" + use.getCode()
				+ "'>点此激活</a>";
		MailUtils.sendMail(use.getEmail(), emailMsg);
	}

	@Override
	public User active(String code) throws Exception {
		IUserDao dao = (IUserDao) BeanFactory.getBean("UserDao");
		// 1.通过code获取一个用户
		User user = dao.getByCode(code);
		// 2.判断用户是否为空
		if (user == null)
			return null;
		// 3.修改用户状态
		// 将用户状态设置为1
		user.setState(CUserConstant.ACTIVED);
		dao.updateByUser(user);
		return user;
	}

	@Override
	public User login(String username, String password) throws Exception {
		IUserDao dao = (IUserDao) BeanFactory.getBean("UserDao");
		return dao.getByUsernameAndPws(username, password);
	}
}

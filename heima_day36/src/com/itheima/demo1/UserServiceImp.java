package com.itheima.demo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 组件注解:标记类 <bean id="userservice" class=
 * "com.itheima.demo1.UserserviceImpl">==>@Component(value="userservice")
 * 
 * @author Administrator
 *
 */
@Component(value = "userService")
public class UserServiceImp implements IUserService {

	// value是基础类型用的.autowired引用类型,按类型自动装配
	// qualifier按照名称来执行
	/*
	 * @Autowired
	 * 
	 * @Qualifier(value = "ud")
	 */
	// resource注解,是java提供的,可以通过名称 name找类
	@Resource(name = "userDao")
	private IUserDao userDao;

	@Override
	public void sayHello() {
		System.out.println("我是sayhello");
		userDao.save();
	}

}

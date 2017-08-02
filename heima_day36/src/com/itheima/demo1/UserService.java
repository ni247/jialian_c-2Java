package com.itheima.demo1;

import org.springframework.stereotype.Component;

/**
 * 组件注解:标记类
 * <bean id="userservice" class="com.itheima.demo1.UserserviceImpl">==>@Component(value="userservice")
 * @author Administrator
 *
 */
@Component(value = "userService")
public class UserService implements IUserService {

	@Override
	public void sayHello() {
		System.out.println("我是sayhello");
	}

}

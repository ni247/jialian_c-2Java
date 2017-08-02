package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.constant.CUserConstant;
import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.QueryRunnerUtils;

public class UserDaoImpl implements IUserDao {

	/**
	 * 用户注册
	 * @throws SQLException 
	 */
	@Override
	public void add(User use) throws SQLException {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?);";
		QueryRunnerUtils.qr.update(sql, use.getUid(), use.getUsername(), use.getPassword(), use.getName(),
				use.getEmail(), use.getTelephone(), use.getBirthday(), use.getSex(), use.getState(), use.getCode());
	}

	@Override
	public User getByCode(String code) throws Exception {
		String sql = "select * from user where code=?";
		return QueryRunnerUtils.qr.query(sql, new BeanHandler<>(User.class), code);
	}

	@Override
	public int updateByUser(User user) throws Exception {
		String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
		return QueryRunnerUtils.qr.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode(), user.getUid());
	}

	/**
	 * 用户登录
	 */
	@Override
	public User getByUsernameAndPws(String username, String password) throws Exception {
		String sql = "select * from user where username=? and password=? limit 1";
		return QueryRunnerUtils.qr.query(sql, new BeanHandler<>(User.class), username, password);
	}

}

package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.Dao.KeyWordDao;

public class KeyWordService {

	public List<Object> searchKW(String key) throws SQLException {
		return new KeyWordDao().searchKw(key);
	}

}

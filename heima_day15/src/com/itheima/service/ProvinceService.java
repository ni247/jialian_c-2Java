package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.Dao.ProvinceDao;
import com.itheima.domain.Province;

public class ProvinceService {

	public List<Province> getAllProvince() throws SQLException {
		return new ProvinceDao().getAllProvince();
	}

}

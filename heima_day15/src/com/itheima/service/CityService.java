package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.Dao.CityDao;
import com.itheima.domain.City;

public class CityService {

	public List<City> getCity(String pid) throws SQLException {
		return new CityDao().getCity(pid);
	}

}

package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Province;
import com.itheima.service.ProvinceService;

import net.sf.json.JSONArray;

/**
 * 查询所有省
 */
public class SelectPro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 查询省份数据
		List<Province> list = null;
		try {
			list = new ProvinceService().getAllProvince();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list != null && list.size() > 0) {
			JSONArray object = JSONArray.fromObject(list);
			// 写回去
			response.getWriter().print(object);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

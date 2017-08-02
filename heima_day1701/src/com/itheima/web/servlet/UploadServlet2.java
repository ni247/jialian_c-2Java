package com.itheima.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.itheima.utils.UploadUtils;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload2")
@MultipartConfig
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");

		// 获取文件上传组件
		String header = request.getPart("f").getHeader("content-disposition");
		// 获取文件的名称
		String filename = header.substring(header.indexOf("filename=") + 10, header.length() - 1);
		System.out.println("文件名称:" + filename);

		// 获取随机名称
		String uuidName = UploadUtils.getUUIDName(filename);
		System.out.println("随机名称:" + uuidName);

		// 获取文件存放目录
		String dir = UploadUtils.getDir(uuidName);
		System.out.println("文件目录为:" + dir);
		String realPath = getServletContext().getRealPath("/upload" + dir);
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println("文件目录:" + realPath);

		// 对拷流
		InputStream is = request.getPart("f").getInputStream();
		FileOutputStream os = new FileOutputStream(new File(file, uuidName));
		IOUtils.copy(is, os);
		os.close();
		is.close();
		request.getPart("f").delete();
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

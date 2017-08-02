package com.itheima.a_response.c_download;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.itheima.utils.DownloadUtils;

/**
 * 文件下载
 * @author Administrator
 *
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取文件路径
		String filePathTemp = request.getParameter("name");
		String filePath = new String(filePathTemp.getBytes("iso-8859-1"), "utf-8");
		// 设置文件的minetype
		// String mineType = getServletContext().getMimeType(filePath);
		// 设置下载头
		// response.setHeader("content-disposition","attachment;filename="+filePath);
		// 常见的浏览器名称使用utf-8

		response.setHeader("content-disposition",
				"attachment;filename=" + DownloadUtils.getName(request.getHeader("user-agent"), filePath));
		// 对拷流
		// 获取输入流
		InputStream resourceAsStream = getServletContext().getResourceAsStream("/download/" + filePath);
		// 获取输出流
		ServletOutputStream outputStream = response.getOutputStream();

		/*
		 * int len = -1; byte[] buff = new byte[1024]; while ((len =
		 * resourceAsStream.read(buff)) != -1) { outputStream.write(buff, 0,
		 * len); } outputStream.close(); resourceAsStream.close();
		 */
		// 使用架包做
		// ioutils
		// 需要注意jar包放在web-inf文件下的lib文件夹中,会自动引用
		IOUtils.copy(resourceAsStream, outputStream);
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

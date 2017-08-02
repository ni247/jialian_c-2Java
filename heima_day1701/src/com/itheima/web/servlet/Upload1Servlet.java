package com.itheima.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class Upload1Servlet
 */
@WebServlet("/upload1")
@MultipartConfig
public class Upload1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);

		String f = request.getParameter("f");
		System.out.println(f);

		Part part = request.getPart("f");
		System.out.println(part);
		String contentDis = part.getHeader("content-disposition");
		String fileName = contentDis.substring(contentDis.indexOf("filename=") + 10, contentDis.length() - 1);
		System.out.println(fileName);
		/* System.out.println(part. ); */
		InputStream is = part.getInputStream();
		FileOutputStream os = new FileOutputStream("d:/" + fileName);
		IOUtils.copy(is, os);
		os.close();
		is.close();

		System.out.println(part.getHeader("content-disposition"));
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

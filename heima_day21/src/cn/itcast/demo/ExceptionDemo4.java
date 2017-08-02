package cn.itcast.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo4 {
	public static void main(String[] args) {
		try {
			function();
		} catch (ParseException e) {
			// TODO: handle exception
		}
	}

	static void function() throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Date d = s.parse("2008-08-08");
		System.out.println(d);
	}
}

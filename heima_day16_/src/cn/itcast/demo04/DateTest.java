package cn.itcast.demo04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 计算出生了多少天
 */
public class DateTest {
	public static void main(String[] args) throws ParseException {
		function();
	}

	public static void function() throws ParseException {
		//获取出生日期
		String birthdayStr = new Scanner(System.in).next();
		//使用日期格式化子类
		//SimpleDateFormat
		Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
		if (birthDate.after(new Date())) {
			System.out.println("不正确");
			return;
		}

		//将两个日期转成毫秒值,Date类的方法getTime
		long birthdaySecond = birthDate.getTime();
		long todaySecond = new Date().getTime();
		long cha = todaySecond - birthdaySecond;
		//或者说在cha中判断.如果cha为负数,则输入过大

		//将毫秒值差转换为天数
		System.out.println(cha / 1000 / 60 / 60 / 24);
	}
}

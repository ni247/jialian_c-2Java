package cn.itcast.demo03;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo01 {
	public static void main(String[] args) {
		//		function();
		//		function_1();
		//		function_2();
		function_3();
	}

	/*
	 * Calendar类 getTime方法
	 * 将日历对象,转换为Date日期对象
	 */
	public static void function_3() {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		System.out.println(d);
	}

	/*
	 *  Calendar 类方法add
	 *  日历的偏移量,可以指定一个日历中的字段,进行整数的便宜
	 *  add(int field,int value)
	 */
	public static void function_2() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 280);
		System.out.println(c.get(Calendar.YEAR));
		//获取月份,需要加1.因为是0-11月
		System.out.println(c.get(Calendar.MONTH) + 1);
		//获取天数
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		//小时
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		//分钟
		System.out.println(c.get(Calendar.MINUTE));
		//秒
		System.out.println(c.get(Calendar.SECOND));
	}

	/*
	 *  Calendar类的set方法
	 *  设置日历
	 *  set(int field,int value)
	 *  field设置的是哪个日历字段
	 *  value 设置后的具体数值
	 *  
	 *  set(int year,int month,int day)
	 *  
	 */
	public static void function_1() {
		Calendar c = Calendar.getInstance();
		//需要注意的是月份
		//设置的10,实际上是11月.
		//获取的10,实际上11月
		c.set(2017, 10, 10);
		System.out.println(c.get(Calendar.YEAR));
		//获取月份,需要加1.因为是0-11月
		System.out.println(c.get(Calendar.MONTH) + 1);
		//获取天数
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		//小时
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		//分钟
		System.out.println(c.get(Calendar.MINUTE));
		//秒
		System.out.println(c.get(Calendar.SECOND));
	}

	/*
	 *  Calendar类的get方法
	 *  获取日历字段的值
	 *  int get(int)
	 *  参数int,获取的哪个日历字段
	 *  返回值,返回日历字段的具体数值
	 */
	public static void function() {
		Calendar c = Calendar.getInstance();
		//获取年份
		System.out.println(c.get(Calendar.YEAR));
		//获取月份,需要加1.因为是0-11月
		System.out.println(c.get(Calendar.MONTH) + 1);
		//获取天数
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		//小时
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		//分钟
		System.out.println(c.get(Calendar.MINUTE));
		//秒
		System.out.println(c.get(Calendar.SECOND));

	}
}

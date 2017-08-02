package cn.itcast.demo02;

import java.util.Date;

/*
 *  时间和日期类
 *    java.util.Date
 *    
 *    
 *  毫秒概念:1000毫秒=1秒
 *  毫秒的0点
 *  System.currentTimeMillis() 返回long类型参数
 *  获取当前日期的毫秒值
 *  
 *  时间原点: 1970年1月1日.0点0分0秒.作为java时间的起点 也就是0毫秒点
 *  
 *  重要:时间和日期的计算,必须依赖毫秒值
 */
public class DateDemo {
	public static void main(String[] args) {
		//		Date d = new Date();
		//		System.out.println(d);
		function_1();
		function_2();
		function_3();
	}

	/*
	 *  Date类方法setTime(long)传递毫秒值
	 *  将日期对象,设置到指定毫秒值上
	 *  毫秒值转换日期对象
	 */
	public static void function_3() {
		Date d = new Date();
		d.setTime(0);
		System.out.println(d);
	}

	/*
	 *  Date类方法getTime() 返回值long
	 *  返回的是毫秒值
	 */
	public static void function_2() {
		Date d = new Date();
		d.getTime();
		System.out.println(d.getTime());
	}

	/*
	 *  Date类的long参数的构造方法
	 *  Date(long) 表示毫秒值
	 *  传递毫秒值,将毫秒值转成对应的日期对象
	 */
	public static void function_1() {
		Date date = new Date(0);
		System.out.println(date);
	}

	public static void function() {
		Date date = new Date();
		System.out.println(date);
	}
}

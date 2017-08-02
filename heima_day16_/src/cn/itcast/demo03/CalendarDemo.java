package cn.itcast.demo03;

import java.util.Calendar;

/*
 *  java中的日历类  java.util.Calendar
 *  抽象类,不能直接创建子类对象
 *  
 *  Calendar类写了静态方法
 */
public class CalendarDemo {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c);
	}
}

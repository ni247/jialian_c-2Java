package cn.itcast.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *  DateFormat类方法parse
 *  将字符串解析为日期对象
 *  Date parse(String s)将字符串编程日期对象
 */
public class SimpleDateFormatDemo01 {
	public static void main(String[] args) throws ParseException {
		function();
	}

	/*
	 *  将一个字符串转换为Date对象
	 *  DataFormat类方法 parse
	 *  步骤:
	 *    1.创建SimpleDazteFormat的对象
	 *    构造方法中,指定日期模式
	 *    2.子类对象,调用方法parse 传递String,返回Date
	 *    
	 *  需要注意的是事件和日期的模式 ,必须和字符串中的事件日期完全匹配  
	 *  
	 *  需要注意抛异常的事情.main中也要抛异常的
	 */
	public static void function() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("2001-11-01");
		System.out.println(d);
	}
}

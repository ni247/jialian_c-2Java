package cn.itcast.demo02;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *  对日期进行格式化(自定义)
 *    对日期格式化的类 java.text.DateFormat 抽象类,有普通方法,也有抽象方法
 *    实际使用的是他的子类 java.text.SimpleDateFormat 可以使用父类普通方法,重写了抽象方法
 */
public class SimpleDateFormatDemo {
	public static void main(String[] args) {
		function();
	}

	/*
	 *  如何对日期格式化
	 *  步骤1:
	 *     1.创建SimpleDateFormat对象
	 *     在类构造方法中,写入字符串的日期格式
	 *     2.SimpleDateFormat调用方法,format对日期进行格式化
	 *       String format(Date date) 传递日期对象,返回字符串
	 *     日期模式: D 年中的天数 S毫秒值
	 *     y 年份 M月份 d 月中的天数 HH小时 mm小时中的分钟 ss秒
	 */
	public static void function() {
		/* 
		 * 需要注意的如果你写的格式不够,java可能给你补全
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
	}
}

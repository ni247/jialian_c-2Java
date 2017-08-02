package cn.itcast.demo02;

/*
 *  String类特点:
 *    一切都是对象,字符串事物 ""也是对象
 *    类是描述事物,String类,描述字符串对象的模板
 *    
 *    字符串是一个常量,一旦创建,不能改变
 *    这里的改变指的是字符串本身不改变,改变的是内存地址
 *    也就是说.每次申明一个String变量,都会开辟出新的堆内存.
 *    
 *    定义一个一维数组.[] 可以写变量名
 *    
 *    堆里面有一块小区域.叫做常量池.存的是常量
 *    
 *    引用类型== 比较的是内存地址
 *    String类继承Object,重写了父类的方法equals,简历了字符串自己的比较方法.
 *    字符串中的每个字符是否相同
 */
public class StringDemo {
	public static void main(String[] args) {
		String str = "itcast";
		// final char s[];
		String str1 = new String("itcast");
		System.out.println(str == str1);
		System.out.println(str.equals(str1));

	}
}

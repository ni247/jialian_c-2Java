package cn.itcast.demo06;

/*
 * 内部类调用格式
 * 外部类.内部类 类名=new 外部类().new 内部类();
 * 先创建外部类对象,在创建内部类对象.和c#不相同.需要注意
 * 外部类.内部类 类名=new 外部类().new 内部类();
 */
public class Test {
	public static void main(String[] args) {
		Outer.Inner c = new Outer().new Inner();
		c.show();
	}
}

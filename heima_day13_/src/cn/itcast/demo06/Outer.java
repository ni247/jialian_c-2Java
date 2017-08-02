package cn.itcast.demo06;

/*
 * 内部类的定义
 *   将内部类,定义在了外部的成员位置
 * 类名 outer,内部类名inner
 */
public class Outer {
	// 外部类成员位置,定义内部类
	// 内部类也是单独会有一个class文件,命名规则为外部类名$内部类名
	public class Inner {
		public void show() {
			System.out.println("显示内部类方法");
		}
	}
}

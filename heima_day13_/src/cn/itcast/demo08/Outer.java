package cn.itcast.demo08;

/*
 *  局部内部类
 *    将一个类,定义在方法中
 *    
 *    外面生成的名字为Outer$1Inner
 */
public class Outer {
	public void out() {
		class Inner {
			public void inner() {
				System.out.println("局部内部类方法");
			}
		}
		Inner i = new Inner();
		i.inner();
	}

	public void out2() {
	/*	class Inner {
			public void inner() {
				System.out.println("我也是个局部内部类");
			}
		}*/
	}
}

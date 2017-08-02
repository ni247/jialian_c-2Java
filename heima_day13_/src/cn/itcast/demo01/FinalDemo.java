package cn.itcast.demo01;

/*
 * final 意思为最终,不可变.final是个修饰符,可以用来修饰类,类的成员,以及局部变量
 * 
 * F3查看源代码
 */
//修饰类
public final class FinalDemo {
	/*
	 * 修饰成员变量时,需要特别注意,必须要赋默认值.不然初始化后一直是初始值.错误 接上面,使用构造方法对他进行赋值也可以
	 * 必须保证:被final修饰的成员变量,只能被赋值一次 必须保证,如果没有对final成员变量赋初始,在每个构造器中都必须对成员变量进行赋值
	 * 构造方法,是创建方法中的事情,可以为成员变量赋值 setXXX方法,创建对象之后的时候,不能为final赋值
	 */
	private final String name;

	public FinalDemo() {
		name = "5";
	}

	public FinalDemo(int d) {
		name = "55";
	}

	public String getName() {
		return name;
	}

	// 修饰成员函数
	public final void show() {
		// 修饰局部变量
		// final int a = 3;
	}
}

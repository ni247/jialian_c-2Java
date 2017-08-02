package cn.itcast.demo06;

/*
 * 定义Andriod类,继承开发人员类
 * 重写抽象方法
 * 
 * 抽象类和抽象方法必须被abstract修饰
 * 抽象方法必须在抽象类中
 * 抽象类不可以直接创建对象.因为调用抽象方法没有意义
 * 继承抽象类的类必须重写抽象方法,如果不重写,那他还是抽象类
 */
public class Andorid extends Develop {

	@Override
	protected void work() {
		System.out.println("安卓工程师在开发了");
		System.out.println();
	}

}

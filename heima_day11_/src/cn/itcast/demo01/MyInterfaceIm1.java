package cn.itcast.demo01;

/*
 * 定义类,实现接口,重写类中的抽象方法
 * 
 * 关键字implements-工具
 * class 类 implements 接口{
 * 重写接口中的抽象方法
 * }
 */
public class MyInterfaceIm1 implements MyInterface {

	@Override
	public void function() {
		System.out.println("重写类的function方法");
	}

	@Override
	public void getSum() {
		System.out.println("重写getSum方法");
	}

}

package cn.itcast.demo03;

/*
 * 多实现,直接A,B
 * 作为实现类,C必须全部重写两个接口的所有抽象方法,才能建立c类的对象
 * 
 * 需要特别注意的是,如果继承的两个接口具有不同的签名的同名方法.
 * 只能放弃一个接口实现
 * 
 * c类在继承一个类的同时,可以实现多个接口
 * 需要特别注意的.中间没有逗号
 * 
 * 
 */
public class C extends D implements A, B {

	@Override
	public void a() {
	}

	@Override
	public void d() {
	}

}

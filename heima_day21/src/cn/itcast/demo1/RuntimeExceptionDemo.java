package cn.itcast.demo1;

/*
 *  异常分为编译异常和运行时异常
 *    编译异常:调用了抛出异常的方法,
 *    运行异常,抛出的异常是RuntimeException类,或者是他的子类
 *    
 *  运行异常的特点:
 *    方法内部抛出的异常是运行异常,new XXXException
 *    方法的声明上,不需要throws语句,调用者,不需要处理
 *    
 *    这样的设计原因:
 *       运行异常不太会发生,如果发生,需要程序人员修改源代码(程序员写的代码)
 *       因为运行一旦发生,后面的代码没有执行的意义
 */
public class RuntimeExceptionDemo {
	public static void main(String[] args) {
		//		function();
		System.out.println(function_1(-1));
	}

	static double function_1(double r) {
		//这种情况下,可以直接使用运行时异常.因为没办法运行了.运行也没有意义了
		if (r < 0)
			throw new RuntimeException("圆形不存在");
		return r * Math.PI;
	}

	public static void function() {
		throw new ArrayIndexOutOfBoundsException();
	}
}

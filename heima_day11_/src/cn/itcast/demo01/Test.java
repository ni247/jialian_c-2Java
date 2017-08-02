package cn.itcast.demo01;

/*
 * 接口也是不能实例化.只能创建实现类的对象
 */
public class Test {
	public static void main(String[] args) {
		MyInterfaceIm1 my = new MyInterfaceIm1();
		my.function();
		my.getSum();
	}
}

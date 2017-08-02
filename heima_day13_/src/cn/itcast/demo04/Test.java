package cn.itcast.demo04;

/* 多态
 *    多态调用中,编译看谁,运行就看谁
 *    编译都看=左边的父类,父类有则编译成功,父类没有则编译失败
 *    运行静态方法,会运行父类中的静态方法
 *    运行实例方法,会运行子类的重写方法(如果有的话)
 *    成员变量,编译运行都是父类
 *    
 */
public class Test {
	public static void main(String[] args) {
		// Fu f = new Zi();
		// System.out.println(f.i);
		System.out.println(Fu.i);
		System.out.println(Zi.i);
		// 调用还是父类的静态方法,原因.静态属于类,不属于对象-切记
		// 对象的多态性,静态和对象无关,父类的引用,静态方法
		// f.show();
	}
}

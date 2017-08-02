package cn.itcast.demo06;

/*
 * 重写父类的抽象方法
 * 
 * 方法:去掉abstract修饰符,加上方法主体
 */
public class javaEE extends Develop {

	@Override
	protected void work() {
		System.out.println("JavaEE工程师在开发B/s软件");
	}
	
}

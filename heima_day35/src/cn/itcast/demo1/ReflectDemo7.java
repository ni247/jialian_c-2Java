package cn.itcast.demo1;

/*
 *  反射获取有参数的成员方法并执行
 */
public class ReflectDemo7 {
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("cn.itcast.demo1.Person");
		//同6
		System.out.println(c);
	}
}

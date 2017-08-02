package cn.itcast.demo1;

/*
 * 反射获取构造方法并运行,有快捷方式
 * 有前提:
 *   被反射的类,必须有空参构造方法
 *   权限不能为private
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("cn.itcast.demo1.Person");

		//快捷方式 Class类中定义方法,方法的返回值为泛型
		//直接创建被反射对象实例
		Object t = c.newInstance();
		System.out.println(t);
	}
}

package cn.itcast.demo01;

/*
 * 测试类,调用继承了Emolpyee的Developer,
 * 发现已经有父类中才有的name和work方法
 * 这里的修饰符都是public.成员修饰符都是public
 * 如果改为private,则name不可见
 * 同时能调用父类和子类的成员
 * 
 * 继承的好处:
 * 1.继承的出现提高了代码的复用性,提高了软件开发效率
 * 2.继承的出现让类与类产生了关系,提供了多台的前提
 * 
 * java只允许类有单继承,注意,和c#不相同.
 * 主要是为了安全考虑,继承的类中如果有相同的成员名称,则子类不能判断
 * 调用的是哪个方法.这样子存在安全问题
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建研发员工的对象
		Developer d = new Developer();
		System.out.println(d.name);
		d.name = "哒哒";
		System.out.println(d.name);
		d.work();
		System.out.println(d.age);

		// 创建维护员工类的对象
		WeiHu w = new WeiHu();
		w.name = "李四";
		w.print();
		w.work();
	}
}

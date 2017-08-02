package cn.itcast.demo06;

public abstract class Develop {
	/*
	 * 抽象方法 不清楚方法主体. 使用abstract关键字修饰符 抽象的方法必须存在抽象类中.同c#
	 * 抽象方法不能被private修饰,因为本身抽象类就是就是继承,抽象方法就是用来重写的 不能创建的原因.因为new之后,也没办法
	 * .work运行.没有方法主体.
	 * 
	 * 抽象类的使用:定义类继承抽象类,重写抽象方法.
	 */
	protected abstract void work();
}

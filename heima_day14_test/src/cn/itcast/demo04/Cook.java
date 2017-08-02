package cn.itcast.demo04;

/*
 * 注意,可以使用super() 调用父类的构造函数
 */
public class Cook extends Employee implements VIP {
	public Cook() {
	}

	public Cook(String name, int id) {
		super(name, id);
	}

	@Override
	public void doVip() {
		System.out.println("厨师在做vip");
	}

	@Override
	public void work() {
		System.out.println("厨师在工作");
	}

}

package cn.itcast.hotel;

public class Server extends Employee implements VIP {

	@Override
	public void doVip() {
		System.out.println("服务员的特殊服务");
	}

	@Override
	public void work() {
		System.out.println("服务员在干活");
	}

	public Server() {
	}

	public Server(String name, int id) {
		super(name, id);
	}

}

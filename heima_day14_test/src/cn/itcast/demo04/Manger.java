package cn.itcast.demo04;

public class Manger extends Employee {
	private double money;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public void work() {
		System.out.println("经理在工作");
	}

	public Manger() {
	}

	public Manger(String name, int id, double money) {
		super(name, id);
		this.money = money;
	}

}

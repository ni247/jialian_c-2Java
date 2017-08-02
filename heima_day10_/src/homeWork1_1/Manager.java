package homeWork1_1;

public class Manager extends Person {
	private double jiangjin;

	public double getJiangjin() {
		return jiangjin;
	}

	public void setJiangjin(double jiangjin) {
		this.jiangjin = jiangjin;
	}

//	@Override
	public void work() {
		System.out.println("姓名" + getName() + "工号" + getId() + "工资"
				+ getMoney() + "奖金" + getJiangjin());
	}
}

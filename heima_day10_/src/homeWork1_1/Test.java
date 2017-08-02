package homeWork1_1;

public class Test {
	public static void main(String[] args) {
		Manager m = new Manager();
		m.setId("1");
		m.setJiangjin(1000);
		m.setMoney(100000);
		m.setName("大网");
		m.work();
		Develop d = new Develop();
		d.setId("2");
		d.setMoney(100);
		d.setName("历史上");
		d.work();
	}
}

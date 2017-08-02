public class TestPhone_1 {
	public static void main(String[] args) {
		// 创建手机类型变量
		Phone p1 = new Phone();

		// 再次创建手机类型变量
		Phone p2 = new Phone();

		p1.color = "їɫ";
		p1.brand = "Ըؓ";
		p1.size = 4.5;

		p2.brand = "۪Ϊ";
		System.out.println(p1.brand);
		System.out.println(p2.brand);
	}
}
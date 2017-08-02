import java.util.Scanner;

public class HomeWork_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的工龄");
		int age = sc.nextInt();
		System.out.println("请输入你的基本工资");
		int price = sc.nextInt();
		System.out.println("你的工龄为" + age + "年,基本工资为" + price + "元");
		if (age >= 10 && age < 15)
			price += 5000;
		else if (age >= 5 && age < 10)
			price += 2500;
		else if (age >= 3 && age < 5)
			price += 1000;
		else if (age >= 1 && age < 3)
			price += 500;
		else if (age >= 0 && age < 1)
			price += 200;
		else
			System.out.println("出现错误");
		System.out.println("最后工资为" + price + "元");

	}
}
import java.util.Scanner;

public class HomeWork_1 {
	public static void main(String[] args) {
		// 键入学生成绩
		char c;
		while (true) {
			System.out.println("请输入学生成绩");
			int studentScore = new Scanner(System.in).nextInt();
			if (studentScore >= 90 && studentScore <= 100) {
				c = 'A';
				break;
			} else if (studentScore >= 80 && studentScore < 90) {
				c = 'B';
				break;
			} else if (studentScore >= 70 && studentScore < 80) {
				c = 'C';
				break;
			} else if (studentScore >= 60 && studentScore < 70) {
				c = 'D';
				break;
			} else if (studentScore >= 0 && studentScore < 60) {
				c = 'E';
				break;
			} else {
				System.out.println("数值超出范围,请重新输入！");
			}
		}
		switch (c) {
		case 'A':
			System.out.println("A");
			break;
		case 'B':
			System.out.println("B");
			break;
		case 'C':
			System.out.println("C");
			break;
		case 'D':
			System.out.println("D");
			break;
		case 'E':
			System.out.println("E");
			break;
		default:
			System.out.println("出现错误！");
		}
	}
}
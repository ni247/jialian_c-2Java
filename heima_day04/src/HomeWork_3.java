import java.util.Scanner;

public class HomeWork_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] inputNum = new int[3];
		System.out.println("请输入3个整数");
		inputNum[0] = sc.nextInt();
		inputNum[1] = sc.nextInt();
		inputNum[2] = sc.nextInt();
		int minNum = inputNum[0];
		// int[] newNum=new int[3];
		// 找出最小的
		// 冒泡排序做法
		for (int i = 0; i < inputNum.length; i++) {
			for (int j = i; j != 0; j--) {
				if (inputNum[j] < inputNum[j - 1]) {
					minNum = inputNum[j - 1];
					inputNum[j - 1] = inputNum[j];
					inputNum[j] = minNum;
				}
			}
		}
		for (int i = 0; i < inputNum.length; i++)
			System.out.println(inputNum[i]);

	}
}
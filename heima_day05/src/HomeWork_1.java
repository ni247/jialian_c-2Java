import java.util.Scanner;

public class HomeWork_1 {
	public static void main(String[] args) {
		printMultiTable();
	}

	static Scanner sc = new Scanner(System.in);

	public static double getSum() {
		System.out.println("请输入两个数据");
		int a = sc.nextInt();
		double b = sc.nextDouble();
		return a + b;
	}

	public static boolean judgeEqual() {
		System.out.println("请输入两个数据");
		int a = sc.nextInt();
		double b = sc.nextDouble();
		return a == b ? true : false;
	}

	public static double getMax() {
		System.out.println("请输入两个数据");
		int a = sc.nextInt();
		double b = sc.nextDouble();
		return a > b ? a : b;
	}

	public static void printRectangle() {
		System.out.println("请输入两个数据");
		int width = sc.nextInt();
		int height = sc.nextInt();
		String space = "";
		for (int i = 0; i < width - 2; i++) {
			space += " ";
		}
		for (int i = 0; i < height; i++) {
			if (i == 0 || i == height - 1) {
				for (int j = 0; j < width; j++) {
					System.out.print("-");
					if (j == width - 1)
						System.out.println();
				}
			} else
				System.out.println("|" + space + "|");
		}
	}

	public static void printMultiTable() {
		System.out.println("请输入两个数据");
		int width = sc.nextInt();
		int height = sc.nextInt();
		for (int i = 1; i < height + 1; i++) {
			for (int j = 1; j < width + 1; j++) {
				System.out.print(i * j + "  ");
			}
			System.out.println();
		}
	}

	public static void PrintRecMJ() {
		System.out.println("请输入两个数据");
		int width = sc.nextInt();
		int height = sc.nextInt();
		System.out.println(width * height);
	}
}
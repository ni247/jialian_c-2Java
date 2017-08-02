package HomeWork;
/*
 * static 同c# .直接使用静态方法.不需要实例化 
 */
public class Demo1 {
	public static double getSum(double a, double b) {
		return a + b;
	}

	public static boolean isEqual(double a, double b) {
		return a == b ? true : false;
	}

	public static void print99() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
}

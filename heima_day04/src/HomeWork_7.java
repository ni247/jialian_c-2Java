import java.util.Scanner;

public class HomeWork_7 {
	public static void main(String[] args) {
		String[] strs = { "星期一", "星期二", "星期三", "星期四", "星期五", "周六", "周末" };
		Scanner sc = new Scanner(System.in);
		System.out.println(strs[sc.nextInt() - 1]);
	}
}
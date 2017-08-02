/*这里的调试.需要特别注意.右上角切换界面*/
public class Demo2 {

	public static void main(String[] args) {
		getSum(4);
	}

	public static void getSum(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				sum += i;
		}
		System.out.println(sum);
	}
}

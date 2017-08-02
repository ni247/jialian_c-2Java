public class OneWork {
	public static void main(String[] args) {
		int sum = 0;
		// i++ 改成i+=2 下面就不需要判断.这种运行效率更高
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 1)
				sum += i;
		}
		System.out.println(sum);
	}
}
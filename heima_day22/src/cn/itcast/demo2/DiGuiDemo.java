package cn.itcast.demo2;

/*
 *  递归一定要有出口,必须可以让程序停下
 *  抵扣不能过多.
 *  构造函数中不能递归
 */
public class DiGuiDemo {
	public static void main(String[] args) {

	}

	static int getSum(int n) {
		if (n == 1)
			return 1;
		return n + getSum(n - 1);
	}
}

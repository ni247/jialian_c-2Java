package cn.itcast.demo3;

/*
 *  jdk1.5新特性:方法的可变参数
 *  前提:方法参数数据类型确定.参数个数任意
 */
public class VarArgumentsDemo {

	public static void main(String[] args) {
		getSum(1, 23, 4, 5);
	}

	/*
	 *  可变参数的注意事项
	 *  一个方法中可变参数只能有一个
	 *  1.因为如果有多个可变参数,则在调用时无法分辨是哪个参数
	 *  2.可变参数必须卸载参数列表的最后一位,传参无法分辨了
	 */
	public static void function(int... a) {

	}

	/*
	 *  其实这时候本质已经是数组了
	 */
	static void getSum(int... a) {
		int sum = 0;
		System.out.println(a.length);
		for (int c : a) {
			sum += c;
			System.out.println(sum);
		}
	}
}

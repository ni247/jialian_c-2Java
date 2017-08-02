/*
要求:已知两个数.计算最大值

注意:三元表达式,必须有结果.返回值.没有返回值,直接执行例如out.println()是不行的
 */
public class ifElseDemo_1 {
	public static void main(String[] args) {
		int a = 3;
		int b = 44;
		boolean bb = a > b ? true : false;
		System.out.println(bb);
		if (a > b)
			System.out.println(true);
		else
			System.out.println(false);

		int c = a > b ? a : b;
		System.out.println(c);
	}

}
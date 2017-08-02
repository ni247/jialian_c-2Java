/*
continue关键字
作用:在循环中,终止本次循环,开始下一次循环
同c#

 */
public class BreakDemo_1 {
	public static void main(String[] args) {
		int i = 0;
		do {
			i++;
			if (i % 2 == 0)
				continue;
			System.out.println(i);
		} while (true);
	}
}
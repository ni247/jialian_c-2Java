/*
break 关键字:跳出循环.
同c# 
 */
public class BreakDemo {
	public static void main(String[] args) {
		int i = 1;
		do {
			if (i == 3)
				break;
			System.out.println(i++);
		} while (true);
	}
}
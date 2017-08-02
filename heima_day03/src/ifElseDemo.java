/*
同c# 单语句可以直接不要大括号
 */
import java.util.Random;

public class ifElseDemo {
	public static void main(String[] args) {
		int grade = new Random().nextInt(100) + 1;
		if (grade > 80)
			System.out.println(grade + "成绩是优");
		else if (grade > 70)
			System.out.println(grade + "成绩是良");
		else if (grade > 60)
			System.out.println(grade + "成绩是中");
		else
			System.out.println(grade + "成绩是差");
	}
}

/*
注意 util
ramdom也需要导入
import java.util.Scanner;
Scanner sc=new Scanner(System.in);
int d= sc.nextInt();
 */
import java.util.Scanner;
import java.util.Random;

public class caishuziyouxi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int flag;
		while (true) {
			BeginGame();
			System.out.println("恭喜你猜对了");
			System.out.println("是否继续猜,输入1继续猜");
			flag = sc.nextInt();
			if (flag != 1)
				break;
		}
	}

	public static void BeginGame() {
		System.out.println("已经生成了一个随机数,请猜");
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int num = ran.nextInt(100) + 1;
		int inputNum;
		while (true) {
			inputNum = sc.nextInt();
			if (inputNum > num)
				System.out.println("大了");
			else if (inputNum < num)
				System.out.println("小了");
			else
				break;
		}
	}
}
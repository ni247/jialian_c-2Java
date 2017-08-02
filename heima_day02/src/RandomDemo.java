/*
java中已由的引用类型,random类,作用,产生随机数
步骤:
1.导入包 import java.util.Random
2.公式:创建出Random类型的变量
3.变量:调用random类中的变量,产生随机数
nextInt(值)
则产生的随机数在0-值之间.不包含值,包含0
想产生1-100 ran.nextInt(100)+1

nextDouble()
不能输入值.产生的随机数范围为0.0-1.0之间.不会到1.0
 */
import java.util.Random;

public class RandomDemo {
	public static void main(String[] args) {
		Random ran = new Random();
		for (int j = 0; j < 100; j++) {
			double i = ran.nextDouble();
			System.out.println(i);
		}
	}
}
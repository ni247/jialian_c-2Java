/*
  引用数据类型.介绍一个类 Scanner
  java中已经存在的.是sun公司为我们已经做好的类.使用它定义引用数据类型变量.和基本类型变量区别
  int a=1;
  格式
  类型 变量名=new 类型();
  调用该类实例,调用他的功能
  每个引用类型,都有自己的功能.
  变量名.功能名字()
  
  Scanner类,作用,让我在命令行中,接收键盘的键入
  1.导入包.指明类所在的文件夹.关键字 import java文件夹util文件夹.不要忘记封号
  2.公式.创建出Scanner类型变量
  3.变量.使用Scanner类中的功能
  
 */
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		// 创建Scanner类变量
		Scanner sc = new Scanner(System.in);
		// nextInt() 接收键盘输入,保证输入的是整数
		int i = sc.nextInt();
		System.out.println(i);
		String s = sc.next();
		System.out.println(s);
	}

}
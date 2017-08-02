//特别注意,方法命名,首字母小写
//Random和ArrayList都需要导包
//while是小写的
//属性是在方法外面类里面写的

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class anli {
	public static ArrayList<Student> arrStudent = new ArrayList<Student>();

	public static void main(String[] args) {
		addStudent("张三", 14);
		addStudent("李四", 14);
		addStudent("王五", 14);
		beginJiaoRen();
	}

	public static void addStudent(String name, int age) {
		Student stu = new Student();
		stu.name = name;
		stu.age = age;
		arrStudent.add(stu);
		// arrStudent.add(new Student(){name=name;age=age;});
	}

	// 返回随机索引
	public static int getRandomIndex() {
		Random ran = new Random();
		return ran.nextInt(arrStudent.size());
	}

	// 打印指定索引的学生
	public static void printStudent(int index) {
		if (index > arrStudent.size() - 1) {
			System.out.println("索引有误");
			return;
		} else {
			Student stu = arrStudent.get(index);
			System.out.println("点到名的学生姓名为为:" + stu.name + ",年龄为" + stu.age);
		}
	}

	public static void beginJiaoRen() {
		int index = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			index = getRandomIndex();
			printStudent(index);
			System.out.println("请输入1或0,决定是否继续叫号 ");
			if (sc.nextInt() == 1)
				return;
		}
	}
}
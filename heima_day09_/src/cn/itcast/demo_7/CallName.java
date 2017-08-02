package cn.itcast.demo_7;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CallName {
	/*
	 * 随机点名器案例 1.创建集合,将student对象存储到集合中 2.总览所有学生的信息 将存储到集合中的Strdent对象遍历出来 3.随机学生
	 * 随机数,索引,到集合中去查找元素
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Student> arrStu = new ArrayList<Student>();
		Student[] stusM = new Student[5];

		stusM[0] = getStudent("张三", 10);
		stusM[1] = getStudent("王五", 11);
		stusM[2] = getStudent("赵四", 10);
		stusM[3] = getStudent("李二", 11);
		stusM[4] = getStudent("大拿", 10);
		addStudent(arrStu, stusM);
		Scanner sc = new Scanner(System.in);
		int nextI;
		int index;
		while (true) {
			index = getRandomIndex(arrStu);
			printStudent(arrStu, index);
			System.out.println("输入1继续点名");
			nextI = sc.nextInt();
			if (nextI != 1)
				return;
		}
	}

	public static int getRandomIndex(ArrayList<Student> arrStu) {
		Random ran = new Random();
		return ran.nextInt(arrStu.size());
	}

	public static void printStudent(ArrayList<Student> arrStu, int index) {
		if (arrStu.size() > index) {
			Student stu = arrStu.get(index);
			System.out.println("点到名的学生年龄为" + stu.getAge() + ",名字:"
					+ stu.getName());
		} else
			System.out.println("未找到该学生");
	}

	public static void addStudent(ArrayList<Student> arrStu, Student[] stu) {
		for (int i = 0; i < stu.length; i++) {
			arrStu.add(stu[i]);
		}
	}

	public static Student getStudent(String name, int age) {
		Student stu = new Student();
		stu.setAge(age);
		stu.setName(name);
		return stu;
	}

}

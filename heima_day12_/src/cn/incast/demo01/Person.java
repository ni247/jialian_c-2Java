package cn.incast.demo01;

/*
 * 构造器,new的同时赋值,给对象的属性初始化赋值
 * 
 * 构造方法的定义格式
 *  权限 方法名(参数列表){
 *  
 *  }
 *  方法名同类名
 */
public class Person {
	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("new的时候运行");
	}

	public Person() {
		System.out.println("我是显示申明的无参构造函数");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

package cn.itcast.hotel;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *  将酒店员工,厨师,服务员,经理,分别存储到3个集合中.
 *  定义方法,可以同时遍历3个集合.遍历同时,可以调用工作方法
 *  
 *  限定 ? extends 类名  限制的是父类,上限限定,可以传递类,也可以传递他的子类
 *     ? super 类名 限制的子类,下限限定,可以传递类,也可以传递他的父类
 */
public class GenericTest {
	public static void main(String[] args) {
		ArrayList<Cook> arrCook = new ArrayList<Cook>();
		ArrayList<Manger> arrManger = new ArrayList<Manger>();
		ArrayList<Server> arrServer = new ArrayList<Server>();
		arrCook.add(new Cook("大厨", 11));
		arrManger.add(new Manger("经理", 12, 1000));
		arrServer.add(new Server("服务员", 123));
		iterator(arrCook);
		iterator(arrManger);
		iterator(arrServer);
		//		ArrayList<String> str = new ArrayList<String>();
	}

	/*
	 *  这样子无法调用work方法. ?取出来的是object.无法调用想要的共有成员
	 *  
	 *  这里可以强制转换为Employee,但是会相当有问题.只能限于继承与Employee的.
	 */
	public static void iterator(ArrayList<? extends Employee> arr) {
		Iterator<? extends Employee> p = arr.iterator();
		while (p.hasNext()) {
			Employee e = p.next(); //这里可以直接隐式转换.父类 变量=子类 变量;
			//不需要强制转换
			//			System.out.println(e.work());
			e.work();
		}
	}

}

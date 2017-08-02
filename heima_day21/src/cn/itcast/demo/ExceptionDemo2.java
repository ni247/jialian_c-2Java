package cn.itcast.demo;

import java.util.NoSuchElementException;

/*
 *  try
 *  catch 细节
 *  catch小括号中,写的是异常类的类名
 *  
 *  平级异常:抛出的异常类之间,没有继承关系,没有顺序
 *  
 *  上下级关系的异常
 *  超类必须在下面.因为超类在上面就捕获了异常,所以必须在下面
 *  下面的异常永远不会捕获到
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		try {

		} catch (Exception e) {
			System.exit(0);
		} finally {
			System.out.println("fff");
		}
	}

	static void funtion(int a) throws Exception {
		if (a == 0)
			throw new NullPointerException();
		if (a == 1)
			throw new NoSuchElementException();
		if (a == 2)
			throw new Exception();
	}
}

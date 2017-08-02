package cn.itcast.demo;

/* 
 *  异常中的关键字
 *   throw,在方法内部,抛出异常
 *   throw 后面,必须写new 对象.必须是异常的对象,必须是Exception,子类
 *   
 *   方法中申明异常关键字
 *     throws 用于在方法的申明上,表明此方法,可能出现异常
 */
public class ExceptionDemo {
	public static void main(String[] args) throws Exception {
		int[] a = {};
		System.out.println(getArray(a));
	}

	/*
	 * 方法需要对参数进行合法性判断.
	 */
	static int getArray(int[] arr) throws Exception {
		if (arr == null)
			//抛出异常的形式,告诉调用者.
			//关键字 throw
			throw new Exception("传递数组不存在");
		if (arr.length == 0)
			throw new Exception("数组中没有元素");

		//当length为0时,数组也越界
		int i = arr[arr.length - 1];
		return i * 2;
	}
}

package cn.itcast.demo2;

public class SystemDemo {
	public static void main(String[] args) {
		function_4();
	}

	/*
	 *  System类方法,复制数组
	 *  object src,源数组
	 *  int srcPos ,数组源的起始索引
	 *  object dest,复制后的目标数组
	 *  int destPos,目标数组起始索引
	 *  int length,复制长度
	 *  
	 *  注意,不扩容数组
	 */
	public static void function_4() {
		int[] src = { 11, 22, 33, 44, 55, 66 };
		int[] desc = { 77, 99, 99, 0 };
		System.arraycopy(src, 1, desc, 1, 2);
		for (int i = 0; i < desc.length; i++) {
			int j = desc[i];
			System.out.println(j);
		}
	}

	/*
	 *  获取当前操作系统的属性
	 *  static properties getProperties()
	 */
	public static void function_3() {
		System.out.println(System.getProperties());
	}

	/*
	 *  回收数据
	 */
	public static void function_2() {
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		System.gc();
	}

	/*
	 *  获取系统当前毫秒值
	 *  static long currentTimeMillis()
	 *  对程序执行时间测试
	 *  
	 *  这块并不是虚拟机智能,只是10000运行的速度太快了,0
	 *  
	 *  相当于一个计时器
	 */
	public static void function() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	/*
	 *  退出虚拟机,所有程序全停止
	 *  static void exit(int)
	 *  0表示正常停止,非0表示异常停止
	 */
	public static void function_1() {
		System.exit(0);
	}
}

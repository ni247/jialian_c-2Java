package cn.itcast.demo3;

/*
 *   数学计算的工具类
 *   java.lang.Math静态方法组成
 */
public class MathDemo {
	public static void main(String[] args) {
		function_6();
	}

	/*
	 *  static double round(double d)
	 *  获取参数的四舍五入,取整数
	 */
	public static void function_6() {
		double d = Math.round(5.499);
		System.out.println(d);
	}

	/*
	 *  static double random() 返回随机数0.0-1.0之间
	 *  来源,也是Random类 
	 */
	public static void function_5() {
		for (int i = 0; i < 10; i++) {
			double d = Math.random();
			System.out.println(d);
		}
	}

	/*
	 * static double pow (double a,double b)
	 * a的b次方
	 */
	public static void function_4() {
		System.out.println(Math.pow(2, 3));
	}

	/*
	 * static double floor(double d)
	 * 返回小于或者等于参数d的最大整数
	 */
	public static void function_3() {
		System.out.println(Math.floor(4.5));
	}

	/*
	 * static double ceil(double d)
	 * 返回大于或者等于参数d的最大整数
	 */
	public static void function_2() {
		System.out.println(Math.ceil(4.5));
	}

	/*
	 *  static int abs(int i)
	 *  获取参数的绝对值
	 */
	public static void function() {
		int i = Math.abs(-10);
		System.out.println(i);
	}
}

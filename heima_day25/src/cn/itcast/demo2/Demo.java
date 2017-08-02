package cn.itcast.demo2;

/*
 *  需要注意: String char[] 其实是一样的.
 *  println中也重载了一个字符数组打印方法. char[]
 *  其他数组打印都会打印String.valueof(object)
 *  也就是会打印地址
 *  
 */
public class Demo {
	public static void main(String[] args) {
		int[] arr = { 1 };
		System.out.println(arr);

		char[] ch = { 'a', 'b' };
		System.out.println(ch);

		byte[] b = {};
		System.out.println(b);

		System.out.println("dd");
	}
}
